package org.tangxi.testcase.execution.util;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.specification.RequestSpecification;
import org.tangxi.testcase.execution.model.TestCase;

import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class JsonPathUtil {
    private static RequestSpecification spec;


    public static JsonPath sendRequest(TestCase testCase,Map<String,Object> preActionResult){
        initSpec(testCase);
        String method = testCase.getMethod();
        String url = testCase.getUrl();
        String parameters = ReplaceHolderUtil.replacePlaceHolder(testCase.getParameters(),preActionResult);
        switch (method){
            case "GET":
                if(isToMap(parameters)){
                    Map<String,String> paramsMap = JacksonUtil.fromJson(parameters,Map.class);
                    return given()
                            .spec(spec)
                            .params(paramsMap)
                            .when()
                            .get(url)
                            .then()
                            .extract()
                            .jsonPath();
                }else {
                    return given()
                            .spec(spec)
                            .when()
                            .get(url + parameters)
                            .then()
                            .extract()
                            .jsonPath();
                }


            case "POST":
                return given()
                        .spec(spec)
                        .body(parameters)
                        .when()
                        .post(url)
                        .then()
                        .extract()
                        .jsonPath();

            case "PUT":
                return given()
                        .spec(spec)
                        .body(parameters)
                        .when()
                        .put(url)
                        .then()
                        .extract()
                        .jsonPath();

            case "DELETE":
                if(isToMap(parameters)){
                    Map<String,String> paramsMap = JacksonUtil.fromJson(parameters,Map.class);
                    return given()
                            .spec(spec)
                            .params(paramsMap)
                            .when()
                            .delete(url)
                            .then()
                            .extract()
                            .jsonPath();
                }else {
                    return given()
                            .spec(spec)
                            .when()
                            .get(url)
                            .then()
                            .extract()
                            .jsonPath();
                }
        }
        return null;


    }
    private static boolean isToMap(String str){
        try{
            JacksonUtil.fromJson(str,Map.class);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private static void initSpec(TestCase testCase){
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(testCase.getBaseUrl())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }
}
