package com.example.user_service.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.example.user_service.dto.UserDto;
import com.example.user_service.entity.User;
import com.example.user_service.mapper.UserMapper;
import com.example.user_service.service.componet.DistributedIdGenerator;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private PasswordEncoder passwordEncoder;

    // 注入 Snowflake ID 生成器（单例）
    private final Snowflake snowflake = IdUtil.getSnowflake(1, 1); // 参数: 工作节点ID, 数据中心ID

    @Override
    public Long register(UserDto userDto) {
        User user = new User();
        // 生成分布式 ID (核心改动)
        Long userId = snowflake.nextId(); // 确保snowflake已初始化
        user.setUser_id(userId);
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userMapper.insert(user);

        // 返回生成的用户ID
        return userId;
    }


    @Override
    public UserDto getUserByUserName(String username) {

        User user = userMapper.findOneByUsername(username);
        if (user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    @Override
    public List<UserDto> getUserList() {
        return userMapper.selectList(null).stream().map(user -> {
            UserDto userDto = new UserDto();
            userDto.setUsername(user.getUsername());
            userDto.setGmt_create(user.getGmt_create());
            return userDto;
        }).collect(Collectors.toList());
    }
}
