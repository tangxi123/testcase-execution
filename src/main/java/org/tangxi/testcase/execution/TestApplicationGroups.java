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

public class TestApplicationGroups {
    private final static Logger LOG = LoggerFactory.getLogger(TestApplicationGroups.class);
    private String groups;

    @Parameters({"groups"})
    @BeforeClass
    public void beforeClass(String groups){
        LOG.info("groups为{}",groups);
        this.groups = groups;
    }

    @DataProvider(name = "testCase")
    private Iterator<Object[]> getTestCase(){
        SqlSession sqlSession = SqlSessionFactoryUtil.initSqlSessionFactory().openSession();

        try {
            TCaseMapper testCaseMapper = sqlSession.getMapper(TCaseMapper.class);
            List<TestCase> testCases= testCaseMapper.getTestCasesByGroups(groups);
            LOG.info("hahahahahahah");
            LOG.info("testcases为:{}", JacksonUtil.toJson(testCases));
            List<Object[]> results = new ArrayList<>();
//            Object[] objects = new Object[]{};
            for(int i=0; i<testCases.size(); i++){
                LOG.info("单个testCase为：{}",JacksonUtil.toJson(testCases.get(i)));
                results.add(new Object[]{testCases.get(i)});
//                objects[i] = testCases.get(i);
            }
//            results.add(objects);
            LOG.info("results为：{}",JacksonUtil.toJson(results));
            return results.iterator();
        }catch (Exception e){
            LOG.error(e.getMessage(),e);
            throw e;
        }
    }


    @Test(dataProvider = "testCase")
    public void testByGroups(TestCase testCase){
        LOG.info("执行的测试用例为：{}",testCase);
        int id = testCase.getId();
        new TestExecution(id).execTestCase();
    }
}
