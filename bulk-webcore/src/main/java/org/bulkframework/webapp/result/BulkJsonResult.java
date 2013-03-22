/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.webapp.result;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * 请求返回结果为JSON对象封装.
 * 
 * @author wiflish
 * @since Mar 20, 2013
 */
public class BulkJsonResult<T> implements Serializable {
    private static final long serialVersionUID = -6585494936971138568L;
    private int code = 200; // 消息code.
    private boolean success = true; // 默认消息成功.
    private T model; // 需要带回的数据结构.
    private String message = "操作成功"; // 返回消息.

    public BulkJsonResult() {
    }

    public BulkJsonResult(String message) {
        this.message = message;
    }

    public BulkJsonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BulkJsonResult(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public BulkJsonResult(String message, T model) {
        this.message = message;
        this.model = model;
    }

    public BulkJsonResult(T model) {
        this.model = model;
    }

    public BulkJsonResult(int code, String message, T model) {
        this.code = code;
        this.message = message;
        this.model = model;
    }

    public BulkJsonResult(boolean success, int code, String message, T model) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.model = model;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the model
     */
    public T getModel() {
        return model;
    }

    /**
     * @param model
     *            the model to set
     */
    public void setModel(T model) {
        this.model = model;
    }

    /**
     * @param success
     *            the success to set
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
