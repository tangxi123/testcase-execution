package org.tangxi.testcase.execution;

import com.jayway.restassured.path.json.JsonPath;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tangxi.testcase.execution.mapper.TestCaseMapper;
import org.tangxi.testcase.execution.model.TestCase;
import org.tangxi.testcase.execution.util.SqlSessionFactoryUtil;

import java.util.List;

public class TestExecution {
    private final static Logger LOG = LoggerFactory.getLogger(TestExecution.class);

    private static TestCase testCase;
    private static String parameters;
    private static List<String> preActions;
    private static JsonPath requestResults;
    private static List<String> postActions;

    public static void execTestCaseById(Long id) {
        initTestData(id);
        PrePostActionExecution.execActions(preActions);
    }

    private static void initTestData(Long id) {
        SqlSession sqlSession = SqlSessionFactoryUtil.initSqlSessionFactory().openSession();
        try {
            TestCaseMapper testCaseMapper = sqlSession.getMapper(TestCaseMapper.class);
            testCase = testCaseMapper.selectTestCaseById(id);
            parameters = testCase.getParameters();
            preActions = testCase.getPreActions();
            postActions = testCase.getPostActions();
            LOG.debug("testCase:{}" + "\\r"
                            + "parameters:{}" + "\\r"
                            + "preActions:{}" + "\\r"
                            + "postActions:{}",
                    testCase, parameters,preActions, postActions);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }


    public static void main(String[] args) {
        execTestCaseById(139L);

    }
}
