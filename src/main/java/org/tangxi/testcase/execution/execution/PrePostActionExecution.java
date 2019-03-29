package org.tangxi.testcase.execution.execution;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tangxi.testcase.execution.mapper.PrePostMapper;
import org.tangxi.testcase.execution.model.prePostAction.PrePostAction;
import org.tangxi.testcase.execution.model.prePostAction.PrePostActionSql;
import org.tangxi.testcase.execution.model.prePostAction.PrePostActionType;
import org.tangxi.testcase.execution.model.prePostAction.PrePostActionWrapper;
import org.tangxi.testcase.execution.util.JDBCUtil;
import org.tangxi.testcase.execution.util.JacksonUtil;
import org.tangxi.testcase.execution.util.SqlSessionFactoryUtil;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 执行前后置动作的类
 */
public class PrePostActionExecution {
    private static final Logger LOG = LoggerFactory.getLogger(PrePostActionExecution.class);

    public static void execActions(List<String> actions, Map<String,Object> preActionResult){
        if(actions == null){
            return;
        }
        for(String action : actions){
            execAction(action,preActionResult);
        }
    }

    private static void execAction(String actionName,Map<String,Object> preActionResult){
        if(actionName == null){
            return;
        }
        SqlSession sqlSession = SqlSessionFactoryUtil.initSqlSessionFactory().openSession();
        try {
            PrePostMapper mapper = sqlSession.getMapper(PrePostMapper.class);
            PrePostActionWrapper prePostActionWrapper = mapper.selectPrePostActionWrapperByName(actionName);
            PrePostActionType actionType = prePostActionWrapper.getActionType();
            PrePostAction action = prePostActionWrapper.getAction();
            switch (actionType){
                case SQL:
                    execSqlAction(action,preActionResult);
            }
        }catch (Exception e){
            LOG.error(e.getMessage(),e);
//            throw e;
        }finally {
            sqlSession.close();
        }
    }

    private static void execSqlAction(PrePostAction action,Map<String,Object> preActionResult){
//        preActionResult = new HashMap<>();
        if(action == null){
            return;
        }
        String actionStr = JacksonUtil.toJson(action);
        LOG.debug("执行前置动作的字符串为：{}",actionStr);
        PrePostActionSql prePostActionSql = JacksonUtil.fromJson(actionStr, PrePostActionSql.class);
        Connection connection = JDBCUtil.getConnection(prePostActionSql);
        try{
            Statement stmt = connection.createStatement();
            String sql = prePostActionSql.getSql();
            LOG.debug("执行的sql语句为:{}",sql);
            boolean isSelectedResult = stmt.execute(sql);
            if(isSelectedResult){
                ResultSet resultSet = stmt.getResultSet();
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int columnCounts = resultSetMetaData.getColumnCount();
                LOG.debug("select的字段个数为{}",columnCounts);
                int columnIndex = 1;
                while(resultSet.next()){
                    for(int i=1; i<=columnCounts; i++){
                        preActionResult.put("pre."+resultSetMetaData.getColumnName(i)+'['+columnIndex+']',resultSet.getObject(i));
                    }
                    columnIndex++;
                }
            }
        }catch (Exception e){
            LOG.error(e.getMessage(),e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOG.error(e.getMessage(),e);
            }
        }

    }
}
