package org.tangxi.testcase.execution.execution;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tangxi.testcase.execution.mapper.ParameterMapper;
import org.tangxi.testcase.execution.model.parameter.ParameterSql;
import org.tangxi.testcase.execution.model.parameter.ParameterType;
import org.tangxi.testcase.execution.model.parameter.ParameterWrapper;
import org.tangxi.testcase.execution.util.JacksonUtil;
import org.tangxi.testcase.execution.util.SqlSessionFactoryUtil;

public class ParameterExecution {
    private static final Logger LOG = LoggerFactory.getLogger(ParameterExecution.class);

    public static String replaceParameter(String value) {
        SqlSession session = SqlSessionFactoryUtil.initSqlSessionFactory().openSession();
        try {
            ParameterMapper paramMapper = session.getMapper(ParameterMapper.class);
            ParameterWrapper parameterWrapper = paramMapper.selectParameterWrapperByName(value);
            ParameterType paramType = parameterWrapper.getType();
            String actualValue = null;
            switch (paramType) {
                case SQL:
                    String paramSqlStr = JacksonUtil.toJson(parameterWrapper.getParameter());
                    ParameterSql parameterSql = JacksonUtil.fromJson(paramSqlStr, ParameterSql.class);
                    System.out.println("#####################################" + parameterSql.getSql());
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

    }
}
