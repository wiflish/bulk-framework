/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.webapp.spring.propertyeditors;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.bulkframework.common.Constants;

/**
 * 将String转为Calendar. 处理日期包含时分秒的数据.
 * 
 * @author wiflish
 * @since Mar 25, 2013
 */
public class BulkCalendarEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Calendar cal = Calendar.getInstance();
        try {
            Date date = DateUtils.parseDate(text, Constants.DATETIME_FORMAT, Constants.DATETIME_FORMAT_CN,
                    Constants.DATE_FORMAT, Constants.DATE_FORMAT_CN);

            cal.setTime(date);
            setValue(cal);
        } catch (ParseException e) {
            setValue(null);
        }
    }

    /**
     * Format the Date as String, using the specified DateFormat.
     */
    @Override
    public String getAsText() {
        Calendar value = (Calendar) getValue();

        return DateFormatUtils.format(value, Constants.DATETIME_FORMAT);
    }
}
