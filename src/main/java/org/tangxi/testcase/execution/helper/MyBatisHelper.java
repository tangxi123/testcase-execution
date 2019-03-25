package org.tangxi.testcase.execution.helper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisHelper {
    private final static Logger LOG = LoggerFactory.getLogger(MyBatisHelper.class);
    public static SqlSessionFactory buildSqlSessionFactory() throws IOException{
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            LOG.debug("创建sqlSessionFactory成功");
            return sqlSessionFactory;
        } catch (IOException e) {
            LOG.error(e.getMessage(),e);
            throw e;
        }

    }
}
