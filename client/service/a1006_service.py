import json
import logging

import pandas as pd

from service import enterprise_bl as bl_ent
from service import individual_bl as bl_ind
from service.entity.sendReport import *
from service import utils as utils
from service import service_utils
import os
from collections import OrderedDict
from service import excel_data

CODE = 'A1006'


def build_master_agrmt(main, main_filter_cols=None):
    for m in main:
        service_utils.filter_field(m, main_filter_cols)
    return main


def parse_excel(report: SendReport):
    if isinstance(report, IndividualSendReport):
        elements1 = bl_ind.get_base_elements(CODE)

        n0 = OrderedDict()
        for element in elements1:
            if element['data_type'] == 'STRING':
                n0[element['element_name']] = str
        file_data_0 = excel_data.get_excel_data(n0, CODE, "sheet_0", report)

        df1 = pd.DataFrame(elements1)
        main_datas = bl_ind.extract_data(file_data_0, df1['element_name'].to_list())
    elif isinstance(report, EnterpriseSendReport):
        elements1 = bl_ent.get_base_elements(CODE)

        n0 = OrderedDict()
        for element in elements1:
            if element['data_type'] == 'STRING':
                n0[element['element_name']] = str
        file_data_0 = excel_data.get_excel_data(n0, CODE, "sheet_0", report)

        df1 = pd.DataFrame(elements1)
        main_datas = bl_ent.extract_data(file_data_0, df1['element_name'].to_list())
    else:
        logging.error('report type error:{0}'.format(report))

    datas = build_master_agrmt(main_datas, df1[df1['status'] == '0']['element_name'].to_list())
    report.jsonData = datas


def save_data(data):
    url = 'http://{ip}:{port}/swap-termination/excel/prepare'.format(ip=utils.ip(), port=utils.port())
    params = {
        "params": data
    }
    resp = utils.post(url=url, params=params)


if __name__ == '__main__':
    parent_dir = os.path.dirname(os.path.abspath(__file__))
    config_file = os.path.join(parent_dir, '../client_enterprise/config.yaml')
    utils.CONFIG_PATH_NAME = config_file
    utils.set_logging_by_config()

    report = EnterpriseSendReport()
    report.xlsxFileAbsName = 'D:/test/A1006.xlsx'
    report.isIndividual = True
    parse_excel(report)
    print(json.dumps(report.jsonData))
    # 保存A1006数据
    save_data(report.jsonData)
    pass
