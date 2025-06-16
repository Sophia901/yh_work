package com.example.user_service.controller;

import com.example.user_service.dto.PlainResult;
import com.example.user_service.dto.UserDto;
import com.example.user_service.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;


import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
public class UserController {

    private UserService userService;

    @PostMapping("/rigister")
    public PlainResult<Void> register(@RequestBody UserDto userDto) {
        UserDto user = userService.getUserByUsername(userDto.getUserName());
        if (user != null) {
            return PlainResult.fail(400, "用户名已存在");
        }
        userService.register(userDto);
        return PlainResult.success(null);
    }
}
