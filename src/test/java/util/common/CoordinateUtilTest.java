package util.common;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.Objects;

/**
 * Created by Junjia on 2019/12/31 13:31.
 */
public class CoordinateUtilTest {

    @Test
    public void getLngLat() {
        String address = "上海市闵行区申富路611号A栋";
        // 获得经纬度
        Map<String, String> json = CoordinateUtil.getLngLat(address);
        Assert.assertNotNull(Objects.requireNonNull(json).get("lng"));
        Assert.assertNotNull(json.get("lat"));
    }
}