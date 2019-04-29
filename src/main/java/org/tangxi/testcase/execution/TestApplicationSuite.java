package org.tangxi.testcase.execution;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tangxi.testcase.execution.execution.TestExecution;
import org.tangxi.testcase.execution.mapper.TCaseMapper;
import org.tangxi.testcase.execution.model.TestCase;
import org.tangxi.testcase.execution.util.JacksonUtil;
import org.tangxi.testcase.execution.util.SqlSessionFactoryUtil;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestApplicationSuite {
    private final static Logger LOG = LoggerFactory.getLogger(TestApplicationSuite.class);
    private String suite;

    @Parameters({"suite"})
    @BeforeClass
    public void beforeClass(String suite){
        LOG.info("suite为{}",suite);
        this.suite = suite;
    }

    @DataProvider(name = "testCase")
    private Iterator<Object[]> getTestCase(){
        SqlSession sqlSession = SqlSessionFactoryUtil.initSqlSessionFactory().openSession();

        try {
            TCaseMapper testCaseMapper = sqlSession.getMapper(TCaseMapper.class);
            List<TestCase> testCases= testCaseMapper.getTestCasesBySuite(suite);
            LOG.info("hahahahahahah");
            LOG.info("testcases为:{}", JacksonUtil.toJson(testCases));
            List<Object[]> results = new ArrayList<>();
            for(int i=0; i<testCases.size(); i++){
                LOG.info("单个testCase为：{}",JacksonUtil.toJson(testCases.get(i)));
                results.add(new Object[]{testCases.get(i)});

            }
            LOG.info("results为：{}",JacksonUtil.toJson(results));
            return results.iterator();
        }catch (Exception e){
            LOG.error(e.getMessage(),e);
            throw e;
        }
    }


    @Test(dataProvider = "testCase")
    public void testBySuite(TestCase testCase){
        LOG.info("执行的测试用例为：{}",testCase);
        int id = testCase.getId();
        new TestExecution(id).execTestCase();
    }
}
