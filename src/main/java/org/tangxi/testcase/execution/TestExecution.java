package org.tangxi.testcase.execution;

import com.jayway.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tangxi.testcase.execution.model.TestCase;

import java.util.List;

public class TestExecution {
    private final static Logger LOG = LoggerFactory.getLogger(TestExecution.class);
    private TestCase testCase;
    private List<String> preActions;
    private JsonPath requestResults;
    private List<String> postActions;
    public static void execTestCaseById(Long id){
        //执行测试用例
    }



    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");

    }
}
