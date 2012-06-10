package org.bulkframework.common.model;

import java.io.Serializable;

/**
 * TODO
 * 
 * @author wiflish
 * @createTime 2012-6-7 下午11:41:05
 */
public interface FeatureBit extends Serializable {
    public long getFeatureBit();

    public void setFeatureBit(long featureBit);

    public void set(int bitIndex, boolean value);

    public void set(int fromIndex, int toIndex, boolean value);

    public String get(String key);
}
