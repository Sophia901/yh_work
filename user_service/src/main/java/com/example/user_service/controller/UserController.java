package com.example.user_service.controller;

import com.example.user_service.dto.PlainResult;
import com.example.user_service.dto.UserDto;
import com.example.user_service.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    @Resource
    private UserService userService;

    @GetMapping("/users")
    public PlainResult<List<UserDto>> users() {
        List<UserDto> userList = userService.getUserList();
        return PlainResult.success(userList);
    }
}
