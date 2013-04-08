/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.webapp.exception;


/**
 * web异常.
 * 
 * @author wiflish
 * @since Apr 8, 2013
 */
public abstract class BulkWebRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -7625579240966669523L;

    public BulkWebRuntimeException(String msg) {
        super(msg);
    }

    public BulkWebRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public Throwable getRootCause() {
        Throwable rootCause = null;
        Throwable cause = getCause();
        while (cause != null && cause != rootCause) {
            rootCause = cause;
            cause = cause.getCause();
        }
        return rootCause;
    }
}
