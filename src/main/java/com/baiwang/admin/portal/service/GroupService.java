package com.baiwang.admin.portal.service;

import com.baiwang.admin.portal.bean.entity.Group;
import java.util.List;

public interface GroupService {

    /**
     * 获取分组列表
     * @param requestId
     * @return
     */
    List<Group> getGroupList();
}
