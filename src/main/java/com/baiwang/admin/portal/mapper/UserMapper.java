package com.baiwang.admin.portal.mapper;

import com.baiwang.admin.portal.bean.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    List<User> selectUserList();

    int insertUser(User user);

    User selectUserById(String userId);

    int updateUser(User user);

    int deleteUserById(String userId);

    User selectUserByLoginName(String loginName);
}
