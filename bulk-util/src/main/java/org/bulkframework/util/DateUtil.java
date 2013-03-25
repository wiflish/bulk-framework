/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.util;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类.
 * 
 * @author wiflish
 * @since Mar 25, 2013
 */
public class DateUtil {
    /**
     * 将从数据库中取出的默认值1970-01-01日期字段转换为NULL.
     * 
     * @param value
     * @return
     */
    public static Date convert19700101toNull(Date value) {
        if (value == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();

        cal.setTime(value);

        int year = cal.get(Calendar.YEAR), month = cal.get(Calendar.MONTH), day = cal.get(Calendar.DAY_OF_MONTH);

        if (year == 1970 && month == 0 && day == 1) {
            return null;
        }

        return value;
    }
}
