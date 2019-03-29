package org.tangxi.testcase.execution.execution;

import com.jayway.restassured.path.json.JsonPath;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tangxi.testcase.execution.mapper.TestCaseMapper;
import org.tangxi.testcase.execution.model.TestCase;
import org.tangxi.testcase.execution.util.ReplaceHolderUtil;
import org.tangxi.testcase.execution.util.SqlSessionFactoryUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestExecution {
    private final static Logger LOG = LoggerFactory.getLogger(TestExecution.class);

    private static Map<String,Object> preActionResult = new HashMap<>();
    private static TestCase testCase;
    private static String parameters;
    private static List<String> preActions;
    private static JsonPath requestResults;
    private static List<String> postActions;

    public static void execTestCaseById(Long id) {
        initTestData(id);
        PrePostActionExecution.execActions(preActions,preActionResult);
        LOG.debug("preActionResult的值为：{}",preActionResult);
        RequestExecution.sendRequest(testCase,preActionResult);
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
                    testCase, parameters, preActions, postActions);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }


    public static void main(String[] args) {
        execTestCaseById(139L);

    }
}
