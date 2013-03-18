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
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

/**
 * 
 * @author wiflish
 * @createTime 2012-6-7 下午3:34:24
 */
@MappedTypes({ Calendar.class, GregorianCalendar.class })
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
