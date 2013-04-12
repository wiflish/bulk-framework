/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.webapp.fileupload;

/**
 * 文件上传处理接口.
 * 
 * 访问已上传的文件时，可以使用应用服务器的虚拟目录功能.
 * 
 * @author wiflish
 * @since Apr 8, 2013
 */
public interface FileUploadContext<T> {
    /**
     * 注入文件上传的根路径.
     * 
     * @param basePath
     */
    void setBasePath(String basePath);

    /**
     * 注入命名策略.
     * 
     * @param fileUploadNameStrategy
     */
    void setFileUploadNameStrategy(FileUploadNameStrategy<T> fileUploadNameStrategy);

    /**
     * 文件上传.（使用初始化注入的文件命名策略）
     * 
     * @param fileUploadOption {@link FileUploadOption}
     * @return 返回上传处理后的文件名(包含文件相对路径).
     */
    String upload(T fileUploadOption) throws FileUploadException;

    /**
     * 上传文件，上传后的文件名根据指定的文件命名策略。
     * 
     * @param fileUploadOption {@link FileUploadOption}
     * @param strategy 命名策略
     * @return
     */
    String upload(T fileUploadOption, FileUploadNameStrategy<T> strategy) throws FileUploadException;

    /**
     * 删除已上传的文件.
     * 
     * @param fileUploadOption
     */
    void delete(T fileUploadOption);
}
