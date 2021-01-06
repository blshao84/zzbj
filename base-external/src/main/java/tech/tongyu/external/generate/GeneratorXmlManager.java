package tech.tongyu.external.generate;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;
/**
 * @author kezhenye
 * - mailto: kezhenye@tongyu.tech
 * @description 生成xml
 **/
@Component
public class GeneratorXmlManager implements IFormatGenerator {

    @Override
    public String transformAndSaveFile(String fileName, Header header, List<BodyElement> bodyElementList) {
        try {
            // 创建解析器工厂
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = factory.newDocumentBuilder();
            Document document = db.newDocument();
            document.setXmlStandalone(true);
            // 增加Root节点
            Element root = document.createElement("Root");

            Element head = document.createElement("Header");

            header.getElementList().forEach(dataElement -> {
                Element e = this.addAndSetElementContext(document, dataElement);
                head.appendChild(e);
            });

            root.appendChild(head);

            Element body = document.createElement("Body");

            bodyElementList.forEach(bodyElement -> {
                Element tag = this.generateBody(document, bodyElement);
                body.appendChild(tag);
            });

            root.appendChild(body);
            document.appendChild(root);

            // 创建TransformerFactory对象
            TransformerFactory tff = TransformerFactory.newInstance();
            // 创建 Transformer对象
            Transformer tf = tff.newTransformer();

            // 输出内容是否使用换行
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty(OutputKeys.STANDALONE, "yes");
            // 创建xml文件并写入内容
            tf.transform(new DOMSource(document), new StreamResult(new File(fileName)));

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            tf.transform(new DOMSource(document), new StreamResult(bos));
            String xmlStr = bos.toString();

            System.out.println("生成xml成功");
            return xmlStr;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("生成xml失败");
            return null;
        }
    }

    private Element addAndSetElementContext(Document document, DataElement dataElement) {
        Element element = document.createElement(dataElement.getElementName());

        switch (dataElement.getElementType()) {
            case ELEMENT_ITEM:
                ElementItem elementItem = (ElementItem)dataElement.getValue();
                generateBody(element, document, elementItem);

                break;
            case STRING:
                element.setTextContent(dataElement.getValue().toString());
                break;
            default:
                break;
        }

        return element;
    }

    private Element generateBody(Document document, BodyElement bodyElement) {
        Element tag = document.createElement(bodyElement.getAgreementTag());

        bodyElement.getElementList().forEach(dataElement -> {
            Element e = this.addAndSetElementContext(document, dataElement);
            tag.appendChild(e);
        });
        return tag;
    }

    private Element generateBody(Element tag, Document document, ElementItem bodyElement) {
        bodyElement.getElementList().forEach(dataElement -> {
            Element e = this.addAndSetElementContext(document, dataElement);
            tag.appendChild(e);
        });
        return tag;
    }
}
