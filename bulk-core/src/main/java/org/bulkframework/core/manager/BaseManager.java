/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.core.manager;

import org.bulkframework.core.dao.BulkDao;

/**
 * 
 * @author wiflish
 * @since Mar 14, 2013
 */
public interface BaseManager<T> {
    BulkDao<T> getDao();

    String getMapper();

    long insert(T model);

    int update(T model);

    T queryById(long id);
}
