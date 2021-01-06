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

CODE = 'A1015'
CODE_ADDITIONAL1 = 'A1015.1'
CODE_ADDITIONAL2 = 'A1015.2'
CODE_ADDITIONAL3 = 'A1015.3'
CODE_ADDITIONAL4 = 'A1015.4'


def build_master_agrmt(main, additional1, additional2, additional3, additional4, main_filter_cols=None,
                       additional_filter_cols1=None, additional_filter_cols2=None, additional_filter_cols3=None,
                       additional_filter_cols4=None):
    additional_map1 = {}
    additional_map2 = {}
    additional_map3 = {}
    additional_map4 = {}
    if additional1:
        for a in additional1:
            id = a.get('Parent_ID')
            utils.filter_field(a, additional_filter_cols1)
            additional_list = additional_map1.get(id)
            if additional_list:
                additional_list.append(a)
            else:
                additional_map1[id] = [a]
    if additional2:
        for a in additional2:
            id = a.get('Parent_ID')
            utils.filter_field(a, additional_filter_cols2)
            additional_list = additional_map2.get(id)
            if additional_list:
                additional_list.append(a)
            else:
                additional_map2[id] = [a]
    if additional3:
        for a in additional3:
            id = a.get('Parent_ID')
            utils.filter_field(a, additional_filter_cols3)
            additional_list = additional_map3.get(id)
            if additional_list:
                additional_list.append(a)
            else:
                additional_map3[id] = [a]
    if additional4:
        for a in additional4:
            id = a.get('Parent_ID')
            utils.filter_field(a, additional_filter_cols4)
            additional_list = additional_map4.get(id)
            if additional_list:
                additional_list.append(a)
            else:
                additional_map4[id] = [a]

    for m in main:
        additional_list1 = additional_map1.get(m.get('MasterAgrmtTuple'))
        additional_list2 = additional_map2.get(m.get('SupAgrmtTuple'))
        additional_list3 = additional_map3.get(m.get('OptionConfirmationTuple'))
        additional_list4 = additional_map4.get(m.get('SwapConfirmationTuple'))
        if additional_list1:
            m['MasterAgrmtTuple'] = additional_list1
        else:
            m['MasterAgrmtTuple'] = []
        if additional_list2:
            m['SupAgrmtTuple'] = additional_list2
        else:
            m['SupAgrmtTuple'] = []
        if additional_list3:
            m['OptionConfirmationTuple'] = additional_list3
        else:
            m['OptionConfirmationTuple'] = []
        if additional_list4:
            m['SwapConfirmationTuple'] = additional_list4
        else:
            m['SwapConfirmationTuple'] = []
        utils.filter_field(m, main_filter_cols)
    return main


