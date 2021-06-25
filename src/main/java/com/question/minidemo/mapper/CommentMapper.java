package com.question.minidemo.mapper;

import com.question.minidemo.dto.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    Comment queryCommentByCid(String cid);
    List<String> queryProblemComment(String pid);
    List<String> queryUserComment(String uid);
    void insertComment(Comment comment);
    void deleteComment(String cid);
}
