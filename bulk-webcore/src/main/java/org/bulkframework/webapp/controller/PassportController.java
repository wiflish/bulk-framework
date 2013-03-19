/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author wiflish
 * @since Mar 19, 2013
 */
public interface PassportController<T> {
    /**
     * 登录.
     * 
     * @param request
     * @param response
     * @return
     */
    public T login(HttpServletRequest request, HttpServletResponse response);

    /**
     * 登出.
     * 
     * @param request
     * @param response
     */
    public void logout(HttpServletRequest request, HttpServletResponse response);

    /**
     * 获得登录信息.
     * 
     * @param request
     * @param response
     * @return
     */
    public T getLoginInfo(HttpServletRequest request, HttpServletResponse response);
}
