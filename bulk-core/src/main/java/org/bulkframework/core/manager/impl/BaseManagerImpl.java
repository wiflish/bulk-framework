/*
 * Copyright 2012-2013 <strong>www.fyard.com</strong> Inc. All rights reserved.
 */
package org.bulkframework.core.manager.impl;

import org.bulkframework.common.model.BaseModel;
import org.bulkframework.core.manager.BaseManager;
import org.springframework.util.Assert;

/**
 * 
 * @author wiflish
 * @since Mar 14, 2013
 */
public abstract class BaseManagerImpl<T extends BaseModel> implements BaseManager<T> {
    @Override
    public long insert(T model) {
        Assert.notNull(model, "参数不能为NULL.");

        Long id = model.getId();
        if (id != null && id > 0) {
            model.setId(null);
        }

        getDao().insertAndReturnId(getMapper() + ".insertSelective", model);
        return model.getId();
    }

    @Override
    public int update(T model) {
        Assert.notNull(model, "参数不能为NULL.");

        return getDao().update(getMapper() + ".updateByPrimaryKeySelective", model);
    }

    @Override
    public T queryById(long id) {
        if (id <= 0) {
            return null;
        }

        return getDao().queryOne(getMapper() + ".selectByPrimaryKey", id);
    }

}
