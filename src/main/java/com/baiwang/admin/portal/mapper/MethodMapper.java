package com.baiwang.admin.portal.mapper;

import com.baiwang.admin.portal.bean.entity.Method;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface MethodMapper {

    List<Method> selectMethodList(@Param("groupId") String groupId, @Param("start") Integer start, @Param("size") Integer size);

    int insertMethod(Method method);

    Method selectMethodById(String methodId);

    int updateMethod(Method method);

    int deleteMethodById(String methodId);

    int selectCountMethods(String groupId);

    Method selectMethodByMethodName(String method);
}
