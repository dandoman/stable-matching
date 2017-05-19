package com.construction.db;


import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.time.DateTime;

import java.sql.*;

public class DateTimeTypeHandler extends BaseTypeHandler<DateTime> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, DateTime dateTime, JdbcType jdbcType) throws SQLException {
        preparedStatement.setTimestamp(i, new Timestamp(dateTime.toDate().getTime()));
    }

    @Override
    public DateTime getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Timestamp timestamp = resultSet.getTimestamp(s);
        if(timestamp == null) {
            return null;
        }
        return new DateTime(new Date(timestamp.getTime()));
    }

    @Override
    public DateTime getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Timestamp timestamp = resultSet.getTimestamp(i);
        if(timestamp == null) {
            return null;
        }
        return new DateTime(new Date(timestamp.getTime()));
    }

    @Override
    public DateTime getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Timestamp timestamp = callableStatement.getTimestamp(i);
        if(timestamp == null) {
            return null;
        }
        return new DateTime(new Date(timestamp.getTime()));
    }
}
