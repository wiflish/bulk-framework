/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.webapp.fileupload;

/**
 * 文件上传处理接口.
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
     * @param uploadFileNameStrategy
     */
    void setUploadFileNameStrategy(FileUploadNameStrategy<T> uploadFileNameStrategy);

    /**
     * 文件上传.（使用初始化注入的文件命名策略）
     * 
     * @param multiPartFile web上传的文件对象，比如spring-mvc的<a href=
     *            "http://static.springsource.org/spring/docs/3.1.x/javadoc-api/index.html?org/springframework/web/multipart/MultipartFile.html"
     *            >org.springframework.web.multipart.MultipartFile</a>接口
     * @return 返回上传处理后的文件名(包含文件相对路径).
     */
    String upload(T multiPartFile) throws FileUploadException;

    /**
     * 上传文件，上传后的文件名根据指定的文件命名策略。
     * 
     * @param multiPartFile web上传的文件对象，比如spring-mvc的<a href=
     *            "http://static.springsource.org/spring/docs/3.1.x/javadoc-api/index.html?org/springframework/web/multipart/MultipartFile.html"
     *            >org.springframework.web.multipart.MultipartFile</a>接口
     * @param strategy 命名策略
     * @return
     */
    String upload(T multiPartFile, FileUploadNameStrategy<T> strategy) throws FileUploadException;
}
