package com.example.user_service.service.componet;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DistributedIdGenerator {
    private final Snowflake snowflake = new Snowflake(1, 1); // Hutool的Snowflake实现

    public Long nextId() {
        return snowflake.nextId();
    }
}
