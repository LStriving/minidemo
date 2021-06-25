package com.question.minidemo.service;

import com.question.minidemo.dto.Answer;
import com.question.minidemo.utils.JsonResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Repository
@Service()
public interface AnswerService {
     JsonResult<Answer> getAnswer(String aid);
     JsonResult<String> addAnswer(Answer answer);
     JsonResult<List<String>> getUserAnswer(String uid);
     JsonResult<List<String>> getProblemAnswer(String pid);
     JsonResult<String> deleteAnswer(String aid);
     JsonResult<String> ConfirmAnswer(String aid);
}
