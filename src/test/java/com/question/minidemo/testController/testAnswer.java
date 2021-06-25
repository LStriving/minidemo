package com.question.minidemo.testController;

import com.question.minidemo.controller.AnswerController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class testAnswer {
    @Resource
    AnswerController controller;
    @Test
    public void testWrite(){
        controller.write("123","可能采用二分查找法","10","33");
    }
    @Test
    public void testProQuery(){
        controller.getRroAns("10");
    }
    @Test
    public void testQuery(){
        controller.query("123");
    }
    @Test
    public void testDelete(){
        controller.delete("123");
    }
}