def parse_excel(report: SendReport):
    if isinstance(report, IndividualSendReport):
        elements1 = bl_ind.get_base_elements(CODE)
        elements2 = bl_ind.get_base_elements(CODE_ADDITIONAL1)
        elements3 = bl_ind.get_base_elements(CODE_ADDITIONAL2)
        elements4 = bl_ind.get_base_elements(CODE_ADDITIONAL3)
        elements5 = bl_ind.get_base_elements(CODE_ADDITIONAL4)

        n0 = OrderedDict()
        n1 = OrderedDict()
        n2 = OrderedDict()
        n3 = OrderedDict()
        n4 = OrderedDict()

        for element in elements1:
            if element['data_type'] == 'STRING':
                n0[element['element_name']] = str
        for element in elements2:
            if element['data_type'] == 'STRING':
                n1[element['element_name']] = str
        for element in elements3:
            if element['data_type'] == 'STRING':
                n2[element['element_name']] = str
        for element in elements4:
            if element['data_type'] == 'STRING':
                n3[element['element_name']] = str
        for element in elements5:
            if element['data_type'] == 'STRING':
                n4[element['element_name']] = str
        file_data_0 = excel_data.get_excel_data(n0, CODE, "sheet_0", report)
        file_data_1 = excel_data.get_excel_data(n1, CODE, "sheet_1", report)
        file_data_2 = excel_data.get_excel_data(n2, CODE, "sheet_2", report)
        file_data_3 = excel_data.get_excel_data(n3, CODE, "sheet_3", report)
        file_data_4 = excel_data.get_excel_data(n4, CODE, "sheet_4", report)

        df1 = pd.DataFrame(elements1)
        df2 = pd.DataFrame(elements2)
        df3 = pd.DataFrame(elements3)
        df4 = pd.DataFrame(elements4)
        df5 = pd.DataFrame(elements5)

        main_datas = bl_ind.extract_data(file_data_0, df1['element_name'].to_list())
        additional_datas1 = bl_ind.extract_data(file_data_1, df2['element_name'].to_list())
        additional_datas2 = bl_ind.extract_data(file_data_2, df3['element_name'].to_list())
        additional_datas3 = bl_ind.extract_data(file_data_3, df4['element_name'].to_list())
        additional_datas4 = bl_ind.extract_data(file_data_4, df5['element_name'].to_list())
    elif isinstance(report, EnterpriseSendReport):
        elements1 = bl_ent.get_base_elements(CODE)
        elements2 = bl_ent.get_base_elements(CODE_ADDITIONAL1)
        elements3 = bl_ent.get_base_elements(CODE_ADDITIONAL2)
        elements4 = bl_ent.get_base_elements(CODE_ADDITIONAL3)
        elements5 = bl_ent.get_base_elements(CODE_ADDITIONAL4)

        n0 = OrderedDict()
        n1 = OrderedDict()
        n2 = OrderedDict()
        n3 = OrderedDict()
        n4 = OrderedDict()

        for element in elements1:
            if element['data_type'] == 'STRING':
                n0[element['element_name']] = str
        for element in elements2:
            if element['data_type'] == 'STRING':
                n1[element['element_name']] = str
        for element in elements3:
            if element['data_type'] == 'STRING':
                n2[element['element_name']] = str
        for element in elements4:
            if element['data_type'] == 'STRING':
                n3[element['element_name']] = str
        for element in elements5:
            if element['data_type'] == 'STRING':
                n4[element['element_name']] = str
        file_data_0 = excel_data.get_excel_data(n0, CODE, "sheet_0", report)
        file_data_1 = excel_data.get_excel_data(n1, CODE, "sheet_1", report)
        file_data_2 = excel_data.get_excel_data(n2, CODE, "sheet_2", report)
        file_data_3 = excel_data.get_excel_data(n3, CODE, "sheet_3", report)
        file_data_4 = excel_data.get_excel_data(n4, CODE, "sheet_4", report)

        df1 = pd.DataFrame(elements1)
        df2 = pd.DataFrame(elements2)
        df3 = pd.DataFrame(elements3)
        df4 = pd.DataFrame(elements4)
        df5 = pd.DataFrame(elements5)

        main_datas = bl_ent.extract_data(file_data_0, df1['element_name'].to_list())
        additional_datas1 = bl_ent.extract_data(file_data_1, df2['element_name'].to_list())
        additional_datas2 = bl_ent.extract_data(file_data_2, df3['element_name'].to_list())
        additional_datas3 = bl_ent.extract_data(file_data_3, df4['element_name'].to_list())
        additional_datas4 = bl_ent.extract_data(file_data_4, df5['element_name'].to_list())
    else:
        logging.error('report type error:{0}'.format(report))

    datas = build_master_agrmt(main_datas, additional_datas1, additional_datas2, additional_datas3, additional_datas4,
                               df1[df1['status'] == '0']['element_name'].to_list(),
                               df2[df2['status'] == '0']['element_name'].to_list(),
                               df3[df3['status'] == '0']['element_name'].to_list(),
                               df4[df4['status'] == '0']['element_name'].to_list(),
                               df5[df5['status'] == '0']['element_name'].to_list())
    report.jsonData = datas


def save_data(data):
    url = 'http://{ip}:{port}/contract-number/excel/prepare'.format(ip=utils.ip(), port=utils.port())
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
    report.xlsxFileAbsName = 'D:/test/A1015.xlsx'
    report.isIndividual = True
    parse_excel(report)
    print(json.dumps(report.jsonData))
    # 保存A1015数据
    save_data(report.jsonData)
    pass
