# -*- coding: utf-8 -*-
# @Author : dongjianghai
# @File : json2yaml.py
# Introduction :

import json

import yaml


class Json2Yaml(object):
    def __init__(self):
        pass

    def __load_json(self, json_file_path_name):
        with open(json_file_path_name, 'r', encoding='utf8') as f:
            data = json.load(f)
            return data
        return None

    def string_2_string(self, json_data):
        yaml_body = yaml.dump(data=json_data, allow_unicode=True)
        return yaml_body

    def file_2_string(self, json_file_path_name):
        data = self.__load_json(json_file_path_name)
        return self.string_2_string(data)

    def string_2_file(self, json_data, yaml_file_path_name):
        with open(yaml_file_path_name, 'w', encoding='utf8') as f:
            yaml.dump(json_data, f, allow_unicode=True)

    def file_2_file(self, json_file_path_name, yaml_file_path_name, data_format_callback=None):
        data = self.__load_json(json_file_path_name)
        if data_format_callback:
            data = data_format_callback(self, data)
        self.string_2_file(data, yaml_file_path_name)
