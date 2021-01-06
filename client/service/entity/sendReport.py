# -*- coding: utf-8 -*-
# @Author : dongjianghai
# @File : sendReport.py
# Introduction :

class SendReport(object):
    _zipFileName: str
    _zipFileAbsName: str
    _jsonData: str
    _xmldata: str
    _operationType: str
    _busiDataType: str
    # _pdfFileAbsNames: []
    # _pdfFileNames: []
    _xlsxFileAbsName: str
    _xlsxFileName: str
    _xmlFileAbsName: str
    _xmlFileName: str
    _xsdFileAbsName: str
    _xsdFileName: str
    _msg: str
    _file_data: object
    _headerInfo: object

    def __init__(self):
        self._pdfFileNames = []
        self._pdfFileAbsNames = []
        self._msg = ''

    @property
    def headerInfo(self):
        return self._headerInfo

    @headerInfo.setter
    def headerInfo(self, value):
        self._headerInfo = value

    @property
    def msg(self):
        return self._msg

    @msg.setter
    def msg(self, value):
        self._msg = value

    @property
    def xsdFileName(self):
        return self._xsdFileName

    @xsdFileName.setter
    def xsdFileName(self, value):
        self._xsdFileName = value

    @property
    def xsdFileAbsName(self):
        return self._xsdFileAbsName

    @xsdFileAbsName.setter
    def xsdFileAbsName(self, value):
        self._xsdFileAbsName = value

    @property
    def xmlFileName(self):
        return self._xmlFileName

    @xmlFileName.setter
    def xmlFileName(self, value):
        self._xmlFileName = value

    @property
    def xmlFileAbsName(self):
        return self._xmlFileAbsName

    @xmlFileAbsName.setter
    def xmlFileAbsName(self, value):
        self._xmlFileAbsName = value

    @property
    def xlsxFileName(self):
        return self._xlsxFileName

    @xlsxFileName.setter
    def xlsxFileName(self, value):
        self._xlsxFileName = value

    @property
    def xlsxFileAbsName(self):
        return self._xlsxFileAbsName

    @xlsxFileAbsName.setter
    def xlsxFileAbsName(self, value):
        self._xlsxFileAbsName = value

    @property
    def pdfFileNames(self):
        return self._pdfFileNames

    @pdfFileNames.setter
    def pdfFileNames(self, value):
        self._pdfFileNames = value

    @property
    def pdfFileAbsNames(self):
        return self._pdfFileAbsNames

    @pdfFileAbsNames.setter
    def pdfFileAbsNames(self, value):
        self._pdfFileAbsNames = value

    @property
    def busiDataType(self):
        return self._busiDataType

    @busiDataType.setter
    def busiDataType(self, value):
        self._busiDataType = value

    @property
    def operationType(self):
        return self._operationType

    @operationType.setter
    def operationType(self, value):
        self._operationType = value

    @property
    def xmldata(self):
        return self._xmldata

    @xmldata.setter
    def xmldata(self, value):
        self._xmldata = value

    @property
    def jsonData(self):
        return self._jsonData

    @jsonData.setter
    def jsonData(self, value):
        self._jsonData = value

    @property
    def zipFileName(self):
        return self._zipFileName

    @zipFileName.setter
    def zipFileName(self, value):
        self._zipFileName = value

    @property
    def zipFileAbsName(self):
        return self._zipFileAbsName

    @zipFileAbsName.setter
    def zipFileAbsName(self, value):
        self._zipFileAbsName = value

    @property
    def xmlFileName(self):
        return self._xmlFileName

    @xmlFileName.setter
    def xmlFileName(self, value):
        self._xmlFileName = value

    @property
    def xmlFileAbsName(self):
        return self._xmlFileAbsName

    @xmlFileAbsName.setter
    def xmlFileAbsName(self, value):
        self._xmlFileAbsName = value

    @property
    def outputFolderName(self):
        return self._outputFolderName

    @outputFolderName.setter
    def outputFolderName(self, value):
        self._outputFolderName = value

    @property
    def headerInfo(self):
        return self._headerInfo

    @headerInfo.setter
    def headerInfo(self, value):
        self._headerInfo = value


class IndividualSendReport(SendReport):
    def __init__(self):
        SendReport.__init__(self)


class EnterpriseSendReport(SendReport):
    def __init__(self):
        SendReport.__init__(self)
