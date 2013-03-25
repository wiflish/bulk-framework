/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.webapp.spring.propertyeditors;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.bulkframework.common.Constants;

/**
 * 将String转为Date. 仅处理只包含日期不包含时分秒的数据.
 * 
 * @author wiflish
 * @since Mar 25, 2013
 */
public class BulkDateEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Date date = DateUtils.parseDate(text, Constants.DATE_FORMAT, Constants.DATE_FORMAT_CN);

            setValue(date);
        } catch (ParseException e) {
            setValue(null);
        }
    }

    /**
     * Format the Date as String, using the specified DateFormat.
     */
    @Override
    public String getAsText() {
        Date value = (Date) getValue();

        return DateFormatUtils.format(value, Constants.DATE_FORMAT);
    }
}
