package org.tangxi.testcase.execution.execution;

import com.jayway.restassured.path.json.JsonPath;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tangxi.testcase.execution.mapper.TestCaseMapper;
import org.tangxi.testcase.execution.model.TestCase;
import org.tangxi.testcase.execution.model.checkPoint.CheckPoint;
import org.tangxi.testcase.execution.util.ReplaceHolderUtil;
import org.tangxi.testcase.execution.util.SqlSessionFactoryUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestExecution {
    private final static Logger LOG = LoggerFactory.getLogger(TestExecution.class);

    private static Map<String, Object> preActionResult = new HashMap<>();
    private TestCase testCase;
    private String parameters;
    private List<String> preActions;
    private JsonPath requestResults;
    private List<CheckPoint> checkPoints;
    private List<String> postActions;

    public void execTestCase() {
        PrePostActionExecution.execActions(preActions, preActionResult);
        requestResults = RequestExecution.sendRequest(testCase, preActionResult);
        VerifyExecution.execVerifyResult(requestResults, checkPoints);
        LOG.debug("preActionResult的值为：{}", preActionResult);
    }

    public TestExecution(int id) {
        initTestData(id);
    }

    private void initTestData(int id) {
        SqlSession sqlSession = SqlSessionFactoryUtil.initSqlSessionFactory().openSession();
        try {
            TestCaseMapper testCaseMapper = sqlSession.getMapper(TestCaseMapper.class);
            testCase = testCaseMapper.selectTestCaseById(id);
            parameters = testCase.getParameters();
            preActions = testCase.getPreActions();
            checkPoints = testCase.getCheckPoints();
            postActions = testCase.getPostActions();
            LOG.debug("testCase:{}" + "\\r"
                            + "parameters:{}" + "\\r"
                            + "preActions:{}" + "\\r"
                            + "checkPoints:{}" + "\\r"
                            + "postActions:{}",
                    testCase, parameters, preActions, postActions);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }


    public static void main(String[] args) {
        new TestExecution(139).execTestCase();

    }
}
