package util.common;

import org.junit.Assert;
import org.junit.Test;
import util.resources.ResourcesUtils;

/**
 * Created by liangjj on 2017/9/15.
 */
public class FileUtilsTest {
    private String pathname = "D:\\code\\logs\\hmall-common-info.log";

    @Test
    public void testIsExist() {
        boolean isExist1 = FileUtils.isExist(ResourcesUtils.getFilePath("test"));
        Assert.assertTrue(isExist1);
        boolean isExist2 = FileUtils.isExist(ResourcesUtils.getFilePath("Test1"));
        Assert.assertFalse(isExist2);
    }

    @Test
    public void testGetBytesFromFile() {
        byte[] bytes = FileUtils.getBytes(pathname);
        Assert.assertTrue(bytes.length > 0);
    }

    @Test
    public void testGetFileName() {
        String filename = FileUtils.getFileName(pathname);
        Assert.assertEquals("hmall-common-info.log", filename);
    }

    @Test
    public void testReadFileContent() {
        String path = ResourcesUtils.getFilePath("test");
        String result = FileUtils.readFileContent(path);
        Assert.assertEquals("123", result);
    }
}