package com.yjz.mp.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        //user.setId(4L);
        user.setUserName("亚历山大333");
        int i = userMapper.insert(user);
        user.setId(2L);
        user.setUserName("xxxxxxxxx");
        userMapper.updateById(user);
        List<User> users = userMapper.selectList(null);

    }

    @Test
    void testUpdate(){
        User user = new User();
        user.setId(4L);
        user.setUserName("buyguyguy");
        userMapper.updateById(user);
    }

    // 模拟乐观锁
    @Test
    void testOptimisticLock(){
        // 线程1修改1号用户
        User user = userMapper.selectById(1L);
        user.setUserName("User1");
        user.setAge(17);
        // 线程2插队修改·1号用户
        User user2 = userMapper.selectById(1L);
        user2.setUserName("User2");
        user2.setAge(3);
        userMapper.updateById(user2);

        // 线程1只能yong自旋锁来多次尝试提交
        userMapper.updateById(user);
    }


    // 测试分页
    @Test
    void testPage(){
        Page<User> page = new Page<>(2, 5);
        userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }

    // 测试LogicDeleted
    @Test
    void testLogicDeleted(){
        userMapper.deleteById(1L);
    }


    @Test
    void testWapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", "User2");
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

}
