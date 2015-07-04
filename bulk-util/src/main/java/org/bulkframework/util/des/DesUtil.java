package org.bulkframework.util.des;

import com.alibaba.fastjson.JSON;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * 3des算法加解密工具类.
 *
 * @author xiezhengrong
 * @since 1.0.0
 */
public class DesUtil {
    /**
     * 算法枚举
     */
    private enum DesAlgorithmEnum {
        /**
         * DES
         */
        DES,
        /**
         * DESede, 即常用的3DES
         */
        DESede,
        /**
         * Blowfish
         */
        Blowfish;

        public static void checkSupported(String algorithm) {
            try {
                DesAlgorithmEnum.valueOf(algorithm);
            } catch (IllegalArgumentException e) {
                String json = JSON.toJSONString(DesAlgorithmEnum.values());
                throw new RuntimeException("不支持的加密算法, 仅支持: " + json);
            }
        }
    }

    /**
     * 加密字节数组, 默认3des算法.
     *
     * @param data       待加密字节数组.
     * @param encryptKey 加密密钥.
     * @return
     */
    public static byte[] encrypt(byte[] data, String encryptKey) {
        return encrypt(data, encryptKey, DesAlgorithmEnum.DESede.name());
    }

    /**
     * 加密字节数组.
     *
     * @param data       待加密字节数组.
     * @param encryptKey 加密密钥.
     * @param algorithm  算法. 支持： DES
     * @return
     */
    public static byte[] encrypt(byte[] data, String encryptKey, String algorithm) {
        DesAlgorithmEnum.checkSupported(algorithm);

        SecretKey secretKey = new SecretKeySpec(build3DesKey(encryptKey), algorithm);
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("不支持的加密算法, 仅支持: " + DesAlgorithmEnum.values());
        } catch (Exception e) {
            throw new RuntimeException("加密处理失败. ", e);
        }
    }

    /**
     * 加密字符串.
     *
     * @param data
     * @param encryptKey
     * @return
     */
    public static byte[] encrypt(String data, String encryptKey) {
        return encrypt(data.getBytes(), encryptKey);
    }

    /**
     * 加密字符串.
     *
     * @param data
     * @param encryptKey
     * @param algorithm
     * @return
     */
    public static byte[] encrypt(String data, String encryptKey, String algorithm) {
        return encrypt(data.getBytes(), encryptKey, algorithm);
    }

    /**
     * 加密字符串为十六进制字符串.
     *
     * @param data
     * @param encryptKey
     * @return
     */
    public static String encrypt2HexString(String data, String encryptKey) {
        byte[] encrptyData = encrypt(data, encryptKey);

        return byte2Hex(encrptyData);
    }

    /**
     * 加密字符串为十六进制字符串.
     *
     * @param data
     * @param encryptKey
     * @param algorithm
     * @return
     */
    public static String encrypt2HexString(String data, String encryptKey, String algorithm) {
        byte[] encrptyData = encrypt(data, encryptKey, algorithm);

        return byte2Hex(encrptyData);
    }

    /**
     * 解密.
     *
     * @param data       待解密数据
     * @param decryptKey 解密密钥
     * @return
     */
    public static byte[] decrypt(String data, String decryptKey) {
        return decrypt(data.getBytes(), decryptKey, DesAlgorithmEnum.DESede.name());
    }

    /**
     * 解密.
     *
     * @param data       待解密数据
     * @param decryptKey 解密密钥
     * @return
     */
    public static byte[] decrypt(String data, String decryptKey, String algorithm) {
        return decrypt(data.getBytes(), decryptKey, algorithm);
    }

    /**
     * 解密.
     *
     * @param data       待解密数据
     * @param decryptKey 解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] data, String decryptKey) {
        return decrypt(data, decryptKey, DesAlgorithmEnum.DESede.name());
    }

    /**
     * 解密.
     *
     * @param data       待解密数据
     * @param decryptKey 解密密钥
     * @param algorithm  算法.支持 {@link DesAlgorithmEnum}
     * @return
     */
    public static byte[] decrypt(byte[] data, String decryptKey, String algorithm) {
        DesAlgorithmEnum.checkSupported(algorithm);

        SecretKey secretKey = new SecretKeySpec(build3DesKey(decryptKey), algorithm);
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("不支持的加密算法, 仅支持: " + DesAlgorithmEnum.values());
        } catch (Exception e) {
            throw new RuntimeException("解密处理失败. ", e);
        }
    }

    /**
     * 解密.
     *
     * @param data       待解密数据
     * @param decryptKey 解密密钥
     * @return
     */
    public static String decryptToString(String data, String decryptKey) {
        return new String(decrypt(data.getBytes(), decryptKey));
    }

    /**
     * 解密.
     *
     * @param data       待解密数据
     * @param decryptKey 解密密钥
     * @return
     */
    public static String decryptToString(byte[] data, String decryptKey) {
        return new String(decrypt(data, decryptKey));
    }

    /**
     * 解密.
     *
     * @param data       待解密数据
     * @param decryptKey 解密密钥
     * @param algorithm  算法.
     * @return
     */
    public static String decryptToString(byte[] data, String decryptKey, String algorithm) {
        return new String(decrypt(data, decryptKey, algorithm));
    }

    /**
     * 解密.
     *
     * @param data       待解密数据
     * @param decryptKey 解密密钥
     * @return
     */
    public static String decryptToString(String data, String decryptKey, String algorithm) {
        return new String(decrypt(data.getBytes(), decryptKey, algorithm));
    }

    /**
     * 将加密字节数组转换为16进制.
     *
     * @param b
     * @return
     */
    private static String byte2Hex(byte[] b) {
        StringBuilder result = new StringBuilder("");
        String tmp;
        for (int n = 0; n < b.length; n++) {
            tmp = (Integer.toHexString(b[n] & 0XFF));
            if (tmp.length() == 1) {
                result.append("0").append(tmp);
            } else {
                result.append(tmp);
            }
        }
        return result.toString().toUpperCase();
    }

    /*
     * 根据密钥生成密钥字节数组
     * @param keyStr 密钥字符串
     * @return
     * @throws UnsupportedEncodingException
     */
    private static byte[] build3DesKey(String keyStr) {
        byte[] key = new byte[24];    //声明一个24位的字节数组，默认里面都是0
        byte[] temp;
        try {
            temp = keyStr.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        if (key.length > temp.length) {
            System.arraycopy(temp, 0, key, 0, temp.length);
        } else {
            System.arraycopy(temp, 0, key, 0, key.length);
        }
        return key;
    }
}
