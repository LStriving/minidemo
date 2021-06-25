package com.question.minidemo.mapper;

import com.question.minidemo.dto.Problem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProblemMapper {
    Problem queryProblemById(String pid);
    void insertProblem(Problem problem);
    void deleteProblem(String pid);
    void updateProblem(Problem problem);
    List<String> queryUserProblem(String uid);
    List<String> queryAll();
}
