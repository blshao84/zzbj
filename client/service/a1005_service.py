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

CODE = 'A1005'
CODE_ADDITIONAL1 = 'A1005.1'
CODE_ADDITIONAL2 = 'A1005.2'
CODE_ADDITIONAL3 = 'A1005.3'
CODE_ADDITIONAL4 = 'A1005.4'
CODE_ADDITIONAL5 = 'A1005.5'
CODE_ADDITIONAL6 = 'A1005.6'
CODE_ADDITIONAL7 = 'A1005.7'
CODE_ADDITIONAL8 = 'A1005.8'


def build_master_agrmt(main, additional1, additional2, additional3, additional4, additional5, additional6, additional7,
                       additional8,
                       main_filter_cols=None, additional_filter_cols1=None, additional_filter_cols2=None,
                       additional_filter_cols3=None,
                       additional_filter_cols4=None, additional_filter_cols5=None, additional_filter_cols6=None,
                       additional_filter_cols7=None, additional_filter_cols8=None,
                       ):
    additional_map1 = {}
    additional_map2 = {}
    additional_map3 = {}
    additional_map4 = {}
    additional_map5 = {}
    additional_map6 = {}
    additional_map7 = {}
    additional_map8 = {}

    if additional1:
        for a in additional1:
            id = a.get('Parent_ID')
            service_utils.filter_field(a, additional_filter_cols1)
            additional_list = additional_map1.get(id)
            if additional_list:
                additional_list.append(a)
            else:
                additional_map1[id] = [a]
    if additional2:
        for a in additional2:
            id = a.get('Parent_ID')
            service_utils.filter_field(a, additional_filter_cols2)
            additional_list = additional_map2.get(id)
            if additional_list:
                additional_list.append(a)
            else:
                additional_map2[id] = [a]
    if additional3:
        for a in additional3:
            id = a.get('Parent_ID')
            service_utils.filter_field(a, additional_filter_cols3)
            additional_list = additional_map3.get(id)
            if additional_list:
                additional_list.append(a)
            else:
                additional_map3[id] = [a]
    if additional4:
        for a in additional4:
            id = a.get('Parent_ID')
            service_utils.filter_field(a, additional_filter_cols4)
            additional_list = additional_map4.get(id)
            if additional_list:
                additional_list.append(a)
            else:
                additional_map4[id] = [a]
    if additional5:
        for a in additional5:
            id = a.get('Parent_ID')
            service_utils.filter_field(a, additional_filter_cols5)
            additional_list = additional_map5.get(id)
            if additional_list:
                additional_list.append(a)
            else:
                additional_map5[id] = [a]
    if additional6:
        for a in additional6:
            id = a.get('Parent_ID')
            service_utils.filter_field(a, additional_filter_cols6)
            additional_list = additional_map6.get(id)
            if additional_list:
                additional_list.append(a)
            else:
                additional_map6[id] = [a]
    if additional7:
        for a in additional7:
            id = a.get('Parent_ID')
            service_utils.filter_field(a, additional_filter_cols7)
            additional_list = additional_map7.get(id)
            if additional_list:
                additional_list.append(a)
            else:
                additional_map7[id] = [a]
    if additional8:
        for a in additional8:
            id = a.get('Parent_ID')
            service_utils.filter_field(a, additional_filter_cols8)
            additional_list = additional_map8.get(id)
            if additional_list:
                additional_list.append(a)
            else:
                additional_map8[id] = [a]

    for m in main:
        #  甲方支付乙方
        m['PtyAtoPtyB'] = []
        #  乙方支付甲方
        m['PtyBtoPtyA'] = []
        # 甲方支付乙方浮动利率收益
        m['ReferenceARateBTuple'] = []
        #  乙方支付甲方浮动利率收益
        m['ReferenceBRateBTuple'] = []
        #   甲方支付乙方固定利率收益
        m['FixedARateReturnBTuple'] = []
        #  乙方支付甲方固定利率收益
        m['FixedBRateReturnBTuple'] = []
        #  履约担保品
        m['PerformanceCollTuple'] = []
        #  交易确认书附件
        m['ConfirmationAttTuple'] = []
        additional_list1 = additional_map1.get(m.get('MasterAgrmtNo'))
        additional_list2 = additional_map2.get(m.get('MasterAgrmtNo'))
        additional_list3 = additional_map3.get(m.get('MasterAgrmtNo'))
        additional_list4 = additional_map4.get(m.get('MasterAgrmtNo'))
        additional_list5 = additional_map5.get(m.get('MasterAgrmtNo'))
        additional_list6 = additional_map6.get(m.get('MasterAgrmtNo'))
        additional_list7 = additional_map7.get(m.get('MasterAgrmtNo'))
        additional_list8 = additional_map8.get(m.get('MasterAgrmtNo'))
        if additional_list1:
            m['PtyAtoPtyB'] = additional_list1
        if additional_list2:
            m['PtyBtoPtyA'] = additional_list2
        if additional_list3:
            m['ReferenceARateBTuple'] = additional_list3
        if additional_list4:
            m['ReferenceBRateBTuple'] = additional_list4
        if additional_list5:
            m['FixedARateReturnBTuple'] = additional_list5
        if additional_list6:
            m['FixedBRateReturnBTuple'] = additional_list6
        if additional_list7:
            m['PerformanceCollTuple'] = additional_list7
        if additional_list8:
            m['ConfirmationAttTuple'] = additional_list8
        service_utils.filter_field(m, main_filter_cols)
    return main


