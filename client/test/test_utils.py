# -*- coding: utf-8 -*-
import os
import shutil
from datetime import datetime
from xmldiff.main import diff_files
from service import service_bl, utils
from service.entity import sendReport


def prepare(busi_data_type, operation_type, excel_file_name, pdf_file_names, file_number):
    today_dash = datetime.today().strftime('%Y-%m-%d')
    today_no_dash = datetime.today().strftime('%Y%m%d')
    parent_dir = os.path.dirname(os.path.abspath(__file__))
    config_file = os.path.join(parent_dir, '../../client_enterprise/config.yaml')
    utils.CONFIG_PATH_NAME = config_file
    utils.set_logging_by_config()

    template_path = '../template/' + busi_data_type + '/' + operation_type + '/'
    report = sendReport.EnterpriseSendReport()
    report.busiDataType = busi_data_type
    report.operationType = operation_type
    report.xlsxFileAbsName = os.path.join(parent_dir, template_path + excel_file_name)
    if pdf_file_names is not None and len(pdf_file_names) > 0:
        pdf_file_abs_names = []
        for i in range(len(pdf_file_names)):
            pdf_file_abs_names[i] = os.path.join(parent_dir, template_path + pdf_file_names[i])
        report.pdfFileAbsNames = pdf_file_abs_names
        report.pdfFileNames = pdf_file_names

    service_bl.Excel_2_Json(report)
    service_bl.Save_Data_And_Generate_Zip(report)

    zip_file_name = 'OTC_' + utils.sender_code() + '_' + utils.receiver_code() \
                    + '_' + today_no_dash + '_' + file_number + '.zip'
    shutil.copy(os.path.join(parent_dir, '../../../../base-document/' + today_dash + '-zip/' + zip_file_name),
                os.path.join(parent_dir, template_path))

    utils.unzip_file(os.path.join(parent_dir, template_path + zip_file_name),
                     os.path.join(parent_dir, template_path))
