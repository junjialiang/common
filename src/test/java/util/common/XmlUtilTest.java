package util.common;

import org.jdom.JDOMException;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by liangjj on 2017/9/13.
 */
public class XmlUtilTest {
    private String xml = "<person><name><![CDATA[H__D]]></name><age>11</age></person>";
//
//    @Test
//    public void testConvertXMLToJson() throws JSONException {
//        JSONObject json = XmlUtil.convertXMLToJson(xml);
//        Assert.assertNotNull(json);
//    }
//
    @Test
    public void testConvertXMLToMap() throws JDOMException, IOException {
        Map map = XmlUtil.convertXMLToMap(xml);
        Assert.assertTrue(map.size() > 0);
    }
//
//    @Test
//    public void testConvertXMLToObject() throws JAXBException {
//        Person person = XmlUtil.convertXMLToObject(xml, Person.class);
//        Assert.assertNotNull(person);
//    }
//
//    @Test
//    public void testConvertBeanToXml() throws JAXBException {
//        Person person = XmlUtil.convertXMLToObject(xml, Person.class);
//        String xml = XmlUtil.convertObjectToXml(person);
//        Assert.assertNotNull(xml);
//    }
}