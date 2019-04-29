package org.tangxi.testcase.execution.model;

import org.tangxi.testcase.execution.model.checkPoint.CheckPoint;

import java.time.LocalDateTime;
import java.util.List;

public class TestCase {

    private int id;

    private String suite;

    private String testModule;

    private String groups;

    private String testName;

    private String descs;

    private String method;

    private String baseUrl;

    private String url;

    private String headers;

    private String parameters;

    private List<String> preActions;

    private List<CheckPoint> checkPoints;

    private List<String> postActions;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String actual;

//    private TestStatus is_passed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getTestModule() {
        return testModule;
    }

    public void setTestModule(String testModule) {
        this.testModule = testModule;
    }

    public String getGroups() {
        return groups;
    }


    public void setGroups(String groups) {
        this.groups = groups;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public List<String> getPreActions() {
        return preActions;
    }

    public void setPreActions(List<String> preActions) {
        this.preActions = preActions;
    }

    public List<CheckPoint> getCheckPoints() {
        return checkPoints;
    }

    public void setCheckPoints(List<CheckPoint> checkPoints) {
        this.checkPoints = checkPoints;
    }

    public List<String> getPostActions() {
        return postActions;
    }

    public void setPostActions(List<String> postActions) {
        this.postActions = postActions;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }
}
