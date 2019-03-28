package org.tangxi.testcase.execution.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tangxi.testcase.execution.execution.ParameterExecution;
import org.tangxi.testcase.execution.mapper.ParameterMapper;
import org.tangxi.testcase.execution.model.parameter.ParameterSql;
import org.tangxi.testcase.execution.model.parameter.ParameterType;
import org.tangxi.testcase.execution.model.parameter.ParameterWrapper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 替换操作符工具类
 */
public class ReplaceHolderUtil {
    private final static Logger LOG = LoggerFactory.getLogger(ReplaceHolderUtil.class);

    public static String replacePlaceHolder(String source) {
        return replacePlaceHolder(source, "\\$\\{.*?}");
    }

    private static String replacePlaceHolder(String source, String pattern) {
        LOG.debug("需要替换的语句为：{},替换的正则表达式为：{}", source, pattern);
        if (StringUtils.isBlank(source) || pattern == null) {
            return null;
        }
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(source);
        while (matcher.find()) {
            String match = matcher.group();
            String parseFields = replaceMatch(match);
            if (parseFields == null) {
                return source;
            }
            source = source.replace(match, parseFields);
        }
        return source;
    }


    private static String replaceMatch(String match) {
        String regex = match.substring(match.indexOf("{") + 1, match.indexOf("}"));
//        if(match.startsWith("${pre.")){
//            return preFieldsValuesJson.getString(regex);
//        }
        return replaceParameter(regex);
    }

    private static String replaceParameter(String value) {
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
}