def parse_excel(report: SendReport):
    if isinstance(report, IndividualSendReport):
        elements1 = bl_ind.get_base_elements(CODE)
        elements2 = bl_ind.get_base_elements(CODE_ADDITIONAL1)
        elements3 = bl_ind.get_base_elements(CODE_ADDITIONAL2)
        elements4 = bl_ind.get_base_elements(CODE_ADDITIONAL3)
        elements5 = bl_ind.get_base_elements(CODE_ADDITIONAL4)
        elements6 = bl_ind.get_base_elements(CODE_ADDITIONAL5)
        elements7 = bl_ind.get_base_elements(CODE_ADDITIONAL6)
        elements8 = bl_ind.get_base_elements(CODE_ADDITIONAL7)
        elements9 = bl_ind.get_base_elements(CODE_ADDITIONAL8)

        n0 = OrderedDict()
        n1 = OrderedDict()
        n2 = OrderedDict()
        n3 = OrderedDict()
        n4 = OrderedDict()
        n5 = OrderedDict()
        n6 = OrderedDict()
        n7 = OrderedDict()
        n8 = OrderedDict()
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
        for element in elements6:
            if element['data_type'] == 'STRING':
                n5[element['element_name']] = str
        for element in elements7:
            if element['data_type'] == 'STRING':
                n6[element['element_name']] = str
        for element in elements8:
            if element['data_type'] == 'STRING':
                n7[element['element_name']] = str
        for element in elements9:
            if element['data_type'] == 'STRING':
                n8[element['element_name']] = str
        file_data_0 = excel_data.get_excel_data(n0, CODE, "sheet_0", report)
        file_data_1 = excel_data.get_excel_data(n1, CODE, "sheet_1", report)
        file_data_2 = excel_data.get_excel_data(n2, CODE, "sheet_2", report)
        file_data_3 = excel_data.get_excel_data(n3, CODE, "sheet_3", report)
        file_data_4 = excel_data.get_excel_data(n4, CODE, "sheet_4", report)
        file_data_5 = excel_data.get_excel_data(n5, CODE, "sheet_5", report)
        file_data_6 = excel_data.get_excel_data(n6, CODE, "sheet_6", report)
        file_data_7 = excel_data.get_excel_data(n7, CODE, "sheet_7", report)
        file_data_8 = excel_data.get_excel_data(n8, CODE, "sheet_8", report)

        df1 = pd.DataFrame(elements1)
        df2 = pd.DataFrame(elements2)
        df3 = pd.DataFrame(elements3)
        df4 = pd.DataFrame(elements4)
        df5 = pd.DataFrame(elements5)
        df6 = pd.DataFrame(elements6)
        df7 = pd.DataFrame(elements7)
        df8 = pd.DataFrame(elements8)
        df9 = pd.DataFrame(elements9)

        main_datas = bl_ind.extract_data(file_data_0, df1['element_name'].to_list())
        additional_datas1 = bl_ind.extract_data(file_data_1, df2['element_name'].to_list())
        additional_datas2 = bl_ind.extract_data(file_data_2, df3['element_name'].to_list())
        additional_datas3 = bl_ind.extract_data(file_data_3, df4['element_name'].to_list())
        additional_datas4 = bl_ind.extract_data(file_data_4, df5['element_name'].to_list())
        additional_datas5 = bl_ind.extract_data(file_data_5, df6['element_name'].to_list())
        additional_datas6 = bl_ind.extract_data(file_data_6, df7['element_name'].to_list())
        additional_datas7 = bl_ind.extract_data(file_data_7, df8['element_name'].to_list())
        additional_datas8 = bl_ind.extract_data(file_data_8, df9['element_name'].to_list())
    elif isinstance(report, EnterpriseSendReport):
        elements1 = bl_ent.get_base_elements(CODE)
        elements2 = bl_ent.get_base_elements(CODE_ADDITIONAL1)
        elements3 = bl_ent.get_base_elements(CODE_ADDITIONAL2)
        elements4 = bl_ent.get_base_elements(CODE_ADDITIONAL3)
        elements5 = bl_ent.get_base_elements(CODE_ADDITIONAL4)
        elements6 = bl_ent.get_base_elements(CODE_ADDITIONAL5)
        elements7 = bl_ent.get_base_elements(CODE_ADDITIONAL6)
        elements8 = bl_ent.get_base_elements(CODE_ADDITIONAL7)
        elements9 = bl_ent.get_base_elements(CODE_ADDITIONAL8)

        n0 = OrderedDict()
        n1 = OrderedDict()
        n2 = OrderedDict()
        n3 = OrderedDict()
        n4 = OrderedDict()
        n5 = OrderedDict()
        n6 = OrderedDict()
        n7 = OrderedDict()
        n8 = OrderedDict()
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
        for element in elements6:
            if element['data_type'] == 'STRING':
                n5[element['element_name']] = str
        for element in elements7:
            if element['data_type'] == 'STRING':
                n6[element['element_name']] = str
        for element in elements8:
            if element['data_type'] == 'STRING':
                n7[element['element_name']] = str
        for element in elements9:
            if element['data_type'] == 'STRING':
                n8[element['element_name']] = str
        file_data_0 = excel_data.get_excel_data(n0, CODE, "sheet_0", report)
        file_data_1 = excel_data.get_excel_data(n1, CODE, "sheet_1", report)
        file_data_2 = excel_data.get_excel_data(n2, CODE, "sheet_2", report)
        file_data_3 = excel_data.get_excel_data(n3, CODE, "sheet_3", report)
        file_data_4 = excel_data.get_excel_data(n4, CODE, "sheet_4", report)
        file_data_5 = excel_data.get_excel_data(n5, CODE, "sheet_5", report)
        file_data_6 = excel_data.get_excel_data(n6, CODE, "sheet_6", report)
        file_data_7 = excel_data.get_excel_data(n7, CODE, "sheet_7", report)
        file_data_8 = excel_data.get_excel_data(n8, CODE, "sheet_8", report)

        df1 = pd.DataFrame(elements1)
        df2 = pd.DataFrame(elements2)
        df3 = pd.DataFrame(elements3)
        df4 = pd.DataFrame(elements4)
        df5 = pd.DataFrame(elements5)
        df6 = pd.DataFrame(elements6)
        df7 = pd.DataFrame(elements7)
        df8 = pd.DataFrame(elements8)
        df9 = pd.DataFrame(elements9)

        main_datas = bl_ent.extract_data(file_data_0, df1['element_name'].to_list())
        additional_datas1 = bl_ent.extract_data(file_data_1, df2['element_name'].to_list())
        additional_datas2 = bl_ent.extract_data(file_data_2, df3['element_name'].to_list())
        additional_datas3 = bl_ent.extract_data(file_data_3, df4['element_name'].to_list())
        additional_datas4 = bl_ent.extract_data(file_data_4, df5['element_name'].to_list())
        additional_datas5 = bl_ent.extract_data(file_data_5, df6['element_name'].to_list())
        additional_datas6 = bl_ent.extract_data(file_data_6, df7['element_name'].to_list())
        additional_datas7 = bl_ent.extract_data(file_data_7, df8['element_name'].to_list())
        additional_datas8 = bl_ent.extract_data(file_data_8, df9['element_name'].to_list())
    else:
        logging.error('report type error:{0}'.format(report))

    datas = build_master_agrmt(main_datas, additional_datas1, additional_datas2, additional_datas3, additional_datas4,
                               additional_datas5, additional_datas6, additional_datas7, additional_datas8,
                               df1[df1['status'] == '0']['element_name'].to_list(),
                               df2[df2['status'] == '0']['element_name'].to_list(),
                               df3[df3['status'] == '0']['element_name'].to_list(),
                               df4[df4['status'] == '0']['element_name'].to_list(),
                               df5[df5['status'] == '0']['element_name'].to_list(),
                               df6[df6['status'] == '0']['element_name'].to_list(),
                               df7[df7['status'] == '0']['element_name'].to_list(),
                               df8[df8['status'] == '0']['element_name'].to_list(),
                               df9[df9['status'] == '0']['element_name'].to_list()
                               )
    report.jsonData = datas


def save_data(data):
    url = 'http://{ip}:{port}/swap-confirmation/excel/prepare'.format(ip=utils.ip(), port=utils.port())
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
    report.xlsxFileAbsName = 'D:/test/A1005.xlsx'
    report.isIndividual = True
    parse_excel(report)
    print(json.dumps(report.jsonData))
    # 保存A1005数据
    save_data(report.jsonData)
    pass
