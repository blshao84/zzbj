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

CODE = 'A1009'
CODE_ADDITIONAL1 = 'A1009.1'


def build_master_agrmt(main, additional, main_filter_cols=None, additional_filter_cols=None):
    additional_map = {}
    if additional:
        for a in additional:
            id = a.get('Parent_ID')
            service_utils.filter_field(a, additional_filter_cols)
            additional_list = additional_map.get(id)
            if additional_list:
                additional_list.append(a)
            else:
                additional_map[id] = [a]
    for m in main:
        additional_list = additional_map.get(m.get('EventReportTuple'))
        if additional_list:
            m['EventReportTuple'] = additional_list
        else:
            m['EventReportTuple'] = []
        service_utils.filter_field(m, main_filter_cols)
    return main


def parse_excel(report: SendReport):
    if isinstance(report, IndividualSendReport):
        elements1 = bl_ind.get_base_elements(CODE)
        elements2 = bl_ind.get_base_elements(CODE_ADDITIONAL1)

        n0 = OrderedDict()
        n1 = OrderedDict()
        for element in elements1:
            if element['data_type'] == 'STRING':
                n0[element['element_name']] = str
        for element in elements2:
            if element['data_type'] == 'STRING':
                n1[element['element_name']] = str
        file_data_0 = excel_data.get_excel_data(n0, CODE, "sheet_0", report)
        file_data_1 = excel_data.get_excel_data(n1, CODE, "sheet_1", report)

        df1 = pd.DataFrame(elements1)
        df2 = pd.DataFrame(elements2)

        main_datas = bl_ind.extract_data(file_data_0, df1['element_name'].to_list())
        additional_datas1 = bl_ind.extract_data(file_data_1, df2['element_name'].to_list())
    elif isinstance(report, EnterpriseSendReport):
        elements1 = bl_ent.get_base_elements(CODE)
        elements2 = bl_ent.get_base_elements(CODE_ADDITIONAL1)

        n0 = OrderedDict()
        n1 = OrderedDict()
        for element in elements1:
            if element['data_type'] == 'STRING':
                n0[element['element_name']] = str
        for element in elements2:
            if element['data_type'] == 'STRING':
                n1[element['element_name']] = str
        file_data_0 = excel_data.get_excel_data(n0, CODE, "sheet_0", report)
        file_data_1 = excel_data.get_excel_data(n1, CODE, "sheet_1", report)

        df1 = pd.DataFrame(elements1)
        df2 = pd.DataFrame(elements2)

        main_datas = bl_ent.extract_data(file_data_0, df1['element_name'].to_list())
        additional_datas1 = bl_ent.extract_data(file_data_1, df2['element_name'].to_list())
    else:
        logging.error('report type error:{0}'.format(report))

    datas = build_master_agrmt(main_datas, additional_datas1, df1[df1['status'] == '0']['element_name'].to_list(),
                               df2[df2['status'] == '0']['element_name'].to_list())
    report.jsonData = datas


def save_data(data):
    url = 'http://{ip}:{port}/event-report/excel/prepare'.format(ip=utils.ip(), port=utils.port())
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
    report.xlsxFileAbsName = 'D:/test/A1009.xlsx'
    report.isIndividual = True
    parse_excel(report)
    print(json.dumps(report.jsonData))
    # 保存A1009数据
    save_data(report.jsonData)
    pass
