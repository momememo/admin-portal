package com.baiwang.admin.portal.mapper;

import com.baiwang.admin.portal.bean.entity.Role;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface RoleMapper {

    List<Role> selectRoleList();

    int insertRole(Role role);

    Role selectRoleById(String roleId);

    int updateRole(Role role);

    int deleteRoleById(String roleId);

}
