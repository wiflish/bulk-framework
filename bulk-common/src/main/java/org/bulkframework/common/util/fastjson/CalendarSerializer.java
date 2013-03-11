package org.bulkframework.common.util.fastjson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Calendar;

import org.apache.commons.lang.time.DateFormatUtils;
import org.bulkframework.common.Constants;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

public class CalendarSerializer implements ObjectSerializer {
    // 日期格式化参数.
    private String pattern;

    public CalendarSerializer() {
        this.pattern = Constants.DATETIME_FORMAT;
    }

    public CalendarSerializer(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType) throws IOException {
        if (object == null) {
            serializer.getWriter().writeNull();
            return;
        }

        Calendar date = (Calendar) object;

        String text = DateFormatUtils.format(date, pattern);

        serializer.write(text);
    }
}
