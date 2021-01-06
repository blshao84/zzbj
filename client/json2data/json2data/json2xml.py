# -*- coding: utf-8 -*-
# @Author : dongjianghai
# @File : json2xml.py
# Introduction :

import json

from xml.etree import ElementTree
import xmltodict

class Json2Xml(object):
    def __init__(self):
        pass

    def jsonParser(self, t, factory=ElementTree.Element):
        attribs = {}  # intital attr
        text = None
        tail = None
        sublist = []  # inital array holder
        tag = list(t.keys())  # All of keys added to list
        if len(tag) != 1:  # tag has element
            raise ValueError("[-] Please check your json structure!: %s" % tag)
        tag = tag[0]  # if has element, get root and value
        value = t[tag]
        if isinstance(value, dict):  # if key has child either array nor not value check recursively
            for k, v in list(value.items()):  # Then, all key and value pairs assigned for appended to xml item
                if k[:1] == "-":  # if its attr
                    attribs[k[1:]] = v
                elif k == "#text":  # if it is text
                    text = v
                elif k == "#tail":
                    tail = v
                elif isinstance(v, list):
                    for v2 in v:
                        sublist.append(self.jsonParser({k: v2}, factory=factory))
                else:
                    sublist.append(self.jsonParser({k: v}, factory=factory))
        else:  # assign all key and value pairs
            text = value
        e = factory(tag, attribs)
        for sub in sublist:
            e.append(sub)
        e.text = text
        e.tail = tail
        return e

    def servXml(self, json_data, factory=ElementTree.Element):
        # if not isinstance(json_data, dict):
        #     json_data = json.loads(json_data).decode('utf-8')  # get json then parse it

        parsed_json = self.jsonParser(json_data, factory)
        parsed_data = ElementTree.tostring(parsed_json)  # getted json data toString for writing xml document
        return parsed_data

    def __load_json(self, json_file_path_name):
        with open(json_file_path_name, 'r', encoding='utf8') as f:
            data = json.load(f)
            return data
        return None

    def str_2_str(self, json_data):
        # xml = self.servXml(json_data)
        xml = xmltodict.unparse(json_data,pretty=1)
        return xml

    def file_2_str(self, json_file_path_name):
        data = self.__load_json(json_file_path_name)
        return self.str_2_str(data)

    def str_2_file(self, json_data, xml_file_path_name):
        with open(xml_file_path_name, 'w', encoding='utf8') as f:
            f.write(self.str_2_str(json_data))

    def file_2_file(self, json_file_path_name, yaml_file_path_name, data_format_callback=None):
        data = self.__load_json(json_file_path_name)
        if data_format_callback:
            data = data_format_callback(self, data)
        self.str_2_file(data, yaml_file_path_name)
