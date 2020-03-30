package util.common;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liangjj on 2017/9/13.
 */
class XmlUtil {
    private XmlUtil() {
    }

    /**
     * 将字符串类型的 XML 转换成 JSON 对象
     *
     * @param xmlStr
     * @return
     * @throws JSONException
     */
//    static JSONObject convertXMLToJson(String xmlStr) throws JSONException {
//        return XML.toJSONObject(xmlStr);
//    }

    /**
     * 将字符串类型的 XML 转换成 Map    对象
     *
     * @param xmlStr
     * @return
     */
    static Map convertXMLToMap(String xmlStr) throws JDOMException, IOException {
        Map<String, String> hashMap = new HashMap<>();
        // 创建一个新字符串 reader
        StringReader stringReader = new StringReader(xmlStr);
        // 使用字节流创建新的输入源
        InputSource inputSource = new InputSource(stringReader);

        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputSource);
        Element rootElement = document.getRootElement();

        List<Element> elements = new ArrayList<>();
        List list = rootElement.getChildren();
        for (Object o : list) {
            elements.add((Element) o);
        }
        if (!elements.isEmpty()) {
            for (Element element : elements) {
                hashMap.put(element.getName(), element.getText());
            }
        }
        return hashMap;
    }

    /**
     * 将 XML 字符串转换成对象
     *
     * @param xmlStr
     * @param obj
     * @param <T>
     * @return
     * @throws JAXBException
     */
//    @SuppressWarnings("unchecked")
//    static <T> T convertXMLToObject(String xmlStr, Class<T> obj) throws JAXBException {
//        JAXBContext context = JAXBContext.newInstance(obj);
//        Unmarshaller unmarshaller = context.createUnmarshaller();
//        return (T) unmarshaller.unmarshal(new StringReader(xmlStr));
//    }

    /**
     * 将对象转换成 XML 字符串
     *
     * @param obj
     * @param <T>
     * @return
     * @throws JAXBException
     */
//    static <T> String convertObjectToXml(T obj) throws JAXBException {
//        JAXBContext context = JAXBContext.newInstance(obj.getClass());
//        Marshaller marshaller = context.createMarshaller();
//        StringWriter stringWriter = new StringWriter();
//        marshaller.marshal(obj, stringWriter);
//        return stringWriter.toString();
//    }
}