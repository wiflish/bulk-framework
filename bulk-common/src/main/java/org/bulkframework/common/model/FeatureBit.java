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

/**
 * 扩展字段，用于标记数据状态值，位操作。可以定义一个或多个位表示一个或多种状态.
 * 
 * @author wiflish
 * @createTime 2012-6-7 下午11:41:05
 */
public class FeatureBit implements Serializable {
    private static final long serialVersionUID = -7411993598092794651L;
    private long value;

    public FeatureBit() {
    }

    public FeatureBit(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    /**
     * 检查featureBit是否在参数对应的字节全部已设置为1.
     * 
     * @param flagBit 待检查的标记值.
     * @return 当且仅当参数值对应的位都已设置为1返回true, 否则返回false.
     */
    public boolean getBits(long flagBit) {
        if (flagBit == 0) {
            return false;
        }
        return ((value & flagBit) == flagBit);
    }

    /**
     * 将flagBit对应的位设置到featureBit中。
     * 
     * @param flagBit 位标记对应的值.
     * @return 返回设置后的值.
     */
    public FeatureBit setBits(long flagBit) {
        value |= flagBit;
        return this;
    }
}
