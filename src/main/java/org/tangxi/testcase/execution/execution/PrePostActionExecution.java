package org.tangxi.testcase.execution.execution;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tangxi.testcase.execution.mapper.PrePostMapper;
import org.tangxi.testcase.execution.model.prePostAction.PrePostAction;
import org.tangxi.testcase.execution.model.prePostAction.PrePostActionSql;
import org.tangxi.testcase.execution.model.prePostAction.PrePostActionType;
import org.tangxi.testcase.execution.model.prePostAction.PrePostActionWrapper;
import org.tangxi.testcase.execution.util.JacksonUtil;
import org.tangxi.testcase.execution.util.SqlSessionFactoryUtil;

import java.util.List;

/**
 * 执行前后置动作的类
 */
public class PrePostActionExecution {
    private static final Logger LOG = LoggerFactory.getLogger(PrePostActionExecution.class);

    public static void execActions(List<String> actions){
        if(actions == null){
            return;
        }
        for(String action : actions){
            execAction(action);
        }
    }

    private static void execAction(String actionName){
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
                    execSqlAction(action);
            }
        }catch (Exception e){
            LOG.error(e.getMessage(),e);
//            throw e;
        }finally {
            sqlSession.close();
        }
    }

    private static void execSqlAction(PrePostAction action){
        if(action == null){
            return;
        }
        String actionStr = JacksonUtil.toJson(action);
        PrePostActionSql prePostActionSql = JacksonUtil.fromJson(actionStr, PrePostActionSql.class);

    }
}
