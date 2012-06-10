package org.bulkframework.common.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.bulkframework.common.util.fastjson.FastJsonUtil;

/**
 * 
 * @author wiflish
 * @createTime 2012-6-7 下午10:46:32
 */
public class DefaultFeatureJson implements FeatureJson {
    private static final long serialVersionUID = -3201322435690855219L;
    private Map<String, Object> jsonMap = new HashMap<String, Object>();

    /*
     * (non-Javadoc)
     * 
     * @see org.bulkframework.common.model.FeatureJson#getFeatureJson()
     */
    @Override
    public String getFeatureJson() {
        return FastJsonUtil.parseMapToJsonWithFormatCalendar(jsonMap);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setFeatureJson(String featureJson) {
        if (StringUtils.isBlank(featureJson)) {
            return;
        }

        jsonMap = FastJsonUtil.parseJsonStringToObject(featureJson, Map.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.bulkframework.common.model.FeatureJson#addFeature(java.lang.String, java.lang.String)
     */
    @Override
    public void addFeature(String key, String value) {
        if (StringUtils.isBlank(key)) {
            return;
        }
        jsonMap.put(key, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.bulkframework.common.model.FeatureJson#addFeature(java.lang.String, java.lang.Object)
     */
    @Override
    public void addFeature(String key, Object value) {
        if (StringUtils.isBlank(key)) {
            return;
        }
        jsonMap.put(key, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.bulkframework.common.model.FeatureJson#removeFeature(java.lang.String)
     */
    @Override
    public void removeFeature(String key) {
        jsonMap.remove(key);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.bulkframework.common.model.FeatureJson#getFeature(java.lang.String)
     */
    @Override
    public String getFeature(String key) {
        return (String) jsonMap.get(key);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.bulkframework.common.model.FeatureJson#getFeatureObj(java.lang.String)
     */
    @Override
    public Object getFeatureObj(String key) {
        return jsonMap.get(key);
    }
}
