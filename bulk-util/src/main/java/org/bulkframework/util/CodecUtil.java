/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.util;

import org.apache.commons.codec.digest.Sha2Crypt;
import org.apache.commons.lang3.StringUtils;

/**
 * 加密/解密工具类
 * 
 * @author wiflish
 * @since Mar 28, 2013
 */
public class CodecUtil {
    private static final String saltSpacer = "$";
    private static final String sha256SaltPrefix = "$5$";

    /**
     * SHA-256加密.
     * 
     * @param key
     * @return
     */
    public static String sha256Crypt(String key, String salt) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(salt)) {
            return key;
        }
        String encrypt = Sha2Crypt.sha256Crypt(key.getBytes(), (sha256SaltPrefix + salt));

        int start = encrypt.lastIndexOf(saltSpacer);
        int len = encrypt.length();

        return encrypt.substring(start + 1, len);
    }

    /**
     * SHA-256加密.
     * 
     * @param key
     * @return
     */
    public static String sha256Crypt(String key) {
        if (StringUtils.isEmpty(key)) {
            return key;
        }
        String encrypt = Sha2Crypt.sha256Crypt(key.getBytes());

        int start = encrypt.lastIndexOf(saltSpacer);
        int len = encrypt.length();

        return encrypt.substring(start + 1, len);
    }
}
