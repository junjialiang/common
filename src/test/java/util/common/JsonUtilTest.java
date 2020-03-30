package util.common;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by liangjj on 2017/10/18.
 */
public class JsonUtilTest {
    private String json = "{\n" +
            "    \"user_name\":\"H__D\",\n" +
            "    \"age\":11,\n" +
            "    \"sex\":\"男\"\n" +
            "}";

//    @Test
//    public void testConvertJsonToObject() throws IOException {

//        Person person = JSON.parseObject(json, Person.class);
//        Assert.assertEquals("H__D", person.getName());
//        Assert.assertEquals("11", String.valueOf(person.getAge()));
//    }

    @Test
    public void testJsonToMap() {
        Map map = JsonUtil.jsonToMap(json);
        Assert.assertEquals(3, map.size());
    }
}
