package tech.tongyu.external.analyze;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;
import tech.tongyu.core.dto.common.ResponseBodyCommon;
import tech.tongyu.core.dto.common.ResponseCommon;
import tech.tongyu.core.dto.common.ResponseHeaderCommon;
import tech.tongyu.core.exceptions.CustomException;
import tech.tongyu.core.utils.common.JsonUtils;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.*;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description xml解析
 **/
@Component
public class XmlAnalyzeManager {

    public static Boolean validateXml(String xsdPath, String xmlPath) throws SAXException, IOException {
        //建立schema工厂
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        //建立验证文档文件对象,利用此文件对象锁封装的文件进行schema验证
        File schemaFile = new File(xsdPath);
        //利用schema工厂,接收验证文件对象生成的schema对象
        Schema schema = schemaFactory.newSchema(schemaFile);
        //通过Schema产生针对于此Schema的验证器,利用schemaFile进行验证
        Validator validator = schema.newValidator();
        //得到校验的数据源
        Source source = new StreamSource(xmlPath);
        //开始校验
        try {
            validator.validate(source);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static ResponseCommon analyzeXml(String filePath) {
        // 创建SAXReader的对象reader
        SAXReader reader = new SAXReader();
        FileInputStream fis = null;
        FileChannel fc = null;
        FileLock fl = null;
        try {
            fis = new FileInputStream(filePath);
            fc = fis.getChannel();
            fl = fc.tryLock(0,Long.MAX_VALUE,true);
            // 通过reader对象的read方法加载xml文件,获取document对象。
            Document document = reader.read(fis);
            // 通过document对象获取根节点
            Element root = document.getRootElement();
            Element header = root.element("Header");
            //解析头部文件
            Map<String, Object> headerMap = new HashMap<>();
            for(Element element : header.elements()) {
                headerMap.put(element.getName(), element.getTextTrim());
            }
            ResponseHeaderCommon headerCommons = JsonUtils.mapper.convertValue(headerMap, ResponseHeaderCommon.class);
            Element body = root.element("Body");
            //解析实体内容
            List<ResponseBodyCommon> bodyCommons = new ArrayList<>();
            if (Objects.nonNull(body)) {
                for(Element element : body.elements()) {
                    Map<String, Object> bodyMap = new HashMap<>();
                    element.elements().forEach(report -> bodyMap.put(report.getName(), report.getTextTrim()));
                    ResponseBodyCommon responseBodyCommon = JsonUtils.mapper.convertValue(bodyMap, ResponseBodyCommon.class);
                    bodyCommons.add(responseBodyCommon);
                }
            }
            return new ResponseCommon(headerCommons, bodyCommons);
        } catch (Exception e) {
            throw new CustomException("解析xml失败,请联系管理员,错误信息" + e.getMessage());
        }finally{
            try{
                if(null != fl){
                    fl.release();
                    fl.close();
                }
                if(null != fc&&fc.isOpen()){
                    fc.close();
                }
                if(null != fis){
                    fis.close();
                }
            }catch(Exception e){
                throw new CustomException("关闭文件出错" + e.getMessage());
            }
        }
    }
}
