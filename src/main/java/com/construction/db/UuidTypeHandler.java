package com.construction.db;


import com.construction.util.UuidUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.nio.ByteBuffer;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


public class UuidTypeHandler extends BaseTypeHandler<UUID> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, UUID uuid, JdbcType jdbcType) throws SQLException {
        preparedStatement.setObject(i, uuid);
    }

    @Override
    public UUID getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Object o = resultSet.getObject(s);
        if(o == null) {
            return null;
        }
        return (UUID) o;
    }

    @Override
    public UUID getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Object o = resultSet.getObject(i);
        if(o == null) {
            return null;
        }
        return (UUID) o;
    }

    @Override
    public UUID getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Object o = callableStatement.getObject(i);
        if(o == null) {
            return null;
        }
        return (UUID) o;
    }
}
