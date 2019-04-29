package org.tangxi.testcase.execution.mapper;

import org.apache.ibatis.annotations.Param;
import org.tangxi.testcase.execution.model.TestCase;

import java.util.List;

public interface TCaseMapper {
    TestCase selectTestCaseById(int id);

    //根据groups名字查询所有的测试用例
    List<TestCase> getTestCasesByGroups(@Param("groups") String groups);

    //根据suite查询所有的测试用例
    List<TestCase> getTestCasesBySuite(@Param("suite") String suite);


}
