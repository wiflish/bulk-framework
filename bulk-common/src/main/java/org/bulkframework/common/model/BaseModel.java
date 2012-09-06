package org.bulkframework.common.model;

import java.io.Serializable;
import java.util.Calendar;

/**
 * 基本模型.所有域对象需继承本抽象类.
 * 
 * @author wiflish
 * @createTime 2012-6-3 下午11:55:24
 */
public abstract class BaseModel<F extends FeatureJson> implements Serializable {
    private static final long serialVersionUID = 6742295437488171192L;

    /** 记录主键id */
    protected Integer id;

    /** 记录状态， -1=已删除 */
    protected Byte status;

    /** 记录创建时间. */
    protected Calendar createTime;

    /** 记录更新时间. */
    protected Calendar updateTime;

    /** 扩展字段，保存数值型数据，定义数值区间为一个字段，如：[200-300]. */
    protected Long featureNum;

    /** 扩展字段，Json结构. 长度限制为255以内. */
    private F featureJson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Calendar getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Calendar createTime) {
        this.createTime = createTime;
    }

    public Calendar getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Calendar updateTime) {
        this.updateTime = updateTime;
    }

    public Long getFeatureNum() {
        return featureNum;
    }

    public void setFeatureNum(Long featureNum) {
        this.featureNum = featureNum;
    }

    public F getFeatureJson() {
        return featureJson;
    }

    public void setFeatureJson(F featureJson) {
        this.featureJson = featureJson;
    }
}
