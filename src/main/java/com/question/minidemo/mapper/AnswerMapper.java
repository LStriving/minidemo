package com.question.minidemo.mapper;

import com.question.minidemo.dto.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AnswerMapper {
    Answer queryAnswerByAId(String aid);
    List<String> queryAnswerByPId(String pid);
    List<String> queryAnswerByUId(String uid);
    void insertAnswer(Answer answer);
    void deleteAnswer(String aid);
    void updateAnswer(Answer answer);
}
