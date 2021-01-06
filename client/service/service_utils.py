import collections
import logging
import os
from datetime import datetime

from json2data.json2data.json2xml import Json2Xml
from service import utils
from service.entity.sendReport import SendReport

_date_format = '%Y-%m-%d'
_date_format1 = '%Y%m%d'

Operate_Type = {
    'A': 'ADD',
    'U': 'UPDATE',
    'D': 'DELETE',
}
# body  node
A1001_Body = "MasterAgrmt"  # 主协议
A1002_Body = "MasterAgrmtProduct"  # 主协议产品列表
A1003_Body = "SupAgrmt"  # 补充协议
A1004_Body = "OptionConfirmation"  # 期权交易确认书
A1005_Body = "SwapConfirmation"  # 互换交易确认书
A1006_Body = "SwapTermination"  # 互换终止
A1007_Body = "OptionTermination"  # 期权终止
A1008_Body = "PerformanceGuaranteeAgrmt"  # 履约担保
A1009_Body = "EventReport"  # 重大事项报告
A1010_Body = "OtherReport"  # 其他事项报告
A1011_Body = "PeriodicReportSAC"  # 定期报告-SAC模板
A1012_Body = "PeriodicReportNAFMII"  # 定期报告-NAFMII模板
A1013_Body = "PeriodicReportISDA"  # 定期报告-ISDA模板
A1014_Body = "PeriodicReportQuarter"  # 定期报告-季报
A1015_Body = "ContractNumberProcess"  # 双方约定编号数据处理

# xsd file
A1001_Xsd_Path = "../service/xsd/A1001.xsd"  # 主协议
A1002_Xsd_Path = "../service/xsd/A1002.xsd"  # 主协议产品列表
A1003_Xsd_Path = "../service/xsd/A1003.xsd"  # 补充协议
A1004_Xsd_Path = "../service/xsd/A1004.xsd"  # 期权交易确认书
A1005_Xsd_Path = "../service/xsd/A1005.xsd"  # 互换交易确认书
A1006_Xsd_Path = "../service/xsd/A1006.xsd"  # 互换终止
A1007_Xsd_Path = "../service/xsd/A1007.xsd"  # 期权终止
A1008_Xsd_Path = "../service/xsd/A1008.xsd"  # 履约担保
A1009_Xsd_Path = "../service/xsd/A1009.xsd"  # 重大事项报告
A1010_Xsd_Path = "../service/xsd/A1010.xsd"  # 其他事项报告
A1011_Xsd_Path = "../service/xsd/A1011.xsd"  # 定期报告-SAC模板
A1012_Xsd_Path = "../service/xsd/A1012.xsd"  # 定期报告-NAFMII模板
A1013_Xsd_Path = "../service/xsd/A1013.xsd"  # 定期报告-ISDA模板
A1014_Xsd_Path = "../service/xsd/A1014.xsd"  # 定期报告-季报
A1015_Xsd_Path = "../service/xsd/A1015.xsd"  # 双方约定编号数据处理


def filter_field(data, clos=None):
    if clos and data:
        if isinstance(data, list):
            for d in data:
                for col in clos:
                    if col in d:
                        del d[col]
        if isinstance(data, dict):
            for col in clos:
                if col in data:
                    del data[col]
    return data


def generate_xml_file(report: SendReport, body_node_name):
    xml_node = build_xml_data(report.headerInfo, report.jsonData, body_node_name)
    report.xmldata = xml_node
    op = Json2Xml()
    logging.debug(xml_node)
    op.str_2_file(xml_node, report.xmlFileAbsName)


def build_xml_data(header_info, json_data, body_node_name):
    body = {body_node_name: json_data}
    xml_node = {'Root': {}}
    xml_node['Root']['Header'] = header_info
    xml_node['Root']['Body'] = body
    return xml_node


def call_server_save_data(router, params):
    url = 'http://{ip}:{port}/{router}'.format(router=router, ip=utils.ip(), port=utils.port())
    params = {
        "params": params
    }
    try:
        resp = utils.post(url=url, params=params)
    except Exception as e:
        logging.error(repr(e))
        raise RuntimeError('保存数据到服务器未知异常')


