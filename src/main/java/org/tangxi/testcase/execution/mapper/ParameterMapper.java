package org.tangxi.testcase.execution.mapper;

import org.tangxi.testcase.execution.model.parameter.ParameterWrapper;

public interface ParameterMapper {
    ParameterWrapper selectParameterWrapperByName(String name);
}
