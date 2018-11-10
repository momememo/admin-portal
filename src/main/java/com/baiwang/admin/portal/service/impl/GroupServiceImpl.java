package com.baiwang.admin.portal.service.impl;

import com.baiwang.admin.portal.bean.entity.Group;
import com.baiwang.admin.portal.mapper.GroupMapper;
import com.baiwang.admin.portal.service.GroupService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: liyunfei
 * @date: 2018/9/4 16:10
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupMapper groupMapper;

    private static Logger log = LoggerFactory.getLogger(GroupServiceImpl.class);

    /**
     * 获取分组列表
     *
     * @param requestId
     * @return
     */
    @Override
    public List<Group> getGroupList(String requestId) {
        return groupMapper.selectGroupList();
    }
}
