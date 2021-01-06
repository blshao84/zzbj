# -*- coding: utf-8 -*-
# @Author : dongjianghai
# @File : main_bl.py
# Introduction :

import logging
import os

from service import service_bl as bl
from service.entity.sendReport import *


def zipFile(report: SendReport):
    logging.debug('==main_bl.zipFile==')
    logging.debug(report)
    if isinstance(report, IndividualSendReport):
        # 个人版
        bl.Excel_2_Json(report)
        bl.Json_2_XmlFile(report)
        bl.Zip_2_File(report)
    else:
        # 企业版
        bl.Excel_2_Json(report)
        bl.Save_Data_And_Generate_Zip(report)
    return None


def uploadZipFileToServer(foldername):
    return bl.uploadZipFileToServer(foldername)


if __name__ == '__main__':
    path = os.path.dirname(os.path.abspath(__file__))
    report = SendReport()
    report.xlsxFileName = 'A1001.xlsx'
    report.xlsxFileAbsName = os.path.join(path, report.xlsxFileName)
    report.operationType = 'A'
    report.busiDataType = 'A1001'
    report.outputFolderName = 'output'
    report.xmlFileName = 'A1001.xml'
    report.xmlFileAbsName = os.path.join(path, report.outputFolderName, report.xmlFileName)

    zipFile(report)
