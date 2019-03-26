package org.tangxi.testcase.execution.model.checkPoint;

/***
 * 字符串类型检查类
 */
public class StrCheckPoint implements CheckPoint {
    private String type;
    private StrCheckPointType checkType;
    private String checkKey;
    private String expected;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public StrCheckPointType getCheckType() {
        return checkType;
    }

    public void setCheckType(StrCheckPointType checkType) {
        this.checkType = checkType;
    }

    public String getCheckKey() {
        return checkKey;
    }

    public void setCheckKey(String checkKey) {
        this.checkKey = checkKey;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }
}
