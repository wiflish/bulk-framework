/**
 * Copyright 2011-2012 [wiflish.xie@gmail.com].
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.bulkframework.core.dao.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.bulkframework.common.model.FeatureJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

/**
 * 扩展字段类型处理.
 * 
 * @author wiflish
 */
@MappedTypes({ FeatureJson.class })
@MappedJdbcTypes({ JdbcType.VARCHAR })
public class FeatureJsonTypeHandler<T extends FeatureJson> extends BaseTypeHandler<T> {
    private static final Logger logger = LoggerFactory.getLogger(FeatureJsonTypeHandler.class);

    private Class<T> type;

    public FeatureJsonTypeHandler(Class<T> type) {
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.toJSONString());
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String json = rs.getString(columnName);

        return parseStringToBaseFeatureJson(json);
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String json = rs.getString(columnIndex);

        return parseStringToBaseFeatureJson(json);
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String json = cs.getString(columnIndex);

        return parseStringToBaseFeatureJson(json);
    }

    /**
     * 将String类型转换为BaseFeatureJson对象.
     * 
     * @param json
     * @return
     */
    private T parseStringToBaseFeatureJson(String json) {
        if (StringUtils.isNotBlank(json)) {
            try {
                T model = JSON.parseObject(json, type);
                return model;
            } catch (JSONException ex) {
                logger.warn("字符串转换为[{}]失败，参数：[{}]", type, json);
                return null;
            }
        }
        return null;
    }
}
