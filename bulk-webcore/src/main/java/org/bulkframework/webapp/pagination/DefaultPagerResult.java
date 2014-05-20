/*
 * Copyright 2012-2014 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.bulkframework.webapp.pagination;

import java.util.List;

/**
 * @author wiflish.
 * @since 1.0.0
 */
public class DefaultPagerResult<T> implements PagerResult {
    private int totalCount;
    private int pageNo;
    private int pageSize;
    private boolean hasPrePage;
    private List<T> pageData;

    public int getTotalPages() {
        if (totalCount <= 0) {
            return 0;
        }
        return (totalCount - 1) / pageSize + 1;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isHasNextPage() {
        if (totalCount <= 0) {
            return false;
        }

        int totalPages = getTotalPages();

        return (totalPages > pageNo);
    }

    public boolean isHasPrePage() {
        if (totalCount <= 0) {
            return false;
        }

        return pageNo > 1;
    }


    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }
}
