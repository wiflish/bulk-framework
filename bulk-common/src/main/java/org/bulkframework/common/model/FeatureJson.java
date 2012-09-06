package org.bulkframework.common.model;

import java.io.Serializable;

/**
 * 
 * 扩展字段接口，不用于where条件. 子类需实现toString
 * 
 * @author wiflish
 * @createTime 2012-9-5 下午5:39:40
 */
public interface FeatureJson extends Serializable {
    /**
     * 转换为JSON字串.
     * 
     * @return JSON字串.
     */
    public String toJSONString();
}
