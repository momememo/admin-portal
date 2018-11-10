package com.baiwang.admin.portal.mapper;

import com.baiwang.admin.portal.bean.entity.Group;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface GroupMapper {

    List<Group> selectGroupList();

    int insertGroup(Group group);

    Group selectGroupById(String groupId);

    int updateGroup(Group group);

    int deleteGroupById(String groupId);

}
