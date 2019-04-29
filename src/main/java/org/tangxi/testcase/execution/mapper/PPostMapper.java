package org.tangxi.testcase.execution.mapper;

import org.tangxi.testcase.execution.model.prePostAction.PrePostActionWrapper;

public interface PPostMapper {
    PrePostActionWrapper selectPrePostActionWrapperByName(String name);
    PrePostActionWrapper selectName();
}
