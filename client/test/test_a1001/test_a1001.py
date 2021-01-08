# -*- coding: utf-8 -*-

import os
import pytest
from test import test_utils
from datetime import datetime
from xmldiff.main import diff_files
from service import utils


def setup_module():
    print("\n-------> 报告类型：A1001 -------> 报送方式：A -------> 准备数据开始\n")


def teardown_module():
    print("\n-------> 报告类型：A1001 -------> 报送方式：A -------> 清理数据开始\n")


@pytest.mark.run(order=1)
def test_a1001_add():
    today_dash = datetime.today().strftime('%Y-%m-%d')
    today_no_dash = datetime.today().strftime('%Y%m%d')
    parent_dir = os.path.dirname(os.path.abspath(__file__))

    test_utils.prepare('A1001', 'A', 'A1001主协议列表.xlsx', ['A100101.pdf'], '0001')

    original_xml_path = os.path.join(parent_dir, '../template/A1001/A/A1001_A.xml')
    original_xml = utils.xml_to_dict(original_xml_path)
    original_xml['Root']['Header']['SendDate'] = today_dash
    del original_xml['Root']['Body']['MasterAgrmt']['ExceID']
    zip_xml_path = os.path.join(parent_dir, '../template/A1001/A/OTC_000023_000020_'
                                + today_no_dash + '_0001_A1001_A.xml')
    zip_xml = utils.xml_to_dict(zip_xml_path)
    del zip_xml['Root']['Body']['MasterAgrmt']['ExceID']

    diff_result = utils.convert_dict(original_xml) == utils.convert_dict(zip_xml)

    if not diff_result:
        print("XML比对失败!", diff_files(original_xml_path, zip_xml_path))
        assert 0
    else:
        print("XML比对成功!")
        assert 1

    original_pdf_path = os.path.join(parent_dir, '../template/A1001/A/A100101.pdf')
    original_pdf_md5 = utils.file_md5(original_pdf_path)
    zip_pdf_path = os.path.join(parent_dir, '../template/A1001/A/ATTACHMENT/A100101.pdf')
    zip_pdf_md5 = utils.file_md5(zip_pdf_path)

    diff_result = original_pdf_md5 == zip_pdf_md5

    if not diff_result:
        print("PDF比对失败!")
        assert 0
    else:
        print("PDF比对成功!")
        assert 1


@pytest.mark.run(order=2)
def test_a1001_update():
    assert 1


@pytest.mark.run(order=3)
def test_a1001_delete():
    assert 1


if __name__ == '__main__':
    test_a1001_add()
