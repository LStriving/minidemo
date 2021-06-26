package com.question.minidemo.service;

import com.question.minidemo.dto.Problem;
import com.question.minidemo.utils.JsonResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Repository
@Service()
public interface ProblemService {
    JsonResult<Problem> getProblem(String pid);
    JsonResult<Problem> addProblem(Problem problem);
    JsonResult<Problem> deleteProblem(String pid);
    JsonResult<List<String>> getUserProblem(String uid);
    JsonResult<List<String>> getAllProblem();
    JsonResult<List<String>> getUserProblemUnsolved(String uid);
    JsonResult<List<String>> getUserProblemSolved(String uid);
    JsonResult<List<String>> search(String pattern);
}
