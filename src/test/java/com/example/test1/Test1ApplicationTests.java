package com.example.test1;

import com.example.test1.mapper.UserMapper;
import com.example.test1.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Test1ApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void insertUser() {//insert
        User user = new User();
        user.setNumber("66666");
        user.setPassword("66666");
        int result = userMapper.insert(user);
        System.out.println(result);
    }
    @Test
    void deleteMap(){//delete
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("number",66666);
        int result = userMapper.deleteByMap(map);
        System.out.println(result);
    }
    @Test
    void selectUser(){
        User user = userMapper.selectById("11111");
        System.out.println(user.getPassword());
    }

}
