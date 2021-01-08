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
    test_utils.prepare('A1001', 'A', 'A1001主协议列表.xlsx', ['A100101.pdf'], '0001')

    assert diff_xml('A1001', 'A', 'A1001主协议列表.xlsx', '0001')
    assert diff_pdf('A1001', 'A', ['A100101.pdf'])


@pytest.mark.run(order=2)
def test_a1001_update():
    assert 1


@pytest.mark.run(order=3)
def test_a1001_delete():
    assert 1


def diff_xml(busi_data_type, operation_type, xml_file_name, file_number):
    today_dash = datetime.today().strftime('%Y-%m-%d')
    parent_dir, template_path, attachment_path, zip_file, zip_xml_file, utils.CONFIG_PATH_NAME \
        = test_utils.config(busi_data_type, operation_type)
    original_xml_path = os.path.join(parent_dir, template_path + xml_file_name.replace('file_number', file_number))
    original_xml = utils.xml_to_dict(original_xml_path)
    original_xml['Root']['Header']['SendDate'] = today_dash
    del original_xml['Root']['Body']['MasterAgrmt']['ExceID']
    zip_xml_path = os.path.join(parent_dir, template_path + zip_xml_file.replace('file_number', file_number))
    zip_xml = utils.xml_to_dict(zip_xml_path)
    del zip_xml['Root']['Body']['MasterAgrmt']['ExceID']

    diff_result = utils.convert_dict(original_xml) == utils.convert_dict(zip_xml)

    if not diff_result:
        print("XML比对失败!", diff_files(original_xml_path, zip_xml_path))
        return 0
    else:
        print("XML比对成功!")
        return 1


def diff_pdf(busi_data_type, operation_type, pdf_file_names):
    parent_dir, template_path, attachment_path, zip_file, zip_xml_file, utils.CONFIG_PATH_NAME \
        = test_utils.config(busi_data_type, operation_type)
    if pdf_file_names is not None and len(pdf_file_names) > 0:
        for i in range(len(pdf_file_names)):
            original_pdf_path = os.path.join(parent_dir, template_path + pdf_file_names[i])
            original_pdf_md5 = utils.file_md5(original_pdf_path)
            zip_pdf_path = os.path.join(parent_dir, attachment_path + pdf_file_names[i])
            zip_pdf_md5 = utils.file_md5(zip_pdf_path)

            diff_result = original_pdf_md5 == zip_pdf_md5

            if not diff_result:
                print("PDF比对失败!")
                return 0
            else:
                print("PDF比对成功!")
                return 1


if __name__ == '__main__':
    test_a1001_add()
