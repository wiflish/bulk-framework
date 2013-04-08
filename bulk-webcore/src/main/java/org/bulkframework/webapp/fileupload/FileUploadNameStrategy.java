/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.webapp.fileupload;

/**
 * 上传文件的命名策略. 实际物理地址=<br>
 * {@link FileUploadContext#setBasePath(String)}+ <br>
 * {@link FileUploadNameStrategy#getTransFileRelativePath()} +<br>
 * {@link FileUploadNameStrategy#getTransFileName()}
 * 
 * @author wiflish
 * @since Apr 8, 2013
 */
public interface FileUploadNameStrategy<T> {
    /**
     * 获得转换后的文件名.
     * 
     * @param multiPartFile
     * @return
     */
    String getTransFileName(T multiPartFile);

    /**
     * 获得文件相对路径（即上传根路径到文件名之间的路径）
     * 
     * @param multiPartFile
     * @return
     */
    String getTransFileRelativePath(T multiPartFile);
}
