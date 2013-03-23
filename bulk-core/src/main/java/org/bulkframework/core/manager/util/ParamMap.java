/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.core.manager.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author wiflish
 * @since Mar 14, 2013
 */
public class ParamMap {
    private final Map<String, Object> paramMap;

    public ParamMap() {
        paramMap = new HashMap<String, Object>();
    }

    public ParamMap addParam(String key, Object value) {
        paramMap.put(key, value);
        return this;
    }
    
    public static ParamMap build() {
        return new ParamMap();
    }

    public Map<String, Object> toMap() {
        return paramMap;
    }
}
