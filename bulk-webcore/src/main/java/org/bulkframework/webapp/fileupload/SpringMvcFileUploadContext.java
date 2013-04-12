/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.webapp.fileupload;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.bulkframework.common.Constants;

/**
 * 基于SpringMvc的上传处理.
 * 
 * @author wiflish
 * @since Apr 8, 2013
 */
public class SpringMvcFileUploadContext implements FileUploadContext<FileUploadOption> {
    private String basePath;
    private FileUploadNameStrategy<FileUploadOption> fileUploadNameStrategy;

    @Override
    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    @Override
    public void setFileUploadNameStrategy(FileUploadNameStrategy<FileUploadOption> fileUploadNameStrategy)
            throws FileUploadException {
        this.fileUploadNameStrategy = fileUploadNameStrategy;
    }

    @Override
    public String upload(FileUploadOption fileUploadOption) throws FileUploadException {
        Validate.notNull(fileUploadOption, "参数不能为NULL");

        return processUpload(fileUploadOption, fileUploadNameStrategy);
    }

    @Override
    public String upload(FileUploadOption fileUploadOption, FileUploadNameStrategy<FileUploadOption> strategy)
            throws FileUploadException {
        Validate.notNull(fileUploadOption, "参数不能为NULL");

        return processUpload(fileUploadOption, strategy);
    }

    /**
     * @param fileUploadOption
     * @return
     */
    private String processUpload(FileUploadOption fileUploadOption, FileUploadNameStrategy<FileUploadOption> strategy) {
        String fileName = strategy.getTransFileName(fileUploadOption);
        String fileRelativePath = strategy.getTransFileRelativePath(fileUploadOption);

        // 如果是相对路径，则根据request计算实际的物理路径.
        setRootPath(fileUploadOption);

        String targetDir = basePath + Constants.FILE_SEPARATE + fileRelativePath;
        File targetPath = new File(targetDir);
        if (!targetPath.exists()) {
            targetPath.mkdirs();
        }

        try {
            fileUploadOption.getMultipartFile().transferTo(new File(targetDir + Constants.FILE_SEPARATE + fileName));
        } catch (IllegalStateException e) {
            throw new FileUploadException("文件已经被移走，不存在了!", e);
        } catch (IOException e) {
            throw new FileUploadException("文件读写发生错误！", e);
        }

        return (fileRelativePath + Constants.FILE_SEPARATE + fileName);
    }

    /**
     * @param fileUploadOption
     */
    private void setRootPath(FileUploadOption fileUploadOption) {
        // 处理相对路径.
        if (!basePath.startsWith("/") && !(basePath.indexOf(":") != -1)) {
            HttpServletRequest request = fileUploadOption.getRequest();
            if (request != null) {
                basePath = request.getServletContext().getRealPath("/") + basePath;
            }
        }
    }

    @Override
    public void delete(FileUploadOption fileUploadOption) {
        Validate.notNull(fileUploadOption, "参数不能为NULL");
        
        if(StringUtils.isBlank(fileUploadOption.getDbFileName())) {
            return;
        }

        setRootPath(fileUploadOption);
        String dbFileName = fileUploadOption.getDbFileName();

        File file = new File(basePath + Constants.FILE_SEPARATE + dbFileName);
        if (file.isFile()) {
            file.delete();
        }
    }
}
