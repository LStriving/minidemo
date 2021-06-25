package com.question.minidemo.service;

import com.question.minidemo.dto.Comment;
import com.question.minidemo.utils.JsonResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Repository
@Service()
public interface CommentService {
    JsonResult<Comment> getComment(String cid);
    JsonResult<String> addComment(String cid,String content,String pid,String uid,String p_cid);
    JsonResult<List<String>> getUserComment(String uid);
    JsonResult<List<String>> getProblemComment(String pid);
    JsonResult<String> deleteComment(String cid);
}
