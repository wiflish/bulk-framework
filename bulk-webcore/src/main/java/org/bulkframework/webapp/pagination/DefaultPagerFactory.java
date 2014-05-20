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

import org.bulkframework.common.pagination.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wiflish.
 * @since 1.0.0
 */
public class DefaultPagerFactory implements PagerFactory {
    private static final Logger logger = LoggerFactory.getLogger(EasyUiPagerFactory.class);
    private static final String defaultPageNoKey = "pageNo";
    private static final String defaultPageSizeKey = "pageSize";

    @Override
    public <T> Pager<T> createPager(HttpServletRequest request) {
        String pageNoStr = request.getParameter(defaultPageNoKey);
        String pageSizeStr = request.getParameter(defaultPageSizeKey);

        return createPager(pageNoStr, pageSizeStr);
    }

    @Override
    public <T> Pager<T> createPager(String pageNoStr, String pageSizeStr) {
        try {
            int pageNo = new Integer(pageNoStr.trim());
            int pageSize = new Integer(pageSizeStr.trim());

            Pager<T> pager = new Pager(pageNo, pageSize);

            return pager;
        } catch (Exception e) {
            logger.error("创建pager对象失败，返回默认Pager对象. 参数pageNo：{}, pageSize:{}", new Object[]{pageNoStr, pageSizeStr}, e);

            return new Pager();
        }
    }

    @Override
    public <T> PagerResult<T> createPageResult(Pager<T> pager) {
        DefaultPagerResult<T> result = new DefaultPagerResult<T>();

        result.setPageData(pager.getPageData());
        result.setPageNo(pager.getPageNo());
        result.setPageSize(pager.getPageSize());
        result.setTotalCount(pager.getTotalCount());

        return result;
    }
}
