/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.webapp.fileupload;

import org.bulkframework.webapp.exception.BulkWebRuntimeException;

/**
 * 文件上传异常.
 * 
 * @author wiflish
 * @since Apr 8, 2013
 */
public class FileUploadException extends BulkWebRuntimeException {
    private static final long serialVersionUID = -5184020308292810373L;

    /**
     * @param msg
     */
    public FileUploadException(String msg) {
        super(msg);
    }

    public FileUploadException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
