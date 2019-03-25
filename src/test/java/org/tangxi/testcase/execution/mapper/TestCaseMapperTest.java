package org.tangxi.testcase.execution.mapper;

import org.apache.ibatis.session.SqlSession;
import org.tangxi.testcase.execution.helper.MyBatisHelper;
import org.tangxi.testcase.execution.model.TestCase;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCaseMapperTest {
    @Test
    public void selectTestCaseById() throws IOException {
        SqlSession sqlSession = MyBatisHelper.buildSqlSessionFactory().openSession();
        try{
            TestCaseMapper mapper = sqlSession.getMapper(TestCaseMapper.class);
            TestCase testCase= mapper.selectTestCaseById((long)139);
            System.out.println(testCase.getUrl());
        }finally {
            sqlSession.commit();
        }

    }
}
