package org.bulkframework.core.dao.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * 
 * @author wiflish
 * @createTime 2012-6-7 下午3:34:24
 */
public class CalendarTypeHandler extends BaseTypeHandler<Calendar> {

    @Override
    public Calendar getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Timestamp ts = rs.getTimestamp(columnName);
        if (ts != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(ts.getTime());
            return cal;
        }
        return null;
    }

    @Override
    public Calendar getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Timestamp ts = rs.getTimestamp(columnIndex);
        if (ts != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(ts.getTime());
            return cal;
        }
        return null;
    }

    @Override
    public Calendar getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Timestamp ts = cs.getTimestamp(columnIndex);
        if (ts != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(ts.getTime());
            return cal;
        }
        return null;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Calendar parameter, JdbcType jdbcType) throws SQLException {
        ps.setTimestamp(i, new Timestamp(parameter.getTimeInMillis()));
    }
}
