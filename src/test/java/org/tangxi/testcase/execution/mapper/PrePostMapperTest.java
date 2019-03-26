package org.tangxi.testcase.execution.mapper;

import org.apache.ibatis.session.SqlSession;
import org.tangxi.testcase.execution.model.prePostAction.PrePostActionType;
import org.tangxi.testcase.execution.model.prePostAction.PrePostActionWrapper;
import org.tangxi.testcase.execution.util.SqlSessionFactoryUtil;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PrePostMapperTest {
    @Test
    public void selectPrePostActionWrapperByName() {
        String action = "插入一条数据测试";
        SqlSession sqlSession = SqlSessionFactoryUtil.initSqlSessionFactory().openSession();
        try{
            PrePostMapper mapper = sqlSession.getMapper(PrePostMapper.class);
            PrePostActionWrapper prePostActionWrapper = mapper.selectPrePostActionWrapperByName(action);
            Assert.assertEquals(prePostActionWrapper.getId(),3);
            Assert.assertEquals(prePostActionWrapper.getName(),"插入一条数据测试");
            Assert.assertEquals(prePostActionWrapper.getDescs(),"在执行查询前需要插入一条数据");
            Assert.assertEquals(prePostActionWrapper.getActionType(), PrePostActionType.SQL);
            Assert.assertNotNull(prePostActionWrapper.getAction());
        }finally {
            sqlSession.close();
        }
    }
}
