package org.bulkframework.common.model;

import java.io.Serializable;
import java.util.Calendar;

/**
 * 基本模型.所有域对象需继承本抽象类.
 * 
 * @author wiflish
 * @createTime 2012-6-3 下午11:55:24
 */
public abstract class BaseModel implements Serializable {
    private static final long serialVersionUID = 6742295437488171192L;

    /** 记录主键id */
    protected Integer id;

    /** 记录状态， -1=已删除 */
    protected Byte status;

    /** 记录创建时间. */
    protected Calendar createTime;

    /** 记录更新时间. */
    protected Calendar updateTime;

    /** 扩展字段，保存字符串或带类型的数据，长度：1024，Json结构. */
    protected FeatureJson featureJson;

    /** 扩展字段，保存数值型数据，位操作. */
    protected Long featureBit;
}
