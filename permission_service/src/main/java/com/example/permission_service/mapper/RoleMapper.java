package com.example.permission_service.mapper;

import com.example.permission_service.entity.user_role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleMapper {
    @Insert("INSERT INTO user_roles(user_id, role_id) VALUES(#{userId}, #{roleId})")
    int insertUserRole(user_role userRole);

    @Select("SELECT role_code FROM roles r " +
            "JOIN user_roles ur ON r.role_id = ur.role_id " +
            "WHERE ur.user_id = #{userId}")
    String findRoleCodeByUserId(@Param("userId") Long userId);

    @Select("SELECT COUNT(*) FROM user_roles WHERE user_id = #{userId}")
    boolean existsByUserId(@Param("userId") Long userId);
}

