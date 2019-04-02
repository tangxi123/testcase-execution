package org.tangxi.testcase.execution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tangxi.testcase.execution.execution.TestExecution;
import org.testng.annotations.Test;

/**
 * 测试程序执行入口
 */
public class TestApplication {
    private final static Logger LOG = LoggerFactory.getLogger(TestApplication.class);

    @Test
    public void test(Long id){
        LOG.debug("开始调用测试程序");
//        TestExecution.execTestCaseById(id);
    }
}
