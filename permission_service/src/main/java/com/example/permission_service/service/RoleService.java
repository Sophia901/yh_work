package com.example.permission_service.service;

import com.example.permission_service.entity.user_role;
import com.example.permission_service.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {

    private final RoleMapper roleMapper;

    @Autowired
    public RoleService(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Transactional
    public void bindDefaultRole(Long userId) {
        // 检查是否已绑定
        if (roleMapper.existsByUserId(userId)) {
            throw new RuntimeException("用户已绑定角色");
        }

        // 绑定默认角色（普通用户）
        user_role userRole = new user_role();
        userRole.setUser_id(userId);
        userRole.setUser_role_id(2); // 普通用户

        if (roleMapper.insertUserRole(userRole) == 0) {
            throw new RuntimeException("角色绑定失败");
        }
    }

    public String getUserRoleCode(Long userId) {
        String roleCode = roleMapper.findRoleCodeByUserId(userId);
        if (roleCode == null) {
            throw new RuntimeException("用户未绑定角色");
        }
        return roleCode;
    }

}
