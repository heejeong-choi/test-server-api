package com.example.testserverapi.common.handler;

import com.example.testserverapi.common.codes.LocationTheme;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(LocationTheme.class)
public class ThemeTypeHandler implements TypeHandler<LocationTheme> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, LocationTheme locationTheme, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public LocationTheme getResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public LocationTheme getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public LocationTheme getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
