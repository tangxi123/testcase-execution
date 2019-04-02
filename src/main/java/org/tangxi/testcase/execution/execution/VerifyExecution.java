package org.tangxi.testcase.execution.execution;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jayway.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tangxi.testcase.execution.TestApplication;
import org.tangxi.testcase.execution.model.checkPoint.CheckPoint;
import org.tangxi.testcase.execution.model.checkPoint.StrCheckPoint;
import org.tangxi.testcase.execution.model.checkPoint.StrCheckPointType;
import org.tangxi.testcase.execution.util.JacksonUtil;
import org.tangxi.testcase.execution.util.VerifyUtil;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.tangxi.testcase.execution.util.VerifyUtil.verifyCheck;
import static org.tangxi.testcase.execution.util.VerifyUtil.verifyCheckType;

public class VerifyExecution {
    private final static Logger LOG = LoggerFactory.getLogger( VerifyExecution.class);

    public static void  execVerifyResult(JsonPath requestResults, List<CheckPoint> checkPoints){
        SoftAssert assertion = new SoftAssert();
        LOG.debug("checkPoints为：{}",checkPoints);
        for(int i=0; i<checkPoints.size(); i++){
            CheckPoint checkPoint = checkPoints.get(i);
            verifyCheck(requestResults,checkPoint,assertion);
        }
        assertion.assertAll();
    }
}
