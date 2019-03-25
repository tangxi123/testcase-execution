package org.tangxi.testcase.execution.mapper;

import org.tangxi.testcase.execution.model.TestCase;

public interface TestCaseMapper {
    TestCase selectTestCaseById(Long id);
}
