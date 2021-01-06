package tech.tongyu.external.generate;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.collections4.CollectionUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.xml.sax.SAXException;
import tech.tongyu.core.dto.common.ResponseBodyCommon;
import tech.tongyu.core.dto.common.ResponseCommon;
import tech.tongyu.core.enums.InterfaceInfoEnum;
import tech.tongyu.core.exceptions.CustomException;
import tech.tongyu.core.utils.FileUtils;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.util.*;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description dom4j生成xml
 **/
@Component
public class Dom4jXmlManager {

    private static Logger logger = LoggerFactory.getLogger(Dom4jXmlManager.class);

    private static String path = "xsd";

    public static void createXml(String fileName, LinkedHashMap<String, String> header, List<LinkedHashMap<String, Object>> body, InterfaceInfoEnum agreementTag) {
        try {
            //读入文件
            File file = new File(fileName);
            // 创建一个Document实例
            Document doc = DocumentHelper.createDocument();
            // 添加根节点
            Element root = doc.addElement("Root");

            // 在根节点下添加header节点
            Element headerNode = root.addElement("Header");
            for (Map.Entry<String, String> entry : header.entrySet()) {
                headerNode.addElement(entry.getKey()).addText(entry.getValue());
            }
            // 在根节点下添加header节点
            Element bodyNode = root.addElement("Body");
            for (LinkedHashMap<String, Object> map : body) {
                Element agreementNode = bodyNode.addElement(agreementTag.tag());
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (Objects.isNull(entry.getValue())) {
                        throw new CustomException(String.format("当前字段[%s]值为空,请重新确认", entry.getKey()));
                    }
                    if (entry.getValue() instanceof List) {
                        List<LinkedHashMap<String, String>> value = (List<LinkedHashMap<String, String>>) entry.getValue();
                        for (LinkedHashMap<String, String> node : value) {
                            Element tupleNode = agreementNode.addElement(entry.getKey());
                            for (Map.Entry<String, String> tuple : node.entrySet()) {
                                if (Objects.isNull(tuple.getValue())) {
                                    throw new CustomException(String.format("当前字段[%s]值为空,请重新确认", tuple.getKey()));
                                }
                                tupleNode.addElement(tuple.getKey()).addText(tuple.getValue());
                            }
                        }
                    } else {
                        agreementNode.addElement(entry.getKey()).addText(entry.getValue().toString());
                    }
                }
            }
            // 自定义xml样式
            OutputFormat format = new OutputFormat();
            // 行缩进
            format.setIndentSize(2);
            // 一个结点为一行
            format.setNewlines(true);
            // 去重空格
            format.setTrimText(true);
            //去除standalone
            format.setNewLineAfterDeclaration(false);
            // 输出xml文件
            XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
            writer.write(doc);
            logger.info("生成xml成功,存放路径:{}", fileName);
            writer.close();
        } catch (UnsupportedEncodingException e) {
            logger.info("生成xml失败,转码异常:{}", e.getMessage());
        } catch (FileNotFoundException e) {
            logger.info("生成xml失败,文件未找到:{}", e.getMessage());
        } catch (IOException e) {
            logger.info("生成xml失败,io问题:{}", e.getMessage());
        }
        //校验
        String xsd = path + File.separator + agreementTag.code() + ".xsd";
        validateXml(xsd, fileName);
    }

    public static Boolean validateXml(String xsdPath, String xmlPath) {
        try {
            //建立schema工厂
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            //建立验证文档文件对象,利用此文件对象锁封装的文件进行schema验证
            ClassPathResource classPathResource = new ClassPathResource(xsdPath);
            String xsd = classPathResource.getPath();
            File schemaFile = new File(xsd);
            //利用schema工厂,接收验证文件对象生成的schema对象
            Schema schema = schemaFactory.newSchema(schemaFile);
            //通过Schema产生针对于此Schema的验证器,利用schemaFile进行验证
            Validator validator = schema.newValidator();
            //得到校验的数据源
            Source source = new StreamSource(xmlPath);
            validator.validate(source);
        } catch (Exception e) {
            //删除错误文件
            FileUtils.deleteFile(xmlPath);
            throw new CustomException("xsd校验出现问题:" + e.getMessage());
        }
        //开始校验
        return true;
    }
}
