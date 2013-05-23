/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.common.pagination;

/**
 * 
 * @author wiflish
 * @since May 18, 2013
 */
public class PagerUtil {
    /**
     * 根据页号和页大小创建Pager对象.
     * 
     * @param pageNo 当前页,从1开始.
     * @param pageSize
     * @return
     */
    public static <T> Pager<T> createPager(int pageNo, int pageSize) {
        Pager<T> dataPage = new Pager<T>(pageNo, pageSize);

        return dataPage;
    }

    public static <T> Pager<T> createPager(int pageNo, int pageSize, boolean needTotalCount) {
        Pager<T> dataPage = new Pager<T>(pageNo, pageSize, needTotalCount);

        return dataPage;
    }
}
