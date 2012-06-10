package org.bulkframework.common.model;

import java.io.Serializable;

/**
 * 
 * @author wiflish
 * @createTime 2012-6-7 下午10:17:09
 */
public interface FeatureJson extends Serializable {
    public String getFeatureJson();

    public void setFeatureJson(String featureJson);

    public void addFeature(String key, String value);

    public void addFeature(String key, Object value);

    public void removeFeature(String key);

    public String getFeature(String key);

    public Object getFeatureObj(String key);

}
