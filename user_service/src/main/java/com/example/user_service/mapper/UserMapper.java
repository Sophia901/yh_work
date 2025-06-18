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

    // 新增分片键查询方法
    @Select("SELECT * FROM user WHERE user_id = #{userId}")
    User selectByUserId(@Param("userId") Long userId);

    // 新增方法：按用户名查询（使用注解实现）
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(@Param("username") String username);
}
