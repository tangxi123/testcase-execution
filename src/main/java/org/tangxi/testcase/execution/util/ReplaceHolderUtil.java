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

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 替换操作符工具类
 */
public class ReplaceHolderUtil {
    private final static Logger LOG = LoggerFactory.getLogger(ReplaceHolderUtil.class);

    public static String replacePlaceHolder(String source,Map<String,Object> preActionResult) {
        return replacePlaceHolder(source, "\\$\\{.*?}",preActionResult);
    }

    private static String replacePlaceHolder(String source, String pattern, Map<String,Object> preActionResult) {
        LOG.debug("需要替换的语句为：{},替换的正则表达式为：{}", source, pattern);
        if (StringUtils.isBlank(source) || pattern == null) {
            return null;
        }
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(source);
        while (matcher.find()) {
            String match = matcher.group();
            String parseFields = replaceMatch(match,preActionResult);
            if (parseFields == null) {
                return source;
            }
            source = source.replace(match, parseFields);
        }
        return source;
    }


    private static String replaceMatch(String match,Map<String,Object> preActionResult) {
        String regex = match.substring(match.indexOf("{") + 1, match.indexOf("}"));
        if(match.startsWith("${pre.")){
            return (String)preActionResult.get(regex);
        }
        return ParameterExecution.replaceParameter(regex);
    }


}
