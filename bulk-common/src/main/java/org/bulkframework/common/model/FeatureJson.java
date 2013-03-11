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

import com.alibaba.fastjson.JSON;

/**
 * 
 * 扩展字段，不用于where条件.
 * 
 * @author wiflish
 * @createTime 2012-9-5 下午5:39:40
 */
public class FeatureJson implements Serializable {
    private static final long serialVersionUID = 7276217004810051310L;
    private String value;

    public FeatureJson() {
    }

    public FeatureJson(String value) {
        this.value = value;
    }

    public <T> FeatureJson(T obj) {
        if (obj == null) {
            return;
        }
        this.value = JSON.toJSONString(obj);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public <T> void setValue(T obj) {
        if (obj == null) {
            return;
        }
        this.value = JSON.toJSONString(obj);
    }

    /**
     * 将json结构字符串解析为Java对象。
     * 
     * @param clazz
     * @return 返回java对象。如果解析出现异常，返回<span class="code">NULL</span>
     */
    public <T> T toJavaObject(Class<T> clazz) {
        try {
            T result = JSON.parseObject(value, clazz);
            return result;
        } catch (Exception e) {
            return null;
        }
    }
}
