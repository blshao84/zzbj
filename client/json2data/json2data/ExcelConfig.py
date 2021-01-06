# -*- coding: utf-8 -*-
# @Author : dongjianghai
# @File : ExcelConfig.py
# Introduction :

class ExcelConfig():
    def __init__(self, file_name=None, init_sheet=False, data_sheet_names=[]):
        self._file_name = file_name
        self._data_sheet_names = data_sheet_names
        self._init_sheet = init_sheet
        self._default_sheet_name = 'sheet0'