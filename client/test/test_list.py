# -*- coding: utf-8 -*-

import pytest


# 整体启动开始f
def setup_function():
    print("------->Testing Running")


# 整体关闭开始
def teardown_function():
    print("------->Testing End")


# 启动测试检查
if __name__ == '__main__':
    pytest.main()

"""

"""
