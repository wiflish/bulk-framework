/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.webapp.fileupload;

import java.util.Calendar;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 基于上传时间的命名策略-采用spring mvc上传组件.
 * 
 * @author wiflish
 * @since Apr 8, 2013
 */
public class SpringMvcDayFileUploadNameStrategy implements FileUploadNameStrategy<FileUploadOption> {

    @Override
    public String getTransFileName(FileUploadOption fileUploadOption) {
        Validate.notNull(fileUploadOption, "参数不能为NULL");

        String originalFileName = fileUploadOption.getMultipartFile().getOriginalFilename();
        String originalExt = originalFileName.substring(originalFileName.lastIndexOf("."), originalFileName.length());

        return (System.nanoTime() + originalExt);
    }

    @Override
    public String getTransFileRelativePath(FileUploadOption fileUploadOption) {
        Validate.notNull(fileUploadOption, "参数不能为NULL");

        return DateFormatUtils.format(Calendar.getInstance(), "yyyyMMdd");
    }
}
