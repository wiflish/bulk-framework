package org.bulkframework.common.model;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * 扩展字段处理, 在项目中由子类实现具体的字段定义. <br>
 * 扩展字段，保存字符串或带类型的数据，长度：255，Json结构，尽量使用简称.
 * 
 * @author wiflish
 * @createTime 2012-6-7 下午10:17:09
 */
public abstract class BaseFeatureJson implements Serializable {
    private static final long serialVersionUID = 7731221015135509375L;

    /**
     * 将对象转换为JSON.
     */
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
