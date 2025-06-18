package com.example.user_service.service;

import com.example.user_service.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    /**
     * 用户注册
     * @param user
     */
    Long register(UserDto user);

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    UserDto getUserByUserName(String username);

    /**
     * 用户列表
     * @return
     */
    List<UserDto> getUserList();
}
