package org.tangxi.testcase.execution.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tangxi.testcase.execution.TestExecution;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 替换操作符工具类
 */
public class ReplaceHolderUtil {
    private final static Logger LOG = LoggerFactory.getLogger(ReplaceHolderUtil.class);
    public static String replacePlaceHolder(String source){
        return replacePlaceHolder(source, "\\$\\{.*?}");
    }

    private static String replacePlaceHolder(String source, String pattern){
        LOG.debug("需要替换的语句为：{},替换的正则表达式为：{}",source,pattern);
        if (StringUtils.isBlank(source) || pattern == null) {
            return null;
        }
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(source);
        while (matcher.find()) {
//            String match = matcher.group();
//            String parseFields = parseField(match);
//            if(parseFields == null){
//                return source;
//            }
//            source = source.replace(match,parseFields);
        }
        return source;
    }


//    private static String parseField(String str){
//        String regex = str.substring(str.indexOf("{")+1,str.indexOf("}"));
//        if(str.startsWith("${pre.")){
//            return preFieldsValuesJson.getString(regex);
//        }
//        return replaceValue(regex);
//    }
//
//    private static String replaceValue(String value){
//        SqlSessionFactory sqlSessionFactory = createDataSourceConnection();
//        SqlSession session = sqlSessionFactory.openSession();
//        try{
//            ParamMapper paramMapper = session.getMapper(ParamMapper.class);
//            ParameterWrapper parameterWrapper = paramMapper.selectParameterWrapperByName(value);
//            String paramSqlStr = JacksonUtil.toJson(parameterWrapper.getValue());
//            SqlParameter sqlParameter = JacksonUtil.fromJson(paramSqlStr,SqlParameter.class);
//            //连接数据库源执行sql语句，返回查询到得实际参数值
//            String actualValue = getSqlParameterValue(sqlParameter);
//            return actualValue;
//
//        }finally {
//            session.close();
//        }
//    }
}
