import pandas as  pd

from service.db_helper import Pg_Helper

if __name__ == '__main__':
    a1011_datas = pd.read_excel('中证协议字段_merged.xlsx',
                                sheet_name='A1011',
                                header=0,
                                keep_default_na=False)
    a1012_datas = pd.read_excel('中证协议字段_merged.xlsx',
                                sheet_name='A1012',
                                header=0,
                                keep_default_na=False)
    a1013_datas = pd.read_excel('中证协议字段_merged.xlsx',
                                sheet_name='A1013',
                                header=0,
                                keep_default_na=False)

    datas = pd.concat([a1011_datas, a1012_datas, a1013_datas]).to_dict(orient='records')
    db = Pg_Helper
    for element in datas:
        if element.get('excel_range') is None or element.get('excel_range') == '':
            continue
        sql = "update \"commerce_model\".\"base_element\"  " \
              " set excel_range ='{0}'," \
              " excel_sheet='{1}' " \
              "where code ='{2}' and element_name='{3}' ;". \
            format(
            element.get('excel_range'),
            element.get('excel_sheet'),
            element.get('code'),
            element.get('element_name')
        )
        print(sql)
        # db.execute(sql)
