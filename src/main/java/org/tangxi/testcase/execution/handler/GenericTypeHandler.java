package org.tangxi.testcase.execution.handler;

import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.tangxi.testcase.execution.util.JacksonUtil;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenericTypeHandler<T> extends BaseTypeHandler<T> {

    private Class<T> type;

    public GenericTypeHandler(Class<T> type){
        if(type == null) throw  new IllegalArgumentException("Type参数不能为空");
        this.type = type;
    }

    public void setNonNullParameter(PreparedStatement preparedStatement, int i, T parameter, JdbcType jdbcType) throws SQLException {
        if(parameter == null){
            return;
        }
        String json = JacksonUtil.toJson(parameter);
        preparedStatement.setString(i,json);
    }

    public T getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String columnValue = resultSet.getString(s);
        return getColumnValueResult(columnValue);
    }

    public T getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String columnValue = resultSet.getString(i);
        return getColumnValueResult(columnValue);
    }

    public T getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String columnValue = callableStatement.getString(i);
        return getColumnValueResult(columnValue);
    }

    private T getColumnValueResult(String columnValue){
        if(columnValue != null){
            return JacksonUtil.fromJson(columnValue, new TypeReference<T>() {
            });
        }
        return null;
    }
}
