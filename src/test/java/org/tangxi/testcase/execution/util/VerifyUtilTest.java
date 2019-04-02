package org.tangxi.testcase.execution.util;

import com.jayway.restassured.path.json.JsonPath;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.tangxi.testcase.execution.model.checkPoint.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test
public class VerifyUtilTest {
    private static JsonPath requestResultJsonPath;
    private static SoftAssert assertion;

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
        assertion = new SoftAssert();
    }


    @Test
    public void whenCheckTypeIsSTREQUAL_thenAssertEquals() throws Exception {
        StrCheckPoint strCheckPoint = new StrCheckPoint();
        strCheckPoint.setType("StrCheckPoint");
        strCheckPoint.setStrCheckPointType(StrCheckPointType.STREQUAL);
        strCheckPoint.setCheckKey("data.testName");
        strCheckPoint.setExpected("test");
        VerifyUtil.verifyCheckType(requestResultJsonPath,strCheckPoint,assertion);
    }

    @Test
    public void whenCheckTypeIsSTRNOTEQUAL_thenAssertNotEquals() throws Exception {
        StrCheckPoint strCheckPoint = new StrCheckPoint();
        strCheckPoint.setType("StrCheckPoint");
        strCheckPoint.setStrCheckPointType(StrCheckPointType.STRNOTEQUAL);
        strCheckPoint.setCheckKey("data.testName");
        strCheckPoint.setExpected("test123");
        VerifyUtil.verifyCheckType(requestResultJsonPath, strCheckPoint,assertion);
    }

    @Test
    public void whenCheckTypeIsSTRINCLUDE_thenAssertInclude() throws Exception {
        StrCheckPoint strCheckPoint = new StrCheckPoint();
        strCheckPoint.setType("StrCheckPoint");
        strCheckPoint.setStrCheckPointType(StrCheckPointType.STRINCLUDE);
        strCheckPoint.setCheckKey("data.testName");
        strCheckPoint.setExpected("es");
        VerifyUtil.verifyCheckType(requestResultJsonPath, strCheckPoint,assertion);
    }

    @Test
    public void whenCheckTypeIsSTRNOTINCLUDE_thenAssertNotInclude() throws Exception {
        StrCheckPoint strCheckPoint = new StrCheckPoint();
        strCheckPoint.setType("StrCheckPoint");
        strCheckPoint.setStrCheckPointType(StrCheckPointType.STRNOTINCLUDE);
        strCheckPoint.setCheckKey("data.testName");
        strCheckPoint.setExpected("haha");
        VerifyUtil.verifyCheckType(requestResultJsonPath, strCheckPoint,assertion);
    }

    @Test
    public void whenCheckTypeIsNUM_EQ_thenAssertEquals() throws Exception {
        NumCheckPoint numCheckPoint = new NumCheckPoint();
        numCheckPoint.setType("NumCheckPoint");
        numCheckPoint.setNumCheckPointType(NumCheckPointType.NUM_EQ);
        numCheckPoint.setCheckKey("data.testNum");
        numCheckPoint.setExpected("23.56");
        VerifyUtil.verifyCheckType(requestResultJsonPath, numCheckPoint,assertion);
    }

    @Test
    public void whenCheckTypeIsNUM_GT_thenAssertTrue() throws Exception {
        NumCheckPoint numCheckPoint = new NumCheckPoint();
        numCheckPoint.setType("NumCheckPoint");
        numCheckPoint.setNumCheckPointType(NumCheckPointType.NUM_GT);
        numCheckPoint.setCheckKey("data.testNum");
        numCheckPoint.setExpected("20");
        VerifyUtil.verifyCheckType(requestResultJsonPath, numCheckPoint,assertion);
    }

    @Test
    public void whenCheckTypeIsNUM_LT_thenAssertTrue() throws Exception {
        NumCheckPoint numCheckPoint = new NumCheckPoint();
        numCheckPoint.setType("NumCheckPoint");
        numCheckPoint.setNumCheckPointType(NumCheckPointType.NUM_LT);
        numCheckPoint.setCheckKey("data.testNum");
        numCheckPoint.setExpected("26.56");
        VerifyUtil.verifyCheckType(requestResultJsonPath, numCheckPoint,assertion);
    }

    @Test
    public void whenCheckTypeIsNUM_GT_EQ_thenAssertTrue() throws Exception {
        NumCheckPoint numCheckPoint = new NumCheckPoint();
        numCheckPoint.setType("NumCheckPoint");
        numCheckPoint.setNumCheckPointType(NumCheckPointType.NUM_GT_EQ);
        numCheckPoint.setCheckKey("data.testNum");
        numCheckPoint.setExpected("22.56");
        VerifyUtil.verifyCheckType(requestResultJsonPath, numCheckPoint,assertion);
    }

    @Test
    public void whenCheckTypeIsNUM_LT_EQ_thenAssertTrue() throws Exception {
        NumCheckPoint numCheckPoint = new NumCheckPoint();
        numCheckPoint.setType("NumCheckPoint");
        numCheckPoint.setNumCheckPointType(NumCheckPointType.NUM_LT_EQ);
        numCheckPoint.setCheckKey("data.testNum");
        numCheckPoint.setExpected("28.56");
        VerifyUtil.verifyCheckType(requestResultJsonPath, numCheckPoint,assertion);
    }

    @Test
    public void whenCheckTypeIsLIST_SIZE_thenAssertEquals() throws Exception {
        ListCheckPoint listCheckPoint = new ListCheckPoint();
        listCheckPoint.setType("ListCheckPoint");
        listCheckPoint.setListCheckPointType(ListCheckPointType.LIST_SIZE);
        listCheckPoint.setCheckKey("data.checkPoints");
        listCheckPoint.setExpected("12");
        VerifyUtil.verifyCheckType(requestResultJsonPath, listCheckPoint,assertion);
    }

    @Test
    public void whenCheckTypeIsLIST_CONTAINS_thenAssertTrue() throws Exception {
        ListCheckPoint listCheckPoint = new ListCheckPoint();
        listCheckPoint.setType("ListCheckPoint");
        listCheckPoint.setListCheckPointType(ListCheckPointType.LIST_CONTAINS);
        listCheckPoint.setCheckKey("data.checkPoints.type");
        listCheckPoint.setExpected("StrCheckPoint");
        VerifyUtil.verifyCheckType(requestResultJsonPath, listCheckPoint,assertion);
    }




}