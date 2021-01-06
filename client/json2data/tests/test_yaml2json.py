# -*- coding: utf-8 -*-
# @Author : dongjianghai
# @File : test_json2yaml.py


import os
import sys

import json
import yaml

from unittest import TestCase
from json2data.json2data.yaml2json import Yaml2Json

# Introduction :
class TestYaml2Json(TestCase):
    def setUp(self):
        self.n = Yaml2Json()

    def test_file_2_file(self):
        parent_dir = os.path.dirname(os.path.abspath(__file__))
        file_name = os.path.join(parent_dir, 'test_yaml2json_temp1.json')
        self.n.file_2_file(os.path.abspath('test_yaml2json.yaml'), file_name)

    def test_file_2_string(self):
        file_path_name = os.path.abspath('test_yaml2json.yaml')
        res_data = self.n.file_2_string(file_path_name)
        print(res_data)

    def test_string_2_file(self):
        parent_dir = os.path.dirname(os.path.abspath(__file__))
        file_name = os.path.join(parent_dir, 'test_yaml2json_temp2.json')
        file_path_name = os.path.abspath('test_yaml2json.yaml')
        with open(file_path_name, 'r', encoding='utf8') as f:
            data = yaml.load(f, Loader=yaml.FullLoader)
            res_data = self.n.string_2_file(data, file_name)

    def test_string_2_string(self):
        file_path_name = os.path.abspath('test_yaml2json.yaml')
        with open(file_path_name, 'r', encoding='utf8') as f:
            data = yaml.load(f, Loader=yaml.FullLoader)
            res_data = self.n.string_2_string(data)
            print(res_data)
