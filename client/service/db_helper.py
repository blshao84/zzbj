# -*- coding: utf-8 -*-
# @Author : dongjianghai
# @File : db_helper.py
# Introduction :

import psycopg2 as pg
import pymysql
import sqlite3

class Pg_Helper(object):
    def __init__(self, dbname='postgres', host='127.0.0.1', port=5432, user='root', pwd='12345'):
        self._conn = pg.connect(dbname=dbname, user=user, password=pwd, host=host, port=port)
        self.cursor = self._conn.cursor()

    def execute(self, sql):
        self.cursor.execute(sql)

    def queryAll(self, sql):
        self.cursor.execute(sql)
        return self.cursor.fetchall()

    def __del__(self):
        if hasattr(self, 'cursor'):
            self.cursor.close()

        if hasattr(self, '_conn'):
            self._conn.close()


class Mysql_Helper(object):
    def __init__(self, dbname, host='127.0.0.1', port=3306, user='root', pwd='12345', charset='utf8'):
        self._conn = pymysql.Connect(db=dbname,
                                     host=host,
                                     port=port,
                                     user=user,
                                     passwd=pwd,
                                     charset=charset)
        self.cursor = self._conn.cursor()

    def queryAll(self, sql):
        self.cursor.execute(sql)
        return self.cursor.fetchall()

    def queryOne(self, sql):
        self.cursor.execute(sql)
        return self.cursor.fetchone()

    def queryBy(self, sql, nameParams={}):
        if len(nameParams) > 0:
            self.cursor.execute(sql, nameParams)
        else:
            self.cursor.execute(sql)

        return self.cursor.fetchall()

    def __del__(self):
        if hasattr(self, 'cursor'):
            self.cursor.close()

        if hasattr(self, '_conn'):
            self._conn.close()


class Lite_Helper(object):
    def __init__(self,  dbname='client.db'):
        self._dbname = dbname

    def run_sql(self, sql, parameters = ()):
        with sqlite3.connect(self._dbname) as conn:
            cursor = conn.cursor()
            result = cursor.execute(sql, parameters)
            conn.commit()
        return result

    def query_for_dict(self, sql):
        def dict_factory(cursor, row):
            d = {}
            for idx, col in enumerate(cursor.description):
                d[col[0]] = row[idx]
            return d

        with sqlite3.connect(self._dbname) as conn:
            conn.row_factory = dict_factory
            cursor = conn.cursor()
            result = cursor.execute(sql).fetchall()
        return result