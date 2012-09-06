package org.bulkframework.common.util.fastjson;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * FastJson工具类.
 * 
 * @author wiflish
 * @createTime 2012-6-7 下午11:11:20
 */
public class FastJsonUtil {
    /**
     * 将POJO转换为json格式, Calendar类型的属性按"yyyy-MM-dd HH:mm:ss"格式对Calendar格式化.
     * 
     * @param object
     * @return
     * @create_time 2012-5-23 上午9:08:15
     */
    public static String parseObjectToJsonWithFormatCalendar(Object object, SerializerFeature... features) {
        if (object == null) {
            return "{}";
        }

        SerializeConfig config = new SerializeConfig();
        config.put(Calendar.class, new CalendarSerializer());
        config.put(GregorianCalendar.class, new CalendarSerializer());

        return JSON.toJSONString(object, config, features);
    }

    /**
     * 将POJO转换为json格式, Calendar类型的属性按"yyyy-MM-dd HH:mm:ss"格式对Calendar格式化.
     * 
     * @param object
     * @return
     * @create_time 2012-5-23 上午9:08:15
     */
    public static String parseObjectToJsonWithFormatCalendar(Object object, String format, SerializerFeature... features) {
        if (object == null) {
            return "{}";
        }

        SerializeConfig config = new SerializeConfig();
        config.put(Calendar.class, new CalendarSerializer(format));
        config.put(GregorianCalendar.class, new CalendarSerializer(format));

        return JSON.toJSONString(object, config, features);
    }

    /**
     * 将json格式反序列化为对象.
     * 
     * @param json
     * @return
     * @create_time 2012-6-1 下午4:53:48
     */
    public static <T> T parseJsonStringToObject(String json, Class<T> clz) {
        try {
            return JSON.parseObject(json, clz);
        } catch (JSONException ex) {
            return null;
        }
    }
}
