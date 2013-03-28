/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.webapp.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * http相关工具类.
 * 
 * @author wiflish
 * @since Mar 28, 2013
 */
public class HttpServletUtil {
    /**
     * 获得请求url的全路径.包含查询参数.
     * 
     * @param request
     * @return
     */
    public static String getRequestFullUrl(HttpServletRequest request) {
        String schema = request.getScheme();
        String serverName = request.getServerName();
        int port = request.getServerPort();
        String requestPath = request.getRequestURI();
        String query = request.getQueryString();

        StringBuilder result = new StringBuilder(64);

        result.append(schema).append("://");
        result.append(serverName);
        if (port != 80) {
            result.append(":").append(port);
        }
        result.append(requestPath);
        if (!StringUtils.isEmpty(query)) {
            result.append(query);
        }

        return result.toString();
    }

    /**
     * 获得服务器路径. 不包含请求子路径和查询参数，如：<br>
     * <p>
     * 请求 http://www.bulkframework.org/index.html 返回 http://www.bulkframework.org
     * </p>
     * 
     * @param request
     * @return
     */
    public static String getServerUrl(HttpServletRequest request) {
        String schema = request.getScheme();
        String serverName = request.getServerName();
        int port = request.getServerPort();
        String contextPath = request.getContextPath();

        StringBuilder result = new StringBuilder(32);

        result.append(schema).append("://");
        result.append(serverName);
        if (port != 80) {
            result.append(":").append(port);
        }
        if (!"/".equals(contextPath)) {
            result.append(contextPath);
        }

        return result.toString();
    }
}
