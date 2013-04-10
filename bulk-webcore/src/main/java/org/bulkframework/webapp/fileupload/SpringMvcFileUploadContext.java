/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.webapp.fileupload;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.Validate;
import org.springframework.web.multipart.MultipartFile;

/**
 * 基于SpringMvc的上传处理.
 * 
 * @author wiflish
 * @since Apr 8, 2013
 */
public class SpringMvcFileUploadContext implements FileUploadContext<MultipartFile> {
    private String basePath;
    private FileUploadNameStrategy<MultipartFile> fileUploadNameStrategy;

    @Override
    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    @Override
    public void setFileUploadNameStrategy(FileUploadNameStrategy<MultipartFile> fileUploadNameStrategy)
            throws FileUploadException {
        this.fileUploadNameStrategy = fileUploadNameStrategy;
    }

    @Override
    public String upload(MultipartFile multiPartFile) throws FileUploadException {
        Validate.notNull(multiPartFile, "参数不能为NULL");

        return processUpload(multiPartFile, fileUploadNameStrategy);
    }

    @Override
    public String upload(MultipartFile multiPartFile, FileUploadNameStrategy<MultipartFile> strategy)
            throws FileUploadException {
        Validate.notNull(multiPartFile, "参数不能为NULL");

        return processUpload(multiPartFile, strategy);
    }

    /**
     * @param multiPartFile
     * @return
     */
    private String processUpload(MultipartFile multiPartFile, FileUploadNameStrategy<MultipartFile> strategy) {
        String fileName = strategy.getTransFileName(multiPartFile);
        String fileRelativePath = strategy.getTransFileRelativePath(multiPartFile);

        String targetDir = basePath + "/" + fileRelativePath;
        File targetPath = new File(targetDir);
        if (!targetPath.exists()) {
            targetPath.mkdirs();
        }

        try {
            multiPartFile.transferTo(new File(targetDir + fileName));
        } catch (IllegalStateException e) {
            throw new FileUploadException("文件已经被移走，不存在了!", e);
        } catch (IOException e) {
            throw new FileUploadException("文件读写发生错误！", e);
        }

        return (fileRelativePath + fileName);
    }
}
