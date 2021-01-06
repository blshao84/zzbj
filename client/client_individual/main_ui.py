# -*- coding: utf-8 -*-
# @Author : dongjianghai
# @File : main_ui.py
# Introduction :

import json
import logging
import os
from tkinter import *
from tkinter import filedialog
from tkinter import messagebox
from tkinter import ttk

from client_individual import main_bl as bl
from json2data.json2data import fileUtil
from service import utils as uts
from service.entity.sendReport import IndividualSendReport as SendReport


class MainUi:
    def __init__(self, window):
        self.wind = window
        self.wind.title('CSI-Trans 个人版')
        sw = self.wind.winfo_screenmmwidth()
        sh = self.wind.winfo_screenheight()
        ww = 800
        wh = 800
        x = (sw - ww) / 2 + 800
        y = (sh - wh) / 2
        logging.debug('sw:{0}, sh:{1}, x:{2}, y:{3}'.format(sw, sh, x, y))
        self.wind.geometry("%dx%d+%d+%d" % (ww, wh, x, y))

        row = 1
        Label(self.wind, text="报告类型:", font=("KaiTi_GB2312", 12)).grid(row=row, column=1, sticky=W, pady=10)
        self.busiDataType_Cmb = ttk.Combobox(self.wind, height=15, state='readonly', width=30)
        self.busiDataType_Cmb['values'] = ['A1001.主协议(有附件)(增量)',
                                           'A1002.主协议产品列表(有附件)(增量)',
                                           'A1003.补充协议(有附件)(增量)',
                                           'A1004.期权交易确认书(有附件)(增量)',
                                           'A1005.互换交易确认书(有附件)(增量)',
                                           'A1006.互换终止(无附件)(增量)',
                                           'A1007.期权终止(无附件)(增量)',
                                           'A1008.履约担保(无附件)(增量)',
                                           'A1009.重大事项报告(有附件)(增量)',
                                           'A1010.其他事项报告(有附件)(增量)',
                                           'A1011.定期报告-SAC模板(无附件)(全量)',
                                           'A1012.定期报告-NAFMII模板(无附件)(全量)',
                                           'A1013.定期报告-ISDA模板(无附件)(全量)',
                                           'A1014.定期报告-季报(有附件)(全量)',
                                           'A1015.双方约定编号数据处理(无附件)(全量)']
        self.busiDataType_Cmb.grid(row=row, column=2, sticky=W)
        Label(self.wind, text="报送方式:", font=("KaiTi_GB2312", 12)).grid(row=row, column=3)
        self.operationType_Cmb = ttk.Combobox(self.wind, height=3, state='readonly', width=22)
        self.operationType_Cmb['values'] = ['A.报送信息文件',
                                            'U.报送信息补正文件',
                                            'D.报送信息废止文件']
        self.operationType_Cmb.current(uts.get_even_config_value('operation_type'))
        self.operationType_Cmb.grid(row=row, column=4, sticky=W)

        row = row + 1
        Label(self.wind, text="版本:", font=("KaiTi_GB2312", 12)).grid(row=row, column=1, sticky=W)
        self.versionTxt = Text(self.wind, width=25, height=1, bg='white')
        self.versionTxt.insert('insert', uts.get_even_config_value('version'))
        self.versionTxt.grid(row=row, column=2, sticky=W)

        Label(self.wind, text="发送日期:", font=("KaiTi_GB2312", 12)).grid(row=row, column=3, sticky=W)
        self.sendDateTxt = Text(self.wind, width=25, height=1)
        self.sendDateTxt.insert('insert', uts.get_even_config_value('send_date'))
        self.sendDateTxt.grid(row=row, column=4, sticky=W)

        row = row + 1
        Label(self.wind, text="本方机构码:", font=("KaiTi_GB2312", 12)).grid(row=row, column=1, sticky=W)
        self.senderCodeTxt = Text(self.wind, width=25, height=1)
        self.senderCodeTxt.insert('insert', uts.get_even_config_value('sender_code'))
        self.senderCodeTxt.grid(row=row, column=2, sticky=W)
        Label(self.wind, text="中证机构码:", font=("KaiTi_GB2312", 12)).grid(row=row, column=3, sticky=W, pady=10)
        self.ReceiverCodeTxt = Text(self.wind, width=25, height=1)
        self.ReceiverCodeTxt.insert('insert', uts.get_even_config_value('receiver_code'))
        self.ReceiverCodeTxt.grid(row=row, column=4, sticky=W)


        row = row + 1
        Label(self.wind, text="文件数量:", font=("KaiTi_GB2312", 12)).grid(row=row, column=1, sticky=W)
        self.FileNumberTxt = Text(self.wind, width=25, height=1)
        self.FileNumberTxt.insert('insert', uts.get_even_config_value('file_number'))
        self.FileNumberTxt.grid(row=row, column=2, sticky=W)

        row = row + 1
        Label(self.wind, text="选择解析目录:", font=("KaiTi_GB2312", 12)).grid(row=row, column=1, sticky=W)
        self.folderParsePath_txt = StringVar()
        Entry(self.wind, textvariable=self.folderParsePath_txt, width=70).grid(row=row, column=2, columnspan=3,
                                                                               sticky=W)
        Button(self.wind, text="浏览...", font=("KaiTi_GB2312", 12), command=self.openParseFolder) \
            .grid(row=row, column=5, pady=10, padx=10)

        row = row + 1
        Label(self.wind, text="选择存储目录:", font=("KaiTi_GB2312", 12)).grid(row=row, column=1, sticky=W)
        self.folderStoragePath_txt = StringVar()
        Entry(self.wind, textvariable=self.folderStoragePath_txt, width=70).\
            grid(row=row, column=2, columnspan=3, sticky=W)

        Button(self.wind, text="浏览...", font=("KaiTi_GB2312", 12), command=self.openStoreFolder) \
            .grid(row=row, column=5)

        row = row + 1
        Label(self.wind, text="输入压缩文件名:", font=("KaiTi_GB2312", 12)).grid(row=row, column=1, sticky=W, pady=10)
        self.zipFileTxt = Text(self.wind, width=70, height=1)
        self.zipFileTxt.grid(row=row, column=2, columnspan=3, sticky=W)
        # self.zipFileTxt = ttk.Entry(window,show=None).grid(row=row, column=2, columnspan=3, sticky=W)

        row = row + 1
        Label(self.wind, text="报告文件:", font=("KaiTi_GB2312", 12)).grid(row=row, column=1, sticky=NW)
        self.xlsx_tree = ttk.Treeview(self.wind, height=1, columns=2, selectmode="browse")
        self.xlsx_tree.grid(row=row, column=2, columnspan=4, pady=10, sticky=NW)
        self.xlsx_tree.column('#0', width=245, stretch=True)
        self.xlsx_tree.heading('#0', text='名称', anchor=CENTER)
        self.xlsx_tree.column('#1', width=245, stretch=True)
        self.xlsx_tree.heading('#1', text='路径', anchor=CENTER)

        row = row + 2
        Label(self.wind, text="附件文件:", font=("KaiTi_GB2312", 12)).grid(row=row, column=1, sticky=NW)
        self.pdf_tree = ttk.Treeview(height=10, columns=2)
        self.pdf_tree.grid(row=row, column=2, columnspan=20, sticky=NW)

        self.pdf_tree.column('#0', width=245, stretch=True)
        self.pdf_tree.heading('#0', text='名称', anchor=CENTER)
        self.pdf_tree.column('#1', width=245, stretch=True)
        self.pdf_tree.heading('#1', text='路径', anchor=CENTER)

        row = row + 1
        Button(self.wind, text="解析目录", font=("KaiTi_GB2312", 12), command=self.parseData).\
            grid(row=row, column=2, sticky=E, pady=10, padx=10)
        Button(self.wind, text="生成压缩文件", font=("KaiTi_GB2312", 12), command=self.zipDataLocal).\
            grid(row=row, column=3, sticky=W, pady=10)

        row = row + 1
        Label(self.wind, text="选择压缩文件:", font=("KaiTi_GB2312", 12)).grid(row=row, column=1, sticky=W)
        self.uploadZipPath = StringVar()
        Entry(self.wind, textvariable=self.uploadZipPath, width=70).grid(row=row, column=2, columnspan=3, sticky=W)

        Button(self.wind, text="浏览", font=("KaiTi_GB2312", 12), command=self.uploadZipFile). \
            grid(row=row, column=5, sticky=W, pady=10)

        row = row + 1

        self.logTxt = Text(self.wind, width=100, height=10)
        self.logTxt.grid(row=row, column=1, columnspan=5, sticky=W)

        SuccessMSG = Variable()
        Label(self.wind, textvariable=SuccessMSG, font=("KaiTi_GB2312", 12)).grid(row=20, column=3)
        self._report = SendReport()


    def fieldValueValid(self):
        d = self.busiDataType_Cmb.get()
        if str(d).split('.')[0].strip() == '':
            messagebox.showinfo('提示', "报告类型为空！")
            return False
        d = self.operationType_Cmb.get()
        if str(d).split('.')[0].strip() == '':
            messagebox.showinfo('提示', "报送方式为空！")
            return False
        if self.versionTxt.get('0.0', END).strip() == '':
            messagebox.showinfo('提示', "版本为空！")
            return False
        if self.sendDateTxt.get('0.0', END).strip() == '':
            messagebox.showinfo('提示', "发送日期为空！")
            return False
        if self.senderCodeTxt.get('0.0', END).strip() == '':
            messagebox.showinfo('提示', "本方机构码为空！")
            return  False
        if self.ReceiverCodeTxt.get('0.0', END).strip() == '':
            messagebox.showinfo('提示', "中证机构码为空！")
            return False
        if self.FileNumberTxt.get('0.0', END).strip() == '':
            messagebox.showinfo('提示', "文件数量为空！")
            return False
        if self.folderParsePath_txt.get() == '':
            messagebox.showinfo('提示', "解析目录为空！")
            return False
        if self.folderStoragePath_txt.get() == '':
            messagebox.showinfo('提示', "存储目录为空！")
            return False
        if self.zipFileTxt.get('0.0', END).strip() == '':
            messagebox.showinfo('提示', "压缩文件名为空！")
            return False
        return True

    def openParseFolder(self):
        foldername = filedialog.askdirectory(title='select..', initialdir='./')
        self.folderParsePath_txt.set(foldername)

    def openStoreFolder(self):
        foldername = filedialog.askdirectory(title='select..', initialdir='./')
        self.folderStoragePath_txt.set(foldername)

    def parseExcel(self):
        logging.debug('parse Excel')

    def parsePdfs(self):
        logging.debug('parse Pdfs')

    def parseData(self):
        logging.debug('busiDataType_Cmb:{0}'.format(self.busiDataType_Cmb.get()))
        logging.debug('operationType_Cmb:{0}'.format(self.operationType_Cmb.get()))
        logging.debug('zipFileName'.format(self.zipFileTxt.get('0.0', END)))

        for i in self.xlsx_tree.get_children():
            self.xlsx_tree.delete(i)
        for i in self.pdf_tree.get_children():
            self.pdf_tree.delete(i)
        path = self.folderParsePath_txt.get()
        if path.strip() == '':
            messagebox.showinfo('提示', "解析目录为空！")
            return False
        xlsx_files = []
        pdf_files = []
        for f in os.listdir(path):
            file_sufix = os.path.splitext(f)[-1]
            is_hiden = self.file_is_hidden(path + '/' + f)
            if file_sufix in ['.xlsx'] and not is_hiden:
                xlsx_files.append(f)
            elif file_sufix in ['.pdf'] and not is_hiden:
                pdf_files.append(f)
            size = os.path.getsize(path + '/' + f)
            if size == 0 and not is_hiden:
                messagebox.showinfo('提示', f + '是空文件')
                return

        logging.debug(xlsx_files)
        logging.debug(pdf_files)
        if len(xlsx_files) != 1:
            messagebox.showinfo('提示', '报告文件数量错误')
            return

        if len(pdf_files) > 0 and self.operationType_Cmb.get() == 'A.报送信息文件'\
                and (self.busiDataType_Cmb.get() == 'A1006.互换终止(无附件)(增量)' or
                self.busiDataType_Cmb.get() == 'A1007.期权终止(无附件)(增量)' or
                self.busiDataType_Cmb.get() == 'A1008.履约担保(无附件)(增量)' or
                self.busiDataType_Cmb.get() == 'A1011.定期报告-SAC模板(无附件)(全量)' or
                self.busiDataType_Cmb.get() == 'A1012.定期报告-NAFMII模板(无附件)(全量)' or
                self.busiDataType_Cmb.get() == 'A1013.定期报告-ISDA模板(无附件)(全量)' or
                self.busiDataType_Cmb.get() == 'A1015.双方约定编号数据处理(无附件)(全量)'
        ):
            messagebox.showinfo('提示', '报告类型无附件，报告目录有附件！')
            return

        if len(pdf_files) == 0 and self.operationType_Cmb.get() == 'A.报送信息文件'\
                and (self.busiDataType_Cmb.get() == 'A1001.主协议(有附件)(增量)' or
                self.busiDataType_Cmb.get() == 'A1002.主协议产品列表(有附件)(增量)' or
                self.busiDataType_Cmb.get() == 'A1003.补充协议(有附件)(增量)' or
                self.busiDataType_Cmb.get() == 'A1004.期权交易确认书(有附件)(增量)' or
                self.busiDataType_Cmb.get() == 'A1005.互换交易确认书(有附件)(增量)' or
                self.busiDataType_Cmb.get() == 'A1009.重大事项报告(有附件)(增量)' or
                self.busiDataType_Cmb.get() == 'A1010.其他事项报告(有附件)(增量)' or
                self.busiDataType_Cmb.get() == 'A1014.定期报告-季报(有附件)(全量)'
        ):
            messagebox.showinfo('提示', '报告类型有附件，报告目录无附件！')
            return

        for i in xlsx_files:
            self.xlsx_tree.insert('', 0, text=i, values=path + '/' + i)

        pdf_files.sort(reverse=True)
        self._report.pdfFileNames.clear()
        self._report.pdfFileAbsNames.clear()
        for i in pdf_files:
            self.pdf_tree.insert('', 0, text=i, values=path + '/' + i)
            self._report.pdfFileNames.append(i)
            self._report.pdfFileAbsNames.append(os.path.join(path, i))

        self._report.xlsxFileName = xlsx_files[0]
        self._report.xlsxFileAbsName = os.path.join(path, xlsx_files[0])
        d = self.operationType_Cmb.get()
        self._report.operationType = str(d).split('.')[0]
        d = self.busiDataType_Cmb.get()
        self._report.busiDataType = str(d).split('.')[0]
        # todo
        self._report.outputFolderName = self.folderStoragePath_txt.get()
        # todo
        self._report.xmlFileName = '{0}.xml'.format(str(d).split('.')[0])
        # 临时目录存放 xml
        # self._report.xmlFileAbsName = os.path.join('xml_tmp', self._report.xmlFileName)
        self._report.zipFileName = self.zipFileTxt.get('0.0', END).strip() + '.zip'
        self._report.zipFileAbsName = os.path.join(self._report.outputFolderName, self._report.zipFileName)
        d = self.logTxt.get('0.0', END)
        self._report.headerInfo = {'Version':self.versionTxt.get('0.0', END).strip(),
                                   'SenderCode':self.senderCodeTxt.get('0.0', END).strip(),
                                   'ReceiverCode':self.ReceiverCodeTxt.get('0.0', END).strip(),
                                   'SendDate':self.sendDateTxt.get('0.0', END).strip(),
                                   'FileNumber':self.FileNumberTxt.get('0.0', END).strip(),
                                   'BusiDataType':self._report.busiDataType,
                                   'OperationType':self._report.operationType
                                   }
        return True

    # 判断文件是否是隐藏文件
    def file_is_hidden(self, p):
        if os.name == 'nt':
            import win32api, win32con
            attribute = win32api.GetFileAttributes(p)
            return attribute & (win32con.FILE_ATTRIBUTE_HIDDEN | win32con.FILE_ATTRIBUTE_SYSTEM)
        else:
            return p.startswith('.')  # linux-osx

    def submitData(self):
        bl.test_sqliteData()
        logging.debug('submitData')

    def sendData(self):
        logging.debug('sendData')

    def zipDataLocal(self):
        logging.debug('zipDataLocal')
        if not self.fieldValueValid():
            return
        if not self.parseData():
            return
        try:
            result = bl.zipFile(self._report)
            if 'error' in result:
                messagebox.showerror('错误', result['error']['message'])
        except Exception as e:
            logging.debug("Exception:" + str(e))
            if str(e).find("No sheet named") != -1:
                messagebox.showinfo('提示', '报告类型和报告文件类型不匹配')
                return
            else:
                messagebox.showinfo('提示', "压缩文件遇到错误：" + str(e))
                return
        messagebox.showinfo('提示', "压缩文件成功！")
        # TODO 输出日志
        print(self._report.msg)
        logging.debug(result)

    def uploadZipFile(self):

        foldername = filedialog.askopenfilename(filetypes=[('zip', '*.zip')])
        self.uploadZipPath.set(foldername)
        self._report._file_data = foldername
        try:
            result = bl.uploadZipFileToServer(foldername)
            if 'error' in result:
                messagebox.showerror('错误', result['error']['message'])
        except Exception as e:
            logging.debug("Exception:" + str(e))
            messagebox.showinfo('提示', "上传文件遇到错误：" + str(e))
        self.logTxt.delete('0.0', END)
        self.logTxt.insert('insert', result)

def _init_env():
    parent_dir = os.path.dirname(os.path.abspath(__file__))
    config_file = os.path.join(parent_dir, 'config.yaml')
    uts.CONFIG_PATH_NAME = config_file
    uts.set_logging_by_config()
    logging.debug(config_file)

def ui_main():
    _init_env()
    window = Tk()
    app = MainUi(window)
    window.mainloop()


if __name__ == '__main__':
    ui_main()
