package org.tangxi.testcase.execution.mapper;

import org.apache.ibatis.session.SqlSession;
import org.tangxi.testcase.execution.util.JacksonUtil;
import org.tangxi.testcase.execution.util.SqlSessionFactoryUtil;
import org.tangxi.testcase.execution.model.TestCase;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.IOException;
import java.util.ArrayList;


public class TestCaseMapperTest {
    @Test
    public void selectTestCaseById() throws IOException{
        SqlSession sqlSession = SqlSessionFactoryUtil.initSqlSessionFactory().openSession();
        Assertion assertion = new Assertion();
        try{
            TestCaseMapper mapper = sqlSession.getMapper(TestCaseMapper.class);
            TestCase testCase= mapper.selectTestCaseById((long)139);
            assertion.assertEquals(testCase.getId().toString(),"139");
            assertion.assertEquals(testCase.getSuite(),"testcase");
            assertion.assertEquals(testCase.getTestModule(),"query");
            assertion.assertEquals(testCase.getGroups().get(0),"功能测试");
            assertion.assertEquals(testCase.getTestName(),"test");
            assertion.assertEquals(testCase.getDescs(),"GET接口请求测试");
            assertion.assertEquals(testCase.getMethod(),"GET");
            assertion.assertEquals(testCase.getBaseUrl(),"http://localhost:8081");
            assertion.assertEquals(testCase.getUrl(),"/testcases/");
            assertion.assertEquals(testCase.getHeaders(),"{\"Content-Type\":\"application/json\"}");
            assertion.assertEquals(testCase.getParameters(),"${testCaseId}");
            assertion.assertEquals(testCase.getPreActions().get(0),"插入一条数据测试");
            assertion.assertEquals(JacksonUtil.toJson(testCase.getCheckPoints()),"[{\"type\":\"StrCheckPoint\",\"strCheckPointType\":\"STREQUAL\",\"checkKey\":\"data.testName\",\"expected\":\"test\"}]");
            assertion.assertEquals(testCase.getPostActions().get(0),"删除一条数据测试");
//            assertion.assertEquals(testCase.getCreatedAt(),"2019-03-06T14:09:10");
//            assertion.assertEquals(testCase.getUpdatedAt(),"2019-03-06T14:09:10");
            assertion.assertEquals(testCase.getActual(),"{\"code\":200}");
//            LocalDateTime time;
//            assertion.assertAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            sqlSession.commit();
        }

    }
}
