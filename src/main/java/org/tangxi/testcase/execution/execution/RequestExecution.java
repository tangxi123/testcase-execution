package org.tangxi.testcase.execution.execution;

import com.jayway.restassured.path.json.JsonPath;
import org.tangxi.testcase.execution.model.TestCase;
import org.tangxi.testcase.execution.util.JsonPathUtil;

import java.util.Map;

public class RequestExecution {
    public static JsonPath sendRequest(TestCase testCase,Map<String,Object> preActionResult){
        return JsonPathUtil.sendRequest(testCase,preActionResult);
    }
}
