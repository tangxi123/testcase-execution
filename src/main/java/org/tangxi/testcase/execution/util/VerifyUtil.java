package org.tangxi.testcase.execution.util;

import com.jayway.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tangxi.testcase.execution.model.checkPoint.*;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class VerifyUtil {

    private static final Logger LOG = LoggerFactory.getLogger(VerifyUtil.class);

    private final static String STR_CHECK_POINT ="StrCheckPoint";
    private final static String NUM_CHECK_POINT="NumCheckPoint";
    private final static String LIST_CHECK_POINT="ListCheckPoint";


    public static void verifyCheck(JsonPath requestResults,CheckPoint checkPoint,SoftAssert assertion){
        String type = checkPoint.getType();
        if(type == null){
            return;
        }
        switch (type){
            case STR_CHECK_POINT:
                verifyCheckType(requestResults,checkPoint,assertion);
                break;
            case NUM_CHECK_POINT:
                verifyCheckType(requestResults,checkPoint,assertion);
                break;
            case LIST_CHECK_POINT:
                verifyCheckType(requestResults,checkPoint,assertion);
                break;
        }
    }

    public static void verifyCheckType(JsonPath requestResults,CheckPoint checkPoint,SoftAssert assertion){
        CheckPointType checkType = checkPoint.getCheckPointType();
        String checkKey = checkPoint.getCheckKey();
        String expected = checkPoint.getExpected();

        if(checkType instanceof StrCheckPointType){
            StrCheckPointType type = (StrCheckPointType) checkType;
            String actual = requestResults.getString(checkKey);
            switch (type){
                case STREQUAL:
                    assertion.assertEquals(actual,expected);
                    LOG.debug("字符串相等判断:"+ "\n"
                            +"接口返回的json字符串中:{}的值为：{}"+"\n"
                            +"期望的json字符串中: {}的值为：{}",checkKey,actual,checkKey,expected
                    );
                    break;
                case STRNOTEQUAL:
                    assertion.assertNotEquals(actual, expected);
                    LOG.debug("字符串不相等判断:"+ "\n"
                            +"接口返回的json字符串中:{}的值为：{}"+"\n"
                            +"期望的json字符串中: {}的值为：{}",checkKey,actual,checkKey,expected
                    );
                    break;
                case STRINCLUDE:
                    assertion.assertTrue(actual.contains(expected));
                    LOG.debug("字符串包含判断:"+ "\n"
                            +"接口返回的json字符串中:{}的值为：{}"+"\n"
                            +"期望的json字符串中: {}的值为：{}",checkKey,actual,checkKey,expected
                    );
                    break;
                case STRNOTINCLUDE:
                    assertion.assertFalse(actual.contains(expected));
                    LOG.debug("字符串不包含判断:"+ "\n"
                            +"接口返回的json字符串中:{}的值为：{}"+"\n"
                            +"期望的json字符串中: {}的值为：{}",checkKey,actual,checkKey,expected
                    );
                    break;
            }
        }else if(checkType instanceof NumCheckPointType){
            NumCheckPointType type = (NumCheckPointType) checkType;
            double actual = requestResults.getDouble(checkKey);
            switch (type){
                case NUM_EQ:
                    assertion.assertEquals(actual,Double.parseDouble(expected));
                    LOG.debug("数值相等判断:"+ "\n"
                            +"接口返回的json字符串中:{}的值为：{}"+"\n"
                            +"期望的json字符串中: {}的值为：{}",checkKey,actual,checkKey,expected
                    );
                    break;
                case NUM_GT:
                    assertion.assertTrue(actual>Double.parseDouble(expected));
                    LOG.debug("数值大于判断:"+ "\n"
                            +"接口返回的json字符串中:{}的值为：{}"+"\n"
                            +"期望的json字符串中: {}的值为：{}",checkKey,actual,checkKey,Double.parseDouble(expected)
                    );
                    break;
                case NUM_LT:
                    assertion.assertTrue(actual<Double.parseDouble(expected));
                    LOG.debug("数值小于判断:"+ "\n"
                            +"接口返回的json字符串中:{}的值为：{}"+"\n"
                            +"期望的json字符串中: {}的值为：{}",checkKey,actual,checkKey,Double.parseDouble(expected)
                    );
                    break;
                case NUM_GT_EQ:
                    assertion.assertTrue(actual>=Double.parseDouble(expected));
                    LOG.debug("数值大于等于判断:"+ "\n"
                            +"接口返回的json字符串中:{}的值为：{}"+"\n"
                            +"期望的json字符串中: {}的值为：{}",checkKey,actual,checkKey,Double.parseDouble(expected)
                    );
                    break;
                case NUM_LT_EQ:
                    assertion.assertTrue(actual<=Double.parseDouble(expected));
                    LOG.debug("数值小于等于判断:"+ "\n"
                            +"接口返回的json字符串中:{}的值为：{}"+"\n"
                            +"期望的json字符串中: {}的值为：{}",checkKey,actual,checkKey,Double.parseDouble(expected)
                    );
                    break;
            }
        }else if(checkType instanceof ListCheckPointType){
            ListCheckPointType type = (ListCheckPointType)checkType;
            List<?> actual = requestResults.getList(checkKey);
            switch (type){
                case LIST_SIZE:
                    assertion.assertEquals(actual.size(),Integer.parseInt(expected));
                    LOG.debug("List大小判断："+ "\n"
                            +"接口返回的json字符串中:{}的值为：{}"+"\n"
                            +"期望的json字符串中: {}的值为：{}",checkKey,actual.size(),checkKey,expected
                    );
                    break;
                case LIST_CONTAINS:
                    assertion.assertTrue(actual.contains(expected));
                    LOG.debug("List包含判断：："+ "\n"
                            +"接口返回的json字符串中:{}的值为：{}"+"\n"
                            +"期望的json字符串中: {}的值为：{}",checkKey,actual,checkKey,expected
                    );
                    break;
            }
        }
    }
}
