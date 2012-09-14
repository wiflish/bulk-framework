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

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.bulkframework.common.model.FeatureBit;

/**
 * {@link FeatureBit}类的Mybatis类型转换处理类.
 * 
 * @author wiflish
 * @since 2012-9-14
 * @see org.bulkframework.common.model.FeatureBit
 */
@MappedTypes({ FeatureBit.class })
@MappedJdbcTypes({ JdbcType.BIGINT })
public class FeatureBitTypeHandler extends BaseTypeHandler<FeatureBit> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, FeatureBit parameter, JdbcType jdbcType) throws SQLException {
        ps.setLong(i, parameter.getValue());
    }

    @Override
    public FeatureBit getNullableResult(ResultSet rs, String columnName) throws SQLException {
        long featureBit = rs.getLong(columnName);

        return new FeatureBit(featureBit);
    }

    @Override
    public FeatureBit getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        long featureBit = rs.getLong(columnIndex);

        return new FeatureBit(featureBit);
    }

    @Override
    public FeatureBit getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        long featureBit = cs.getLong(columnIndex);

        return new FeatureBit(featureBit);
    }
}
