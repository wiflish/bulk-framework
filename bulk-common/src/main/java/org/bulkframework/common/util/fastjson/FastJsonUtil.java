package org.bulkframework.common.util.fastjson;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;

/**
 * FastJson工具类.
 * 
 * @author wiflish
 * @createTime 2012-6-7 下午11:11:20
 */
public class FastJsonUtil {
    /** FastJson的序列化转换映射 */
    public static SerializeConfig FASTJSON_MAPPING = new SerializeConfig();

    static {
        FASTJSON_MAPPING.put(Calendar.class, new CalendarSerializer());
        FASTJSON_MAPPING.put(GregorianCalendar.class, new CalendarSerializer());
    }

    /**
     * 将POJO转换为json格式, 按"yyyy-MM-dd HH:mm:ss"格式对Calendar格式化.
     * 
     * @param object
     * @return
     * @create_time 2012-5-23 上午9:08:15
     */
    public static String parseObjectToJsonWithFormatCalendar(Object object) {
        if (object == null) {
            return "{}";
        }

        return JSON.toJSONString(object, FASTJSON_MAPPING);
    }

    /**
     * 将Map转换为json格式, 按"yyyy-MM-dd HH:mm:ss"格式对Calendar格式化.
     * 
     * @param objMap
     * @return
     * @create_time 2012-5-23 上午9:08:15
     */
    public static String parseMapToJsonWithFormatCalendar(Map<String, Object> objMap) {
        if (objMap == null) {
            return "{}";
        }

        return JSON.toJSONString(objMap, FASTJSON_MAPPING);
    }

    /**
     * 将json格式反序列化为对象.
     * 
     * @param json
     * @return
     * @create_time 2012-6-1 下午4:53:48
     */
    public static <T> T parseJsonStringToObject(String json, Class<T> clz) {
        return JSON.parseObject(json, clz);
    }
}
