package org.bulkframework.common.model;

/**
 * 扩展字段接口.
 * 
 * @author wiflish
 * @createTime 2012-6-6 下午5:15:17
 */
public interface ExtensionField {
    public String getFeatureJson();

    public void setFeatureJson(String featureJson);

    public int getFeatureJsonVersion();

    public void setFeatureJsonVersion(int featureJsonVersion);

    public long getFeatureBit();

    public void setFeatureBit(long featureBit);

    public int getFeatureBitVersion();

    public void setFeatureBitVersion(int featureBitVersion);

    public void addFeature(String key, String value);

    public void addFeature(String key, Object value);

    public void removeFeature(String key);

    public String getFeature(String key);

    public Object getFeatureObj(String key);

}
