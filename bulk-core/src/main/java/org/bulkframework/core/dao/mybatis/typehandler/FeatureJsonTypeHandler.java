package org.bulkframework.core.dao.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.bulkframework.common.model.DefaultFeatureJson;
import org.bulkframework.common.model.FeatureJson;

/**
 * 扩展字段类型处理.
 * 
 * @author wiflish
 * @createTime 2012-6-7 下午10:15:49
 */
public class FeatureJsonTypeHandler extends BaseTypeHandler<FeatureJson> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, FeatureJson parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getFeatureJson());
    }

    @Override
    public FeatureJson getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String json = rs.getString(columnName);

        if (StringUtils.isNotBlank(json)) {
            FeatureJson featureJson = new DefaultFeatureJson();

            featureJson.setFeatureJson(json);

            return featureJson;
        }
        return null;
    }

    @Override
    public FeatureJson getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String json = rs.getString(columnIndex);

        if (StringUtils.isNotBlank(json)) {
            FeatureJson featureJson = new DefaultFeatureJson();

            featureJson.setFeatureJson(json);

            return featureJson;
        }
        return null;
    }

    @Override
    public FeatureJson getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String json = cs.getString(columnIndex);

        if (StringUtils.isNotBlank(json)) {
            FeatureJson featureJson = new DefaultFeatureJson();

            featureJson.setFeatureJson(json);

            return featureJson;
        }
        return null;
    }
}
