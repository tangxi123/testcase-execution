package org.tangxi.testcase.execution.mapper;

import org.apache.ibatis.session.SqlSession;
import org.tangxi.testcase.execution.model.parameter.ParameterWrapper;
import org.tangxi.testcase.execution.util.SqlSessionFactoryUtil;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParameterMapperTest {
    @Test
    public void selectParameterWrapperByNameTest(){
        SqlSession sqlSession = SqlSessionFactoryUtil.initSqlSessionFactory().openSession();
        try{
            ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
            ParameterWrapper parameterWrapper = mapper.selectParameterWrapperByName("${testCaseId}");
            System.out.println(parameterWrapper.getId());
            System.out.println(parameterWrapper.getName());
            System.out.println(parameterWrapper.getDescs());
            System.out.println(parameterWrapper.getType());
            System.out.println(parameterWrapper.getParameter());
        }finally {
            sqlSession.close();
        }
    }

}