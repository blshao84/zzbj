# -*- coding: utf-8 -*-
# @Author : dongjianghai
# @File : xsd_valid.py
# Introduction :

from lxml import etree
# import lxml.etree


def xmlValidator(xml_filepath, xsd_filepath):
    xml_file = etree.parse(xml_filepath)
    xsd_validator = etree.XMLSchema(file=xsd_filepath)
    is_valid = xsd_validator.validate(xml_file)
    if is_valid is False:
        return xsd_validator.error_log
    return None