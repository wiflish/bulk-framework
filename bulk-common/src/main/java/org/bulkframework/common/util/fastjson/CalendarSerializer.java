package org.bulkframework.common.util.fastjson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bulkframework.common.Constants;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

public class CalendarSerializer implements ObjectSerializer {
    public CalendarSerializer() {
    }

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType) throws IOException {
        if (object == null) {
            serializer.getWriter().writeNull();
            return;
        }

        Calendar date = (Calendar) object;
        SimpleDateFormat format = new SimpleDateFormat(Constants.DATETIME_FORMAT);

        String text = format.format(date.getTime());

        serializer.write(text);
    }
}
