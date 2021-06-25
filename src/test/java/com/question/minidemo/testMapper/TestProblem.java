package com.question.minidemo.testMapper;

import com.question.minidemo.dto.Problem;
import com.question.minidemo.mapper.ProblemMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestProblem {
    @Resource
    ProblemMapper mapper;
    @Test
    public void testUpdate(){
        mapper.updateProblem(new Problem("10","33354",1,"这道题怎么做","no",20,0,"","2021-6-25 21:00"));
    }
}
