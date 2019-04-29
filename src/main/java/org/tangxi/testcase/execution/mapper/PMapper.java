package org.tangxi.testcase.execution.mapper;

import org.tangxi.testcase.execution.model.parameter.ParameterWrapper;

public interface PMapper {
    ParameterWrapper selectParameterWrapperByName(String name);
}
