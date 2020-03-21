package com.yjz.mp.demo;

import com.yjz.mp.demo.entity.User;
import com.yjz.mp.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@SpringBootTest
class DemoApplicationTests {


    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }


    // 初始测试插入
    @Test
    void test_insert() {
        User user = new User();
        user.setId(3L);
        user.setUserName("亚历山大333");
        user.setGmtCreate(new Date());
        user.setGmtModify(new Date());
        int i = userMapper.insert(user);

        List<User> users = userMapper.selectList(null);

    }
}
