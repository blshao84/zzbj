# -*- coding: utf-8 -*-
# @Author : dongjianghai
# @File : yaml2json.py
# Introduction :

import json
import yaml

class Yaml2Json(object):
    def __init__(self):
        pass

    def __load_yaml(self, yaml_file_path_name):
        with open(yaml_file_path_name, 'r', encoding='utf8') as f:
            data = yaml.load(f, Loader=yaml.FullLoader)
            return data

        return None

    def string_2_string(self, yaml_data):
        json_body = json.dumps(yaml_data)
        return json_body

    def file_2_string(self, yaml_file_path_name):
        data = self.__load_yaml(yaml_file_path_name)
        return self.string_2_string(data)

    def string_2_file(self, yaml_data, json_file_path_name):
        with open(json_file_path_name, 'w', encoding='utf8') as f:
            json.dump(yaml_data, f)

    def file_2_file(self, yaml_file_path_name, json_file_path_name):
        data = self.__load_yaml(yaml_file_path_name)
        self.string_2_file(data, json_file_path_name)