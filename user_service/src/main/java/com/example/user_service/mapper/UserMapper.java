package com.example.user_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.user_service.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author yao
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2024-06-24 09:29:06
 * @Entity generator.domain.User
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User findOneByUsername(@Param("username") String username);
}
