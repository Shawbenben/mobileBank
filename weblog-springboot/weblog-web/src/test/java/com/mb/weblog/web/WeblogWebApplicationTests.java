package com.mb.weblog.web;


import com.mb.weblog.common.domain.dos.UserDo;
import com.mb.weblog.common.domain.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@Slf4j
public class WeblogWebApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads () {
        // 编写单元测试
    }

    @Test
    void testLog(){
        log.info("this is an Info level log");
        log.warn("this is a Warm level log");
        log.error("this is a Error level log");

        //
        String author ="magic ben";
        log.info("this is a line with palceholder log, written by {} ", author);

    }
    @Test
    void insertTest() {
        // 构建数据库实体类
        UserDo userDo = UserDo.builder()
                .username("犬小哈")
                .password("123456")
                .createTime(new Date())
                .updateTime(new Date())
                .isDeleted(false)
                .build();
        userMapper.insert(userDo);
    }
}