package org.tangxi.testcase.execution.execution;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tangxi.testcase.execution.mapper.PMapper;
import org.tangxi.testcase.execution.model.parameter.ParameterSql;
import org.tangxi.testcase.execution.model.parameter.ParameterType;
import org.tangxi.testcase.execution.model.parameter.ParameterWrapper;
import org.tangxi.testcase.execution.util.JDBCUtil;
import org.tangxi.testcase.execution.util.JacksonUtil;
import org.tangxi.testcase.execution.util.SqlSessionFactoryUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ParameterExecution {
    private static final Logger LOG = LoggerFactory.getLogger(ParameterExecution.class);

    public static String replaceParameter(String value) {
        SqlSession session = SqlSessionFactoryUtil.initSqlSessionFactory().openSession();
        try {
            PMapper paramMapper = session.getMapper(PMapper.class);
            ParameterWrapper parameterWrapper = paramMapper.selectParameterWrapperByName(value);
            ParameterType paramType = parameterWrapper.getType();
            String actualValue = null;
            switch (paramType) {
                case SQL:
                    String paramSqlStr = JacksonUtil.toJson(parameterWrapper.getParameter());
                    ParameterSql parameterSql = JacksonUtil.fromJson(paramSqlStr, ParameterSql.class);
                    //连接数据库源执行sql语句，返回查询到得实际参数值
                    actualValue = ParameterExecution.getSqlParameterValue(parameterSql);
                    break;
            }
            return actualValue;

        } finally {
            session.close();
        }
    }

    private static String getSqlParameterValue(ParameterSql parameterSql){
        Connection con = JDBCUtil.getConnection(parameterSql);
        try{
            Statement stmt = con.createStatement();
            String sql = parameterSql.getSql();
            LOG.debug("需要执行的sql语句为：{}",sql);
            boolean isSelectedResult = stmt.execute(sql);
            if(isSelectedResult){
                ResultSet resultSet = stmt.getResultSet();
                resultSet.first();
                String result = resultSet.getString(parameterSql.getParam());
                LOG.debug("需要获取的字段为{}，字段值为{}",parameterSql.getParam(),result);
                return result;
            }
        }catch (SQLException e){
            LOG.error(e.getMessage(),e);
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
