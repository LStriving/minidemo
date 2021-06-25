package com.question.minidemo.testController;

import com.question.minidemo.controller.ProblemController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class testProblem {
    @Resource
    ProblemController controller;
    @Test
    public void testAddPro(){
        controller.publish("3322","33354","BALABALA","Question Title",10,"English");
    }
    @Test
    public void testDeletePro(){
        controller.delete("3322");
    }


}
