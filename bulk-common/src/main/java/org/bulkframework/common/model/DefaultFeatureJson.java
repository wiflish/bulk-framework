package org.bulkframework.common.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 扩展字段接口的默认实现，采用fastjson实现JSON的序列化与反序列化.
 * 
 * @author wiflish
 * @createTime 2012-6-7 下午10:46:32
 */
public abstract class DefaultFeatureJson implements FeatureJson {
    private static final long serialVersionUID = -3201322435690855219L;

    public String toJSONString() {
        // 序列化为json时，带上类名信息，在反序列化时使用.
        return JSON.toJSONString(this, SerializerFeature.WriteClassName);
    }
}
