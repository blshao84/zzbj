# -*- coding: utf-8 -*-
# @Author : dongjianghai
# @File : enterprise_bl.py
# Introduction :

import datetime
import logging

import pandas as pd

from service import utils as utils

_date_format = '%Y-%m-%d'
_date_format_s = '%Y-%m-%d %H:%M:%S'


def get_base_elements(code):
    data = {'code': code}
    url = 'http://{ip}:{port}/base-element/search'.format(ip=utils.ip(), port=utils.port())
    params = {
        "id": None,
        "params": data
    }
    try:
        resp = utils.post(url=url, params=params)
        if 'error' in resp:
            raise RuntimeError('获取服务器excel配置未知异常')
        for re in resp:
            if re.get('status'):
                re['status'] = '1'
            else:
                re['status'] = '0'
        df1 = pd.DataFrame(resp)
        for df in df1:
            df1.rename(columns={df: hump2Underline(df)}, inplace=True)
        data = df1.to_dict(orient='records')
        return data
    except Exception as e:
        logging.error(repr(e))
        raise RuntimeError('获取服务器excel配置未知异常')


# 驼峰转下划线
def hump2Underline(text):
    res = []
    for index, char in enumerate(text):
        if char.isupper() and index != 0:
            res.append("_")
        res.append(char)
    return ''.join(res).lower()


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
