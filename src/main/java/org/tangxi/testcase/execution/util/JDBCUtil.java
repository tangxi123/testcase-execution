package org.tangxi.testcase.execution.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tangxi.testcase.execution.execution.ParameterExecution;
import org.tangxi.testcase.execution.model.parameter.ParameterSql;
import org.tangxi.testcase.execution.model.prePostAction.PrePostActionSql;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
    private static final Logger LOG = LoggerFactory.getLogger(JDBCUtil.class);
    private static Connection con;
    private static String host;
    private static String port;
    private static String database;
    private static String user;
    private static String password;

    private static void initJDBCData(ParameterSql parameterSql) {
        host = parameterSql.getHost();
        port = parameterSql.getPort();
        database = parameterSql.getDatabase();
        user = parameterSql.getUser();
        password = parameterSql.getPassword();
    }

    private static void initJDBCData(PrePostActionSql prePostActionSql){
        host = prePostActionSql.getHost();
        port = prePostActionSql.getPort();
        database = prePostActionSql.getDatabase();
        user = prePostActionSql.getUser();
        password = prePostActionSql.getPassword();
    }

    public static Connection getConnection(ParameterSql parameterSql) {
        initJDBCData(parameterSql);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+database,user,password);
        }catch (Exception e){
            LOG.error(e.getMessage(),e);
        }
        return con;

    }
    public static Connection getConnection(PrePostActionSql prePostActionSql) {
        initJDBCData(prePostActionSql);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+database,user,password);
        }catch (Exception e){
            LOG.error(e.getMessage(),e);
        }
        return con;

    }
}