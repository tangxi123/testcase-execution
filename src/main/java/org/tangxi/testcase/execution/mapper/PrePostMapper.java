package org.tangxi.testcase.execution.mapper;

import org.tangxi.testcase.execution.model.prePostAction.PrePostActionWrapper;

public interface PrePostMapper {
    PrePostActionWrapper selectPrePostActionWrapperByName(String name);
}
