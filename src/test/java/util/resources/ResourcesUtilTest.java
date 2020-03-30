package util.resources;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by liangjj on 2017/9/15.
 */
public class ResourcesUtilTest {
    @Test
    public void testGetFilePath() {
        String filePath = ResourcesUtil.getFilePath("20200219174433657375.pdf");
        Assert.assertNotNull(filePath);
    }
}
