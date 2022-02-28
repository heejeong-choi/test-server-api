package com.example.testserverapi.common.handler;

import com.example.testserverapi.common.codes.PrivateGroundType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(PrivateGroundType.class)
public class PgTypeHandler implements TypeHandler<PrivateGroundType> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, PrivateGroundType privateGroundType, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public PrivateGroundType getResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public PrivateGroundType getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public PrivateGroundType getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