def call_server_generate_zip(router, params):
    url = 'http://{ip}:{port}/{router}'.format(router=router, ip=utils.ip(), port=utils.port())
    params = {
        "operation": params
    }
    try:
        resp = utils.post_form_data(url=url, params=params,
                                    headers={'Content-Type': 'application/x-www-form-urlencoded'})
    except Exception as e:
        logging.error(repr(e))
        raise RuntimeError('服务器生成zip未知异常')


def call_server_upload_zip(router, files):
    url = 'http://{ip}:{port}/{router}'.format(router=router, ip=utils.ip(), port=utils.port())
    try:
        resp = utils.post_file_data(url=url, params=files)
        return resp
    except Exception as e:
        logging.error(repr(e))
        raise RuntimeError('上传zip到服务器未知异常')

def call_server_upload_pdf_attachment(router, files, code):
    url = 'http://{ip}:{port}/{router}'.format(router=router, ip=utils.ip(), port=utils.port()) + ''
    try:
        utils.post_file_with_code(url, files, code, headers=None)
    except Exception as e:
        logging.error(repr(e))
        raise RuntimeError('上传附件到服务器未知异常')


# '{"Version": "001", ' \
#                  '"SenderCode": "131101", ' \
#                  '"ReceiverCode": "000899", ' \
#                  '"SendDate": "2020-01-01", ' \
#                  '"FileNumber": "0001", ' \
#                  '"BusiDataType": "A1008", ' \
#                  '"OperationType": "A"}'
# 文件创建人代码（6位）+文件接收人代码（6位）+报送日期（8位）+当日顺序编号（8位）
def set_exce_id(report: SendReport):
    if report.headerInfo and report.jsonData:
        SenderCode = report.headerInfo.get('SenderCode')
        ReceiverCode = report.headerInfo.get('ReceiverCode')
        SendDate = report.headerInfo.get('SendDate')
        SendDate = datetime.strptime(SendDate, _date_format).strftime(_date_format1)
        if isinstance(report.jsonData, list):
            datas = []
            for index, data in enumerate(report.jsonData):
                temp = collections.OrderedDict()
                seq = "%08d" % (index + 1)
                exce_id = '{SenderCode}{ReceiverCode}{SendDate}{seq}'.format(SenderCode=SenderCode,
                                                                             ReceiverCode=ReceiverCode,
                                                                             SendDate=SendDate,
                                                                             seq=seq)
                temp['ExceID'] = exce_id
                temp.update(data)
                datas.append(temp)
            report.jsonData = datas
        if isinstance(report.jsonData, dict):
            temp = collections.OrderedDict()
            seq = "%08d" % (1)
            exce_id = '{SenderCode}{ReceiverCode}{SendDate}{seq}'.format(SenderCode=SenderCode,
                                                                         ReceiverCode=ReceiverCode,
                                                                         SendDate=SendDate,
                                                                         seq=seq)
            temp['ExceID'] = exce_id
            temp.update(report.jsonData)
            report.jsonData = temp


# OTC_[文件创建人代码]_[文件接收人代码]_[数据日期]_[文件序号]_[接口标识] _[操作标识].XML
# OTC_131101_000899_20200824_0001_A1001_A.xml
# xml 文件默认放在xml_tmp文件夹下面
def set_xml_file_name(report: SendReport):
    if report.headerInfo:
        BusiDataType = report.headerInfo.get('BusiDataType')
        Version = report.headerInfo.get('Version')
        SenderCode = report.headerInfo.get('SenderCode')
        ReceiverCode = report.headerInfo.get('ReceiverCode')
        SendDate = report.headerInfo.get('SendDate')
        SendDate = datetime.strptime(SendDate, _date_format).strftime(_date_format1)
        OperationType = report.headerInfo.get('OperationType')
        if BusiDataType and Version and SenderCode and ReceiverCode and SendDate and OperationType:
            xml_file_name = 'OTC_{SenderCode}_{ReceiverCode}_{SendDate}_{Version}_{BusiDataType}_{OperationType}.xml'.format(
                SenderCode=SenderCode,
                ReceiverCode=ReceiverCode,
                SendDate=SendDate,
                Version=Version,
                BusiDataType=BusiDataType,
                OperationType=OperationType
            )
            report.xmlFileAbsName = os.path.join('xml_tmp', xml_file_name)


if __name__ == '__main__':
    aa = "%08d"

    print(aa % 23)

    pass
