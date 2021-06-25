package com.question.minidemo.testController;

import com.question.minidemo.controller.CommentController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class testComment {
    @Resource
    CommentController controller;

    @Test
    public void testAdd(){
        System.out.println(controller.add("01","有意思的问题！","10","33354"));
    }
    @Test
    public void testQuery(){
        System.out.println(controller.get("01"));
    }
    @Test
    public void testDelete(){
        System.out.println(controller.delete("01"));
    }
}
