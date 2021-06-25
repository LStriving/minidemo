package com.question.minidemo.testMapper;

import com.question.minidemo.dto.User;
import com.question.minidemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUser {

    @Autowired
    UserMapper mapper;
    @Test
    public void testAddUser(){
//        mapper.insertUser(new User("5","Anny","123456"));
        System.out.println(mapper.queryUserById("5"));
    }

}
