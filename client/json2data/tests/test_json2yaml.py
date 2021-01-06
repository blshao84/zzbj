# -*- coding: utf-8 -*-
# @Author : dongjianghai
# @File : test_json2yaml.py


import json
import os

import re

from unittest import TestCase


from json2data.json2data.json2yaml import Json2Yaml

_r_pattern = []
_c_pattern = []
_u_pattern = []
_d_pattern = []

default_value = {
    'String': "",
    'Integer': 0,
    'Number': 0,
    'Map': {},
    'List': [],
    'Boolean': False
}

args_type_value = {
    'java.lang.String': "",
    'java.lang.Integer': 0,
    'java.lang.Number': 0,
    'java.util.Map': None,
    'java.util.List': None,
    'Boolean': False
}


def get_module():
    pass


def data_format(self, data):
    print("format_data start")
    result = {}
    for api_info in data['result']:
        if api_info['service'] in result:
            result[api_info['service']].append(api_info)
        else:
            result[api_info['service']] = [api_info]
    new_result = {}
    for service, api_infos in result.items():
        key = service
        new_result[key] = {}
        new_result[key]['path'] = key
        for api_info in api_infos:
            method = api_info['method']
            new_result[key][method] = api_info.copy()
            args = api_info['args']
            params = {}
            for arg in args:
                name = arg['name']
                type = arg['type']
                if '.' in type:
                    splits = type.split('.')
                    type = splits[len(splits) - 1]
                required = arg['required']
                if required:
                    params[name] = default_value.get(type, None)
                else:
                    params[name] = None
            if 'page' in params:
                params['page'] = 0
                params['pageSize'] = 10
            for k, value in params.items():
                if 'date' in k.lower():
                    params[k] = "2020-01-01"
            new_result[key][method]['params'] = params
            new_result[key][method].pop('args')
            new_result[key][method].pop('service')
    print("format_data end")
    return new_result


def is_match_patterns(patterns, string, unpatterns):
    match_flag = False
    except_flag = True
    if patterns:
        for p in patterns:
            if re.search(p, string, re.I):
                match_flag = True
                break
    if unpatterns:
        for p in unpatterns:
            if re.search(p, string, re.I):
                except_flag = False
                break

    return match_flag and except_flag


def data_format_group(data, group_name=None, patterns=None, unpatterns=None):
    res = {}
    _service = data['result'][0]['service']
    if group_name is not None:
        _service = group_name
    else:
        _service = data['result'][0]['service']

    res[_service] = {}
    # res[_service]['path'] = data['result'][0]['service']
    for n in data['result']:
        _api = n['method']
        _description = n['description']
        if (patterns is None or is_match_patterns(patterns, _api + _description, unpatterns) == True):
            res[_service][_api] = {}
            res[_service][_api]['description'] = n['description']
            res[_service][_api]['method'] = _api
            if len(n['args']) > 0:
                res[_service][_api]['params'] = {}
                for param in n['args']:
                    _param = param['name']
                    res[_service][_api]['params'][_param] = args_type_value.get(param['type'], None)
            if len(n['return-info']) > 0:
                _arr = []
                for col in n['return-info']:
                    _arr.append(col['name'])
                res[_service][_api]['return-info'] = _arr

    return res


def data_format_error(data, group_name=None, patterns=None):
    res = {}
    _service = data['result'][0]['service']
    if group_name is not None:
        _service = group_name
    else:
        _service = data['result'][0]['service']

    res[_service] = {}
    # res[_service]['path'] = data['result'][0]['service']
    for n in data['result']:
        _api = n['method']
        _description = n['description']
        if is_match_patterns(patterns, _api + _description, None) == False:
            res[_service][_api] = {}
            res[_service][_api]['description'] = n['description']
            res[_service][_api]['method'] = _api
            if len(n['args']) > 0:
                res[_service][_api]['params'] = {}
                for param in n['args']:
                    _param = param['name']
                    res[_service][_api]['params'][_param] = args_type_value.get(param['type'], None)
            if len(n['return-info']) > 0:
                _arr = []
                for col in n['return-info']:
                    _arr.append(col['name'])
                res[_service][_api]['return-info'] = _arr

    return res


def data_convert(self, data):
    print('api count:{0}'.format(len(data['result'])))

    _g2 = 'R'
    _p2 = ['list', '查询', 'paged', '获取','get']
    _res2 = data_format_group(data, _g2, _p2, ['save','upload','更新','保存'])
    # print('Rsearch api count:{0}'.format(len(_res2.keys())))

    _g3 = 'U'
    _p3 = ['update', '更新', '修改', '编辑', 'save', '保存','create', 'initialize']
    _res3 = data_format_group(data, _g3, _p3)
    # print('Create/Update api count:{0}'.format(len(_res3)))

    _g4 = 'D'
    _p4 = ['delete', '删除', '清空']
    _res4 = data_format_group(data, _g4, _p4)
    # print('Delete api count:{0}'.format(len(_res4)))

    _g5 = 'Unsafe'
    _p5 = _p2 + _p3 + _p4
    _res5 = data_format_error(data, _g5, _p5)
    # print('Error api count:{0}'.format(len(_res5)))

    return [_res2, _res3, _res4, _res5]


# Introduction :
class TestJson2Yaml(TestCase):
    def setUp(self):
        self.n = Json2Yaml()

    def test_file_2_file(self):
        parent_dir = os.path.dirname(os.path.abspath(__file__))
        yaml_file = os.path.join(parent_dir, 'test_json2yaml_temp2.yaml')
        self.n.file_2_file(os.path.abspath('test_json2yaml.json'), yaml_file, data_format_callback=data_convert)

    def test_file_2_string(self):
        file_path_name = os.path.abspath('test_json2yaml.json')
        res_data = self.n.file_2_string(file_path_name)
        print(res_data)

    def test_string_2_file(self):
        parent_dir = os.path.dirname(os.path.abspath(__file__))
        yaml_file = os.path.join(parent_dir, 'test_json2yaml_temp2.yaml')
        file_path_name = os.path.abspath('test_json2yaml.json')
        with open(file_path_name, 'r', encoding='utf8') as f:
            data = json.load(f)
            res_data = self.n.string_2_file(data, yaml_file)

    def test_string_2_string(self):
        file_path_name = os.path.abspath('test_json2yaml.json')
        with open(file_path_name, 'r', encoding='utf8') as f:
            data = json.load(f)
            res_data = self.n.string_2_string(data)
            print(res_data)
