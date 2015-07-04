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

import javax.servlet.http.HttpServletRequest;

/**
 * @author wiflish.
 * @since 1.0.0
 */
public interface PagerFactory {
    <T> Pager<T> createPager(HttpServletRequest request);

    <T> Pager<T> createPager(String pageNoStr, String pageSizeStr);

    <T> PagerResult<T> createPageResult(Pager<T> pager);
}