import pandas as pd
from service import utils


def get_excel_data(n, CODE, sheet_number, report):
    file_data = pd.read_excel(report.xlsxFileAbsName,
                              sheet_name=utils.cfg().get(CODE).get(sheet_number).get('sheet_name'),
                              skiprows=2,
                              header=0,
                              keep_default_na=False,
                              converters=n)
    return file_data
