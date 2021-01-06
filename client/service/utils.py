# -*- coding: utf-8 -*-
# @Author : dongjianghai
# @File : utils.py
# Introduction :
# 该文件作为静态程序可自由拷贝及编辑，本处仅作为标准版本维护
# 本文件使用的login采用BSF/BCT标准登陆模式


import datetime
import json
import logging
import os

import requests
import yaml

import zipfile
import hashlib
import xmltodict
from datetime import datetime

CONFIG_PATH_NAME = None
LOGIN_TOKEN = None


def cfg():
    if CONFIG_PATH_NAME is None:
        raise ValueError('CONFIG_PATH_NAME is None')

    with open(CONFIG_PATH_NAME, mode='r', encoding='utf8') as f:
        cof = yaml.load(f, Loader=yaml.FullLoader)
        return cof


def even():
    return cfg().get('even')


def get_even_config_value(key):
    return cfg().get(even()).get(key)


def ip():
    return get_even_config_value('ip')


def port():
    return get_even_config_value('port')


def username():
    return get_even_config_value('username')


def pwd():
    return get_even_config_value('pwd')


def token():
    return LOGIN_TOKEN


def headers():
    headers = {
        'Authorization': 'Bearer ' + token()
    }
    return headers


def update_token():
    if get_even_config_value('login_type') == 'token':
        return get_even_config_value('token')
    else:
        return login(username(), pwd())


def login(username, password, host=None):
    """ Log in to get a token for subsequent remote calls
    """
    if host:
        url = 'http://{host}/auth-service/users/login'.format(host=host)
    else:
        url = 'http://{ip}:{port}/auth-service/users/login'.format(ip=ip(), port=port())

    body = {
        'username': username,
        'password': password
    }
    res = requests.post(url, json=body)
    try:
        json = res.json()
    except Exception as e:
        print(e)
        print('\t=>' + res.text)
        print(res.headers)
        raise RuntimeError('error logging in: ')
    if 'error' in json:
        raise RuntimeError('error logging in: ' + json['error']['message'])
    return json['result']['token']


def get_file_path(file_name, folde_name=None):
    path = os.path.abspath(os.path.dirname(os.path.dirname(__file__)))
    if folde_name:
        return os.path.join(path, folde_name, file_name)
    else:
        return os.path.join(path, file_name)


def set_logging(level=logging.INFO, logFileName='log.txt'):
    logger = logging.getLogger()
    logger.setLevel(level)
    formatter = logging.Formatter("%(asctime)s - %(filename)s[line:%(lineno)d] - %(levelname)s: %(message)s")

    if logFileName:
        file_name = get_file_path(logFileName, 'log')
        fh = logging.FileHandler(file_name, mode='w')
        # fh = logging.FileHandler("./log/{0}".format(logFileName), mode='w')
        fh.setLevel(level)

        fh.setFormatter(formatter)
        logger.addHandler(fh)

    ch = logging.StreamHandler()
    ch.setLevel(level)
    ch.setFormatter(formatter)
    logger.addHandler(ch)


def set_logging_by_config():
    level = get_even_config_value('logging_level')
    filename = get_even_config_value('logging_filename')
    set_logging(level=level, logFileName=filename)


def call_request(service, method, params, headers=None, ip=None, port=None):
    if headers is None:
        headers = headers()

    if ip is None:
        ip = ip()

    if port is None:
        port = port()

    url = 'http://' + ip + ':' + port + '/' + service + '/api/rpc'
    body = {
        'method': method,
        'params': params
    }

    try:
        res = requests.post(url, json=body, headers=headers)
        json = res.json()
        if 'error' in json:
            logging.info("failed execute " + method + " to:" + ip + ",error:" + str(json['error']))
        else:
            logging.info("success execute " + method + ",callRequest:" + str(len(params)) + " to " + ip)
        return json
    except Exception as e:
        logging.info("failed execute " + method + " to:" + ip + "Exception:" + str(e))
        raise e


def get(url, params, headers=None):
    resp = requests.get(url=url, params=params)
    result = resp.json()
    return result


def post(url, params, headers=None):
    resp = requests.post(url=url, json=params)
    result = resp.json()
    return result


def post_form_data(url, params, headers=None):
    resp = requests.post(url=url, data=params, headers={'Content-Type': 'application/x-www-form-urlencoded'})
    result = resp.json()
    return result

def post_file_data(url, params, headers=None):
    resp = requests.post(url=url, files=params)
    result = resp
    return result

def post_file_with_code(url, files, code, headers=None):
    payload = {'code': code}
    if headers is None:
        headers = {}
    requests.request("POST", url, headers=headers, data=payload, files=files)

def put(url, params, headers=None):
    resp = requests.put(url=url, json=params)
    result = resp.json()
    return result


def format_date_value(date_value):
    _format = '%Y-%m-%d'
    if date_value:
        if isinstance(date_value, datetime.datetime):
            return date_value.strftime(_format)
        if isinstance(date_value, datetime.date):
            return date_value.strftime(_format)
    return date_value


def fill_nan(value):
    if value is not None:
        return str(value)
    return ''


def convert_data(row, datas, columns):
    node = {}
    for col in columns:
        row[col] = format_date_value(row.get(col))
        row[col] = fill_nan(row.get(col))
        node[col] = row[col]
    datas.append(node)


def filter_field(data, clos=None):
    if clos and data:
        if isinstance(data, list):
            for d in data:
                for col in clos:
                    if col in d:
                        del d[col]
        if isinstance(data, dict):
            for col in clos:
                if col in data:
                    del data[col]
    return data


def load_json_from_file(parent_dir, folder_name, file_name):
    file_path = os.path.join(parent_dir, folder_name, file_name)
    with open(file_path, 'r', encoding='utf8') as f:
        data = json.load(f)
        return data


def unzip_file(src, dist):
    with zipfile.ZipFile(src, 'r') as zip_ref:
        zip_ref.extractall(dist)


def xml_to_dict(path):
    with open(path, encoding='UTF-8') as fd:
        return xmltodict.parse(fd.read())


def convert_dict(dict_data):
    if isinstance(dict_data, list):
        new_data = []
        for d in dict_data:
            new_data.append(convert_dict(d))
        return frozenset(new_data)
    elif isinstance(dict_data, dict):
        new_data = []
        for k in dict_data:
            new_data.append((k, convert_dict(dict_data[k])))
        return frozenset(new_data)
    else:
        return dict_data


def file_md5(path):
    with open(path, 'rb') as fp:
        data = fp.read()
    return hashlib.md5(data).hexdigest()