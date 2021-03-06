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

/**
 * 测试程序执行入口
 */
public class TestApplication {
    private final static Logger LOG = LoggerFactory.getLogger(TestApplication.class);


    @Test
    @Parameters({"id"})
    public void test(String idStr){
        LOG.debug("开始调用测试程序");
        int id = Integer.parseInt(idStr);
        new TestExecution(id).execTestCase();
    }



//    @Test public void testByid(){
//        new TestExecution(140).execTestCase();
//    }




}
