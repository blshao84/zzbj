# -*- coding: utf-8 -*-
# @Author : dongjianghai
# @File : main.ui.py
# Introduction :

import os
import logging

from tkinter import *
from tkinter import filedialog
from tkinter import messagebox
from tkinter import ttk

from service import utils as uts


class MainUi:
    def __init__(self, window):
        self.wind = window
        self.wind.title('CSI-Trans 企业版')
        sw = self.wind.winfo_screenmmwidth()
        sh = self.wind.winfo_screenheight()
        ww = 800
        wh = 400
        x = (sw - ww) / 2
        y = (sh - wh) / 2
        logging.debug('sw:{0}, sh:{1}, x:{2}, y:{3}'.format(sw, sh, x, y))
        self.wind.geometry("%dx%d+%d+%d" % (ww, wh, x, y))

        row = 1
        Label(self.wind, text="报告类型:", font=("KaiTi_GB2312", 12)).grid(row=row, column=1, sticky=W)
        self.busiDataType_Cmb = ttk.Combobox(self.wind, height=15, state='readonly', width=30)
        self.busiDataType_Cmb['values'] = ['A1001.主协议(无附件)(增量)',
                                           'A1002.主协议产品列表(无附件)(增量)',
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
        self.busiDataType_Cmb.grid(row=row, column=2, columnspan=2)
        Label(self.wind, text="报送方式:", font=("KaiTi_GB2312", 12)).grid(row=row, column=4, sticky=W)
        self.operationType_Cmb = ttk.Combobox(self.wind, height=3, state='readonly')
        self.operationType_Cmb['values'] = ['A.报送信息文件',
                                            'U.报送信息补正文件',
                                            'D.报送信息废止文件']
        self.operationType_Cmb.grid(row=row, column=6, columnspan=2)

        row = 3
        Label(self.wind, text="选择报告:", font=("KaiTi_GB2312", 12)).grid(row=row, column=1, sticky=W)
        self.folderPath_txt = StringVar()
        Entry(self.wind, textvariable=self.folderPath_txt, width=60).grid(row=row, column=2, columnspan=7)

        Button(self.wind, text="浏览...", font=("KaiTi_GB2312", 12), command=self.openFolder) \
            .grid(row=row, column=9, columnspan=4, pady=10)

        row = 4
        Button(self.wind, text="1.解析", font=("KaiTi_GB2312", 12), command=self.parseData).grid(row=row, column=1)
        Button(self.wind, text="2.保存", font=("KaiTi_GB2312", 12), command=self.submitData).grid(row=row, column=2)
        Button(self.wind, text="3.报送", font=("KaiTi_GB2312", 12), command=self.sendData).grid(row=row, column=3)

        row = 5
        Button(self.wind, text="本地打包", font=("KaiTi_GB2312", 12), command=self.zipDataLocal).grid(row=row, column=3)

        row = 6
        Label(self.wind, text="报告文件:", font=("KaiTi_GB2312", 12)).grid(row=row, column=1, sticky=W)
        self.xlsx_tree = ttk.Treeview(height=2, columns=2)
        self.xlsx_tree.grid(row=row, column=0, columnspan=20)
        self.xlsx_tree.heading('#0', text='名称', anchor=CENTER)
        self.xlsx_tree.heading('#1', text='路径', anchor=CENTER)

        row = 8
        Label(self.wind, text="附件文件:", font=("KaiTi_GB2312", 12)).grid(row=row, column=1, sticky=W)
        self.pdf_tree = ttk.Treeview(height=10, columns=2)
        self.pdf_tree.grid(row=row, column=0, columnspan=20)
        self.pdf_tree.heading('#0', text='名称', anchor=CENTER)
        self.pdf_tree.heading('#1', text='路径', anchor=CENTER)

        SuccessMSG = Variable()
        Label(self.wind, textvariable=SuccessMSG, font=("KaiTi_GB2312", 12)).grid(row=20, column=3)

    def openFolder(self):
        foldername = filedialog.askdirectory(title='select..', initialdir='./')
        self.folderPath_txt.set(foldername)

    def parseExcel(self):
        logging.debug('parse Excel')

    def parsePdfs(self):
        logging.debug('parse Pdfs')

    def parseData(self):
        logging.debug('folderPath_txt:{0}'.format(self.folderPath_txt.get()))
        logging.debug('busiDataType_Cmb:{0}'.format(self.busiDataType_Cmb.get()))
        logging.debug('operationType_Cmb:{0}'.format(self.operationType_Cmb.get()))

        for i in self.xlsx_tree.get_children():
            self.xlsx_tree.delete(i)
        for i in self.pdf_tree.get_children():
            self.pdf_tree.delete(i)
        path = self.folderPath_txt.get()
        xlsx_files = []
        pdf_files = []
        for f in os.listdir(path):
            if (os.path.isdir(os.path.join(path, f))):
                messagebox.showinfo('提示', '存在文件夹')
                return

            suffixs = ['.pdf', '.xlsx']
            file_sufix = os.path.splitext(f)[-1]
            if file_sufix not in suffixs:
                messagebox.showinfo('提示', '存在非报送格式文件')
                return

            if file_sufix in ['.xlsx']:
                xlsx_files.append(f)
            elif file_sufix in ['.pdf']:
                pdf_files.append(f)

        logging.debug(xlsx_files)
        logging.debug(pdf_files)
        if len(xlsx_files) != 1:
            messagebox.showinfo('提示', '报告文件数量错误')
            return

        for i in xlsx_files:
            self.xlsx_tree.insert('', 0, text=i, values=os.path.join(path, i))

        for i in pdf_files:
            self.pdf_tree.insert('', 0, text=i, values=os.path.join(path, i))

        # self.parsePdfs()
        # self.parseExcel()

    def submitData(self):
        logging.debug('submitData')

    def sendData(self):
        logging.debug('sendData')

    def zipDataLocal(self):
        logging.debug('zipDataLocal')


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
