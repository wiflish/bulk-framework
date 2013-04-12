/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.webapp.fileupload;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传参数Bean.
 * 
 * @author wiflish
 * @since Apr 11, 2013
 */
public class FileUploadOption implements Serializable {
    private static final long serialVersionUID = -7435756116157664822L;

    private MultipartFile multipartFile;

    private HttpServletRequest request;

    /**
     * 数据库中的文件路径.(包含相对路径和文件名)
     */
    private String dbFileName;

    public FileUploadOption() {
    }

    public FileUploadOption(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public FileUploadOption(MultipartFile multipartFile, HttpServletRequest request) {
        this.multipartFile = multipartFile;
        this.request = request;
    }

    public FileUploadOption(String dbFileName, HttpServletRequest request) {
        this.dbFileName = dbFileName;
        this.request = request;
    }

    /**
     * @return the multipartFile
     */
    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    /**
     * @param multipartFile the multipartFile to set
     */
    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    /**
     * @return the request
     */
    public HttpServletRequest getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * @return the dbFileName
     */
    public String getDbFileName() {
        return dbFileName;
    }

    /**
     * @param dbFileName the dbFileName to set
     */
    public void setDbFileName(String dbFileName) {
        this.dbFileName = dbFileName;
    }
}
