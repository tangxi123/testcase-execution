package org.tangxi.testcase.execution.mapper;

import org.apache.ibatis.session.SqlSession;
import org.tangxi.testcase.execution.model.parameter.ParameterWrapper;
import org.tangxi.testcase.execution.util.SqlSessionFactoryUtil;
import org.testng.annotations.Test;

public class PMapperTest {
    @Test
    public void selectParameterWrapperByNameTest(){
        SqlSession sqlSession = SqlSessionFactoryUtil.initSqlSessionFactory().openSession();
        try{
            PMapper mapper = sqlSession.getMapper(PMapper.class);
            ParameterWrapper parameterWrapper = mapper.selectParameterWrapperByName("testCaseId");
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