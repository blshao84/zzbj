# -*- coding: utf-8 -*-
# @Author : dongjianghai
# @File : service_bl.py
# Introduction :

import json
import logging
import shutil

from json2data.json2data import fileUtil
from json2data.json2data import xsd_valid
from json2data.json2data import zipUtil
from service import a1001_service, a1002_service, a1003_service, a1004_service, a1005_service, a1006_service, \
    a1007_service, a1008_service, a1009_service, a1010_service, a1011_service, a1012_service, a1013_service, \
    a1014_service, a1015_service
from service import service_utils
from service.entity.sendReport import *


def uploadZipFileToServer(foldername):
    router = 'answer/upload'
    files = {'file': open(foldername, 'rb')}
    response = service_utils.call_server_upload_zip(router, files)
    return json.dumps(response.json(), sort_keys=True, indent=4, separators=(', ', ': '), ensure_ascii=False)


def Excel_2_Json(report: SendReport):
    logging.debug('==service_bl.parseExcel==')
    logging.debug(report)
    if report.busiDataType == 'A1001':
        a1001_service.parse_excel(report)
    elif report.busiDataType == 'A1002':
        a1002_service.parse_excel(report)
    elif report.busiDataType == 'A1003':
        a1003_service.parse_excel(report)
    elif report.busiDataType == 'A1004':
        a1004_service.parse_excel(report)
    elif report.busiDataType == 'A1005':
        a1005_service.parse_excel(report)
    elif report.busiDataType == 'A1006':
        a1006_service.parse_excel(report)
    elif report.busiDataType == 'A1007':
        a1007_service.parse_excel(report)
    elif report.busiDataType == 'A1008':
        a1008_service.parse_excel(report)
    elif report.busiDataType == 'A1009':
        a1009_service.parse_excel(report)
    elif report.busiDataType == 'A1010':
        a1010_service.parse_excel(report)
    elif report.busiDataType == 'A1011':
        a1011_service.parse_excel(report)
    elif report.busiDataType == 'A1012':
        a1012_service.parse_excel(report)
    elif report.busiDataType == 'A1013':
        a1013_service.parse_excel(report)
    elif report.busiDataType == 'A1014':
        a1014_service.parse_excel(report)
    elif report.busiDataType == 'A1015':
        a1015_service.parse_excel(report)
    # 个人版解析的数据需要set ExceId
    if isinstance(report, IndividualSendReport):
        service_utils.set_exce_id(report)
    logging.debug(report.jsonData)


def Json_2_XmlFile(report: SendReport):
    logging.debug('==service_bl.parseJson==')
    # 本地临时存放目录
    fileUtil.create_folder('xml_tmp')
    # 生成xml文件名
    service_utils.set_xml_file_name(report)
    logging.debug(report)
    if report.busiDataType == 'A1001':
        report.xsdFileAbsName = service_utils.A1001_Xsd_Path
        service_utils.generate_xml_file(report, service_utils.A1001_Body)
    elif report.busiDataType == 'A1002':
        report.xsdFileAbsName = service_utils.A1002_Xsd_Path
        service_utils.generate_xml_file(report, service_utils.A1002_Body)
    elif report.busiDataType == 'A1003':
        report.xsdFileAbsName = service_utils.A1003_Xsd_Path
        service_utils.generate_xml_file(report, service_utils.A1003_Body)
    elif report.busiDataType == 'A1004':
        report.xsdFileAbsName = service_utils.A1004_Xsd_Path
        service_utils.generate_xml_file(report, service_utils.A1004_Body)
    elif report.busiDataType == 'A1005':
        report.xsdFileAbsName = service_utils.A1005_Xsd_Path
        service_utils.generate_xml_file(report, service_utils.A1005_Body)
    elif report.busiDataType == 'A1006':
        report.xsdFileAbsName = service_utils.A1006_Xsd_Path
        service_utils.generate_xml_file(report, service_utils.A1006_Body)
    elif report.busiDataType == 'A1007':
        report.xsdFileAbsName = service_utils.A1007_Xsd_Path
        service_utils.generate_xml_file(report, service_utils.A1007_Body)
    elif report.busiDataType == 'A1008':
        report.xsdFileAbsName = service_utils.A1008_Xsd_Path
        service_utils.generate_xml_file(report, service_utils.A1008_Body)
    elif report.busiDataType == 'A1009':
        report.xsdFileAbsName = service_utils.A1009_Xsd_Path
        service_utils.generate_xml_file(report, service_utils.A1009_Body)
    elif report.busiDataType == 'A1010':
        report.xsdFileAbsName = service_utils.A1010_Xsd_Path
        service_utils.generate_xml_file(report, service_utils.A1010_Body)
    elif report.busiDataType == 'A1011':
        report.xsdFileAbsName = service_utils.A1011_Xsd_Path
        service_utils.generate_xml_file(report, service_utils.A1011_Body)
    elif report.busiDataType == 'A1012':
        report.xsdFileAbsName = service_utils.A1012_Xsd_Path
        service_utils.generate_xml_file(report, service_utils.A1012_Body)
    elif report.busiDataType == 'A1013':
        report.xsdFileAbsName = service_utils.A1013_Xsd_Path
        service_utils.generate_xml_file(report, service_utils.A1013_Body)
    elif report.busiDataType == 'A1014':
        report.xsdFileAbsName = service_utils.A1014_Xsd_Path
        service_utils.generate_xml_file(report, service_utils.A1014_Body)
    elif report.busiDataType == 'A1015':
        report.xsdFileAbsName = service_utils.A1015_Xsd_Path
        service_utils.generate_xml_file(report, service_utils.A1015_Body)
    logging.debug(report.xmldata)
    msg = xsd_valid.xmlValidator(report.xmlFileAbsName, report.xsdFileAbsName)
    if msg:
        report._msg = 'xsd valid 校验不通过 error msg :{msg}'.format(msg=msg)
        logging.error(msg)
    else:
        report._msg = None


def Zip_2_File(report: SendReport):
    logging.debug('==service_bl.parseZip==')
    logging.debug(report)
    # 拷贝附件到xml_tmp下面一起打包
    if report.pdfFileAbsNames:
        for file_name in report.pdfFileAbsNames:
            shutil.copy(file_name, 'xml_tmp')
    zipUtil.zipDir('xml_tmp', report.zipFileAbsName)
    # 删除清空xml_tmp 文件夹
    fileUtil.delete_folder('xml_tmp')


def Save_Data_And_Generate_Zip(report: SendReport):
    logging.debug('==service_bl.call_server_save_data==')
    logging.debug(report)
    report.operationType = service_utils.Operate_Type.get(report.operationType)
    pdf_files = []
    for pdfAbsPath in report.pdfFileAbsNames:
        router = '/attachment/upload_files'
        for pdfFileName in report.pdfFileNames:
            if pdfAbsPath.endswith(pdfFileName):
                file = ('files', (pdfFileName, open(pdfAbsPath, 'rb'), 'application/pdf'))
                pdf_files.append(file)
                break
    if len(pdf_files):
        service_utils.call_server_upload_pdf_attachment(router, pdf_files, report.busiDataType)
    if report.busiDataType == 'A1001':
        router = 'master-agreement/excel/prepare'
        service_utils.call_server_save_data(router, report.jsonData)
        router = 'master-agreement/generate'
        service_utils.call_server_generate_zip(router, report.operationType)
    elif report.busiDataType == 'A1002':
        router = 'master-product-list/excel/prepare'
        service_utils.call_server_save_data(router, report.jsonData)
        router = 'master-product-list/generate'
        service_utils.call_server_generate_zip(router, report.operationType)
    elif report.busiDataType == 'A1003':
        router = 'sup-agreement/excel/prepare'
        service_utils.call_server_save_data(router, report.jsonData)
        router = 'sup-agreement/generate'
        service_utils.call_server_generate_zip(router, report.operationType)
    elif report.busiDataType == 'A1004':
        router = 'option-confirmation/excel/prepare'
        service_utils.call_server_save_data(router, report.jsonData)
        router = 'option-confirmation/generate'
        service_utils.call_server_generate_zip(router, report.operationType)
    elif report.busiDataType == 'A1005':
        router = 'swap-confirmation/excel/prepare'
        service_utils.call_server_save_data(router, report.jsonData)
        router = 'swap-confirmation/generate'
        service_utils.call_server_generate_zip(router, report.operationType)
    elif report.busiDataType == 'A1006':
        router = 'swap-termination/excel/prepare'
        service_utils.call_server_save_data(router, report.jsonData)
        router = 'swap-termination/generate'
        service_utils.call_server_generate_zip(router, report.operationType)
    elif report.busiDataType == 'A1007':
        router = 'option-termination/excel/prepare'
        service_utils.call_server_save_data(router, report.jsonData)
        router = 'option-termination/generate'
        service_utils.call_server_generate_zip(router, report.operationType)
    elif report.busiDataType == 'A1008':
        router = 'performance-guarantee/excel/prepare'
        service_utils.call_server_save_data(router, report.jsonData)
        router = 'performance-guarantee/generate'
        service_utils.call_server_generate_zip(router, report.operationType)
    elif report.busiDataType == 'A1009':
        router = 'event-report/excel/prepare'
        service_utils.call_server_save_data(router, report.jsonData)
        router = 'event-report/generate'
        service_utils.call_server_generate_zip(router, report.operationType)
    elif report.busiDataType == 'A1010':
        router = 'other-report/excel/prepare'
        service_utils.call_server_save_data(router, report.jsonData)
        router = 'other-report/generate'
        service_utils.call_server_generate_zip(router, report.operationType)
    elif report.busiDataType == 'A1011':
        router = 'pr-sac/excel/prepare'
        service_utils.call_server_save_data(router, [report.jsonData])
        router = 'pr-sac/generate'
        service_utils.call_server_generate_zip(router, report.operationType)
    elif report.busiDataType == 'A1012':
        router = 'pr-nafmii/excel/prepare'
        service_utils.call_server_save_data(router, [report.jsonData])
        router = 'pr-nafmii/generate'
        service_utils.call_server_generate_zip(router, report.operationType)
    elif report.busiDataType == 'A1013':
        router = 'pr-isda/excel/prepare'
        service_utils.call_server_save_data(router, [report.jsonData])
        router = 'pr-isda/generate'
        service_utils.call_server_generate_zip(router, report.operationType)
    elif report.busiDataType == 'A1014':
        router = 'pr-quarter/excel/prepare'
        service_utils.call_server_save_data(router, report.jsonData)
        router = 'pr-quarter/generate'
        service_utils.call_server_generate_zip(router, report.operationType)
    elif report.busiDataType == 'A1015':
        router = 'contract-number/excel/prepare'
        service_utils.call_server_save_data(router, report.jsonData)
        router = 'contract-number/generate'
        service_utils.call_server_generate_zip(router, report.operationType)
