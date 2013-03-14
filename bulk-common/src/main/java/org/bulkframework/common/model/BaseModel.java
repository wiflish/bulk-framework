/**
 * Copyright 2011-2012 [wiflish.xie@gmail.com].
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
    protected Long id;

    /** 记录状态， -1=已删除 */
    protected Byte status;

    /** 记录创建时间. */
    protected Calendar createTime;

    /** 记录更新时间. */
    protected Calendar updateTime;

    /** 扩展字段，保存标识数据，按位操作，具体的位的业务含义由各个业务表自行定义. */
    protected FeatureBit featureBit;

    /** 扩展字段，Json结构. 长度限制为1000以内. */
    protected FeatureJson featureJson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public FeatureBit getFeatureBit() {
        return featureBit;
    }

    public void setFeatureBit(FeatureBit featureBit) {
        this.featureBit = featureBit;
    }

    public FeatureJson getFeatureJson() {
        return featureJson;
    }

    public void setFeatureJson(FeatureJson featureJson) {
        this.featureJson = featureJson;
    }
}
