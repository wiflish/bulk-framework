package org.bulkframework.common;

import java.io.Serializable;

/**
 * 常量定义.
 * 
 * @author wiflish
 * @createTime 2012-6-7 下午11:13:45
 */
public interface Constants extends Serializable {
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_CN = "yyyy年MM月dd日";
    public static final String DATE_FORMAT_SHORT = "yyyyMMdd";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATETIME_FORMAT_CN = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String DATETIME_FORMAT_SHORT = "yyyyMMddHHmmss";
    public static final String FILE_SEPARATE = "/";
}
