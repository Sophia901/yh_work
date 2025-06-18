package com.example.user_service.controller;

import com.example.user_service.dto.LoginResponseDto;
import com.example.user_service.dto.PlainResult;
import com.example.user_service.dto.UserDto;
import com.example.user_service.service.UserService;
import com.example.user_service.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   //接口方法返回对象 转换成json文本
@RequestMapping("/auth")  //测试的话就可以用这个 localhost:8088/auth/**
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public PlainResult<Long> register(@RequestBody UserDto userDto) {
        UserDto user = userService.getUserByUserName(userDto.getUsername());
        if (user != null) {
            return PlainResult.fail(400, "用户名已存在");
        }
        // 2.获取注册返回的用户ID
        Long userId = userService.register(userDto);
        // 3. 返回用户ID
        return PlainResult.success(userId);
    }

    @PostMapping("/login")
    public PlainResult<LoginResponseDto> login(@RequestBody UserDto userDto) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken
                        (userDto.getUsername(), userDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setToken(jwtUtil.generateToken(userDto.getUsername()));
        return PlainResult.success(loginResponseDto);
    }
}
