package org.tangxi.testcase.execution.model.checkPoint;

/**
 * 不同数值判断类型:
 *      等于：=
 *      大于：>
 *      小于：<
 *      大于等于：>=
 *      小于等于:<=
 *
 * @author Tangx
 * 2019-02-28 12:28
 */
public enum NumCheckPointType implements CheckPointType {
    NUM_EQ("=","等于"),
    NUM_GT(">","大于"),
    NUM_LT("<","小于"),
    NUM_LT_EQ("<=","小于等于"),
    NUM_GT_EQ(">=","大于等于");

    private String abbr;
    private String titile;

    private NumCheckPointType(String abbr, String titile){
        this.abbr = abbr;
        this.titile = titile;
    }

    public String getAbbr(){
        return abbr;
    }

    public String getTitile(){
        return titile;
    }

    public static NumCheckPointType fromAbbr(String abbr){
        for(NumCheckPointType numCheckPointType : NumCheckPointType.values()){
            if(numCheckPointType.getAbbr().equals(abbr)){
                return numCheckPointType;
            }
        }
        return null;
    }
}
