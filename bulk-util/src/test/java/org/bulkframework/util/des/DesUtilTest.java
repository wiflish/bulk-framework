package org.bulkframework.util.des;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 测试加解密.
 *
 * @author xiezhengrong
 * @since 1.0.0
 */
public class DesUtilTest {

    @Test
    public void testEncrypt() throws Exception {
        String src = "1231231#1231adadasda";
        String key = "123456";
        String encrypted = "2C0CD9B32B4FE4B854F20D8C17BCEF43D73AD977AFFA8A6B";

        String result = DesUtil.encrypt2HexString(src, key);

        System.out.println(result);
        assertEquals(encrypted, result);

        try {
            DesUtil.encrypt2HexString(src, key, "123");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("不支持的加密算法"));
        }
    }

    @Test
    public void testDecrypt() throws Exception {
        String src = "testEncrosada";
        String key = "123456";

        byte[] result = DesUtil.encrypt(src, key);

        String decryptToString = DesUtil.decryptToString(result, key);

        assertEquals(src, decryptToString);
        System.out.println(decryptToString);

    }
}