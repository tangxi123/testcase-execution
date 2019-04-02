package org.tangxi.testcase.execution.execution;

import com.jayway.restassured.path.json.JsonPath;
import org.tangxi.testcase.execution.model.checkPoint.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

@Test
public class VerifyExecutionTest {
    private static JsonPath requestResultJsonPath;

    @BeforeTest
    public void init(){
        String requestResult = "{\n" +
            "    \"code\": 200,\n" +
            "    \"data\": {\n" +
            "        \"headers\": {\n" +
            "            \"Content-Type\": \"application/json\"\n" +
            "        },\n" +
            "        \"preActionNames\": [\n" +
            "            \"插入一条数据测试\",\n" +
            "            \"获取插入数据的id\"\n" +
            "        ],\n" +
            "        \"method\": \"GET\",\n" +
            "        \"postActionNames\": [\n" +
            "            \"删除一条数据测试\"\n" +
            "        ],\n" +
            "        \"checkPoints\": [\n" +
            "            {\n" +
            "                \"expected\": \"test\",\n" +
            "                \"type\": \"StrCheckPoint\",\n" +
            "                \"strCheckPointType\": \"STREQUAL\",\n" +
            "                \"checkKey\": \"testname\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"expected\": \"完整测试\",\n" +
            "                \"type\": \"StrCheckPoint\",\n" +
            "                \"strCheckPointType\": \"STRNOTEQUAL\",\n" +
            "                \"checkKey\": \"descs\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"expected\": \"ll\",\n" +
            "                \"type\": \"StrCheckPoint\",\n" +
            "                \"strCheckPointType\": \"STRINCLUDE\",\n" +
            "                \"checkKey\": \"testModule\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"expected\": \"GET\",\n" +
            "                \"type\": \"StrCheckPoint\",\n" +
            "                \"strCheckPointType\": \"STRNOTINCLUDE\",\n" +
            "                \"checkKey\": \"method\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"expected\": \"123.56\",\n" +
            "                \"type\": \"NumCheckPoint\",\n" +
            "                \"checkKey\": \"number\",\n" +
            "                \"numCheckPointType\": \"NUM_EQ\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"expected\": \"1.2\",\n" +
            "                \"type\": \"NumCheckPoint\",\n" +
            "                \"checkKey\": \"number\",\n" +
            "                \"numCheckPointType\": \"NUM_GT\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"expected\": \"1\",\n" +
            "                \"type\": \"NumCheckPoint\",\n" +
            "                \"checkKey\": \"number\",\n" +
            "                \"numCheckPointType\": \"NUM_LT\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"expected\": \"56.7\",\n" +
            "                \"type\": \"NumCheckPoint\",\n" +
            "                \"checkKey\": \"number\",\n" +
            "                \"numCheckPointType\": \"NUM_GT_EQ\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"expected\": \"300.90\",\n" +
            "                \"type\": \"NumCheckPoint\",\n" +
            "                \"checkKey\": \"number\",\n" +
            "                \"numCheckPointType\": \"NUM_LT_EQ\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"expected\": \"10\",\n" +
            "                \"type\": \"ListCheckPoint\",\n" +
            "                \"listCheckPointType\": \"LIST_SIZE\",\n" +
            "                \"checkKey\": \"checkPoints\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"expected\": \"ListCheckPoint\",\n" +
            "                \"type\": \"ListCheckPoint\",\n" +
            "                \"listCheckPointType\": \"LIST_CONTAINS\",\n" +
            "                \"checkKey\": \"checkPoints.type\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"expected\": \"{expected=test, type=StrCheckPoint, strCheckPointType=STREQUAL, checkKey=testname}\",\n" +
            "                \"type\": \"ListCheckPoint\",\n" +
            "                \"listCheckPointType\": \"LIST_GET\",\n" +
            "                \"checkKey\": \"checkPoints\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"url\": \"/testcase/id/\",\n" +
            "        \"testModule\": \"query\",\n" +
            "        \"createdAt\": \"2019-03-06T12:33:01\",\n" +
            "        \"descs\": \"完整测试\",\n" +
            "        \"suite\": \"testcase\",\n" +
            "        \"id\": 59,\n" +
            "        \"parameters\": \"15\",\n" +
            "        \"testName\": \"test\",\n" +
            "        \"testNum\": \"23.56\",\n" +
            "        \"updatedAt\": \"2019-03-06T12:33:01\"\n" +
            "    },\n" +
            "    \"message\": \"获取测试用例成功\"\n" +
            "}";
    requestResultJsonPath = new JsonPath(requestResult);
}

    @Test
    public void whenAllCheckPointType_thenExecVerifyResultReturnTrue() throws Exception {
        StrCheckPoint strCheckPoint = new StrCheckPoint();
        strCheckPoint.setType("StrCheckPoint");
        strCheckPoint.setStrCheckPointType(StrCheckPointType.STREQUAL);
        strCheckPoint.setCheckKey("data.testName");
        strCheckPoint.setExpected("test");

        StrCheckPoint strCheckPoint2 = new StrCheckPoint();
        strCheckPoint2.setType("StrCheckPoint");
        strCheckPoint2.setStrCheckPointType(StrCheckPointType.STRNOTEQUAL);
        strCheckPoint2.setCheckKey("data.testName");
        strCheckPoint2.setExpected("test345");

        StrCheckPoint strCheckPoint3 = new StrCheckPoint();
        strCheckPoint3.setType("StrCheckPoint");
        strCheckPoint3.setStrCheckPointType(StrCheckPointType.STRINCLUDE);
        strCheckPoint3.setCheckKey("data.testName");
        strCheckPoint3.setExpected("es");

        StrCheckPoint strCheckPoint4 = new StrCheckPoint();
        strCheckPoint4.setType("StrCheckPoint");
        strCheckPoint4.setStrCheckPointType(StrCheckPointType.STRNOTINCLUDE);
        strCheckPoint4.setCheckKey("data.testName");
        strCheckPoint4.setExpected("haha");

        NumCheckPoint numCheckPoint = new NumCheckPoint();
        numCheckPoint.setType("NumCheckPoint");
        numCheckPoint.setNumCheckPointType(NumCheckPointType.NUM_EQ);
        numCheckPoint.setCheckKey("data.testNum");
        numCheckPoint.setExpected("23.56");

        NumCheckPoint numCheckPoint2 = new NumCheckPoint();
        numCheckPoint2.setType("NumCheckPoint");
        numCheckPoint2.setNumCheckPointType(NumCheckPointType.NUM_GT);
        numCheckPoint2.setCheckKey("data.testNum");
        numCheckPoint2.setExpected("20");

        NumCheckPoint numCheckPoint3 = new NumCheckPoint();
        numCheckPoint3.setType("NumCheckPoint");
        numCheckPoint3.setNumCheckPointType(NumCheckPointType.NUM_LT);
        numCheckPoint3.setCheckKey("data.testNum");
        numCheckPoint3.setExpected("26.56");

        NumCheckPoint numCheckPoint4 = new NumCheckPoint();
        numCheckPoint4.setType("NumCheckPoint");
        numCheckPoint4.setNumCheckPointType(NumCheckPointType.NUM_GT_EQ);
        numCheckPoint4.setCheckKey("data.testNum");
        numCheckPoint4.setExpected("22.56");

        NumCheckPoint numCheckPoint5 = new NumCheckPoint();
        numCheckPoint5.setType("NumCheckPoint");
        numCheckPoint5.setNumCheckPointType(NumCheckPointType.NUM_LT_EQ);
        numCheckPoint5.setCheckKey("data.testNum");
        numCheckPoint5.setExpected("28.56");

        ListCheckPoint listCheckPoint = new ListCheckPoint();
        listCheckPoint.setType("ListCheckPoint");
        listCheckPoint.setListCheckPointType(ListCheckPointType.LIST_SIZE);
        listCheckPoint.setCheckKey("data.checkPoints");
        listCheckPoint.setExpected("12");

        ListCheckPoint listCheckPoint2 = new ListCheckPoint();
        listCheckPoint2.setType("ListCheckPoint");
        listCheckPoint2.setListCheckPointType(ListCheckPointType.LIST_CONTAINS);
        listCheckPoint2.setCheckKey("data.checkPoints.type");
        listCheckPoint2.setExpected("StrCheckPoint");

        List<CheckPoint> checkPoints = new ArrayList<>();
        checkPoints.add(strCheckPoint);
        checkPoints.add(strCheckPoint2);
        checkPoints.add(strCheckPoint3);
        checkPoints.add(strCheckPoint4);
        checkPoints.add(numCheckPoint);
        checkPoints.add(numCheckPoint2);
        checkPoints.add(numCheckPoint3);
        checkPoints.add(numCheckPoint4);
        checkPoints.add(numCheckPoint5);
        checkPoints.add(listCheckPoint);
        checkPoints.add(listCheckPoint2);

        VerifyExecution.execVerifyResult(requestResultJsonPath,checkPoints);
    }
}