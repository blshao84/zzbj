# -*- coding: utf-8 -*-
# @Author : dongjianghai
# @File : individual_bl.py
# Introduction :

import collections
import datetime

from service.db_helper import Lite_Helper as Lite_Helper

_date_format = '%Y-%m-%d'
_date_format_s = '%Y-%m-%d %H:%M:%S'


def get_base_elements(code):
    if code:
        sql = "select * from base_element where code='{code}' order by sort asc;".format(code=code)
    else:
        sql = "select * from base_element order by sort asc ;"
    db_util = Lite_Helper()
    return db_util.query_for_dict(sql)


def convert_data(row, datas, columns):
    node = {}
    for col in columns:
        value = row.get(col)
        if value is not None:
            if isinstance(value, datetime.datetime):
                value = value.strftime(_date_format)
            elif isinstance(value, datetime.date):
                value = value.strftime(_date_format)
            elif check_time_format(value) == '1':
                # str to date
                value = datetime.datetime.strptime(value, _date_format_s)
                # date formatting
                value = value.strftime(_date_format)
            elif check_time_format(value) == '2':
                # str to date
                value = value.strftime(value, _date_format)
                # date formatting
                value = value.strftime(_date_format)
            node[col] = str(value)
        else:
            node[col] = ''
    datas.append(node)


def extract_data(df_data, cols):
    datas = []
    df_data.apply(lambda row: convert_data(row, datas, cols),
                  axis=1)
    return datas


def check_time_format(date):
    try:
        if ":" in date:
            datetime.datetime.strptime(date, _date_format_s)
            return '1'
        else:
            datetime.datetime.strptime.strptime(date, _date_format)
            return '2'
    except:
        return '0'
