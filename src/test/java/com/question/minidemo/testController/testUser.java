package com.question.minidemo.testController;

import com.question.minidemo.controller.UserController;
import com.question.minidemo.dto.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class testUser {
    @Resource
    UserController controller;
    @Test
    public void testRegister(){
        System.out.println(controller.register("323@123.com","male","1223"));
    }
    @Test
    public void testLogin(){
        System.out.println(controller.login("33@123.com","1231456"));
    }
    @Test
    public void testQueryID(){
        System.out.println(controller.queryInfo("33354"));
    }
    @Test
    public void testUpdate(){
        //日期的格式可能需要注意
        controller.updateInfo("33354","Andy","female","2021-01-23","Beijing");
    }


}
