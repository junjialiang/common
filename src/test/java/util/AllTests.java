package util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import util.common.*;
import util.resources.ConfigManagerTest;
import util.resources.ResourcesUtilTest;

/**
 * Created by liangjj on 2017/10/18.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
//        Base64UtilTest.class,
//        DateUtilTest.class,
//        FileUtilTest.class,
        HttpUtilTest.class,
        CoordinateUtilTest.class,
        WeekUtilTest.class,
//        Md5UtilTest.class,
//        StringUtilTest.class,
//        UrlCoderUtilTest.class,
//        XmlUtilTest.class,
//        ConfigManagerTest.class,
//        ResourcesUtilTest.class,
//        JsonUtilTest.class
})
public class AllTests {
}