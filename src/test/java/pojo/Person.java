package pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by liangjj on 2017/9/15.
 */
//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
// 控制 JAXB 绑定类中属性和字段的排序
//@XmlType(propOrder = {"age", "name"})
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class Person {

//    @JSONField(name = "user_name")
//    private String name;
//
//    private Integer age;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//}
