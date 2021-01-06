import pandas as pd
import xlwings as xw

from service import enterprise_bl as bl_ent
from service import individual_bl as bl_ind
from service import utils
from service.entity.sendReport import *
import os
from collections import OrderedDict
from service import excel_data

CODE = 'A1011'
CODE_ADDITIONAL1 = 'A1011.1'
CODE_ADDITIONAL2 = 'A1011.2'
CODE_ADDITIONAL3 = 'A1011.3'


def build_sac_data(main, additional_list1, additional_list2, additional_list3, main_filter_cols=None,
                   additional_filter_cols1=None, additional_filter_cols2=None, additional_filter_cols3=None):
    # 本月新增业务明细
    main['IncreaseBusinessDetailsThisMonthTuple'] = utils.filter_field(additional_list1, additional_filter_cols1)
    # 本月末存量业务明细
    main['InventoryBusinessDetailsAtTheEndOfThisMonth'] = utils.filter_field(additional_list2, additional_filter_cols2)
    # 标的情况与对冲
    main['TargetCaseAndHedgeTuple'] = utils.filter_field(additional_list3, additional_filter_cols3)
    utils.filter_field(main, main_filter_cols)
    return main


def process_data(sheet0, sheet1, sheet2, additional_datas1, additional_datas2,
                 additional_datas3, service, cols_df1, cols_df2, cols_df3):
    cols_df0 = pd.DataFrame(service.get_base_elements(CODE))
    main = {}
    for element in cols_df0.to_dict(orient='records'):
        range = element['excel_range']
        if range:
            # 格式化数据
            if element['excel_sheet'] == utils.cfg().get(CODE).get('sheet_0').get('sheet_name'):
                main[element['element_name']] = utils.format_date_value(sheet0[range].value)
            if element['excel_sheet'] == utils.cfg().get(CODE).get('sheet_4').get('sheet_name'):
                main[element['element_name']] = utils.format_date_value(sheet1[range].value)
            if element['excel_sheet'] == utils.cfg().get(CODE).get('sheet_5').get('sheet_name'):
                main[element['element_name']] = utils.format_date_value(sheet2[range].value)
        else:
            main[element['element_name']] = None
        if service == bl_ent:
            if main[element['element_name']] is None:
                main[element['element_name']] = ''

    additional_datas1 = service.extract_data(additional_datas1, cols_df1['element_name'].to_list())
    additional_datas2 = service.extract_data(additional_datas2, cols_df2['element_name'].to_list())
    additional_datas3 = service.extract_data(additional_datas3, cols_df3['element_name'].to_list())
    json_data = build_sac_data(main,
                               additional_datas1,
                               additional_datas2,
                               additional_datas3,
                               cols_df0[cols_df0['status'] == '0']['element_name'].to_list(),
                               cols_df1[cols_df1['status'] == '0']['element_name'].to_list(),
                               cols_df2[cols_df2['status'] == '0']['element_name'].to_list(),
                               cols_df3[cols_df3['status'] == '0']['element_name'].to_list(),
                               )
    return json_data


def parse_excel(report: SendReport):
    app = xw.App(visible=False, add_book=False)
    wb = app.books.open(report.xlsxFileAbsName)
    sheet0 = wb.sheets[utils.cfg().get(CODE).get('sheet_0').get('sheet_name')]
    sheet1 = wb.sheets[utils.cfg().get(CODE).get('sheet_4').get('sheet_name')]
    sheet2 = wb.sheets[utils.cfg().get(CODE).get('sheet_5').get('sheet_name')]

    if isinstance(report, IndividualSendReport):
        elements1 = bl_ind.get_base_elements(CODE_ADDITIONAL1)
        elements2 = bl_ind.get_base_elements(CODE_ADDITIONAL2)
        elements3 = bl_ind.get_base_elements(CODE_ADDITIONAL3)
        cols_df1 = pd.DataFrame(elements1)
        cols_df2 = pd.DataFrame(elements2)
        cols_df3 = pd.DataFrame(elements3)

        n1 = OrderedDict()
        n2 = OrderedDict()
        n3 = OrderedDict()
        for element in elements1:
            if element['data_type'] == 'STRING':
                n1[element['element_name']] = str
        for element in elements2:
            if element['data_type'] == 'STRING':
                n2[element['element_name']] = str
        for element in elements3:
            if element['data_type'] == 'STRING':
                n3[element['element_name']] = str

        additional_data1 = excel_data.get_excel_data(n1, CODE, "sheet_1", report)
        additional_data2 = excel_data.get_excel_data(n2, CODE, "sheet_2", report)
        additional_data3 = excel_data.get_excel_data(n3, CODE, "sheet_3", report)

        data = process_data(sheet0, sheet1, sheet2, additional_data1, additional_data2,
                            additional_data3, bl_ind, cols_df1, cols_df2, cols_df3)
    else:
        elements1 = bl_ent.get_base_elements(CODE_ADDITIONAL1)
        elements2 = bl_ent.get_base_elements(CODE_ADDITIONAL2)
        elements3 = bl_ent.get_base_elements(CODE_ADDITIONAL3)
        cols_df1 = pd.DataFrame(elements1)
        cols_df2 = pd.DataFrame(elements2)
        cols_df3 = pd.DataFrame(elements3)
        n1 = OrderedDict()
        n2 = OrderedDict()
        n3 = OrderedDict()
        for element in elements1:
            if element['data_type'] == 'STRING':
                n1[element['element_name']] = str
        for element in elements2:
            if element['data_type'] == 'STRING':
                n2[element['element_name']] = str
        for element in elements3:
            if element['data_type'] == 'STRING':
                n3[element['element_name']] = str

        additional_data1 = excel_data.get_excel_data(n1, CODE, "sheet_1", report)
        additional_data2 = excel_data.get_excel_data(n2, CODE, "sheet_2", report)
        additional_data3 = excel_data.get_excel_data(n3, CODE, "sheet_3", report)

        data = process_data(sheet0, sheet1, sheet2, additional_data1, additional_data2,
                            additional_data3, bl_ent, cols_df1, cols_df2, cols_df3)
    report.jsonData = data
    wb.close()
    app.quit()


def save_data(data):
    url = 'http://{ip}:{port}/pr-sac/excel/prepare'.format(ip=utils.ip(), port=utils.port())
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
    report.xlsxFileAbsName = 'D:/test/A1011.xlsx'
    report.isIndividual = True
    parse_excel(report)
    print(report.jsonData)
    # 保存A1011数据
    save_data(report.jsonData)
    pass
