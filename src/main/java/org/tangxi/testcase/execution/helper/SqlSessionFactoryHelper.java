package org.tangxi.testcase.execution.helper;

import com.mysql.jdbc.log.NullLogger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryHelper {
    private final static Logger LOG = LoggerFactory.getLogger(SqlSessionFactoryHelper.class);
    private static SqlSessionFactory sqlSessionFactory;
    private SqlSessionFactoryHelper(){}
    public static synchronized SqlSessionFactory getSqlSessionFactory() throws IOException{
        if(sqlSessionFactory == null) {
            String resource = "mybatis-config.xml";
            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                LOG.debug("创建sqlSessionFactory成功");
                return sqlSessionFactory;
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
                throw e;
            }
        }
        return sqlSessionFactory;
    }
}
