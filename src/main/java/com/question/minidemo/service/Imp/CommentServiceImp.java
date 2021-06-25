package com.question.minidemo.service.Imp;

import com.question.minidemo.dto.Comment;
import com.question.minidemo.mapper.CommentMapper;
import com.question.minidemo.service.CommentService;
import com.question.minidemo.utils.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("CommentService")
public class CommentServiceImp implements CommentService {
    @Resource
    CommentMapper mapper;

    @Override
    public JsonResult<Comment> getComment(String cid) {
        Comment comment = mapper.queryCommentByCid(cid);
        return comment != null
                ?new JsonResult<>("10000",comment)
                :new JsonResult<>("20000",null);
    }

    @Override
    public JsonResult<String> addComment(String cid, String content, String pid, String uid, String p_cid) {
        Comment comment=new Comment(cid,content,pid,uid,p_cid);
        mapper.insertComment(comment);
        Comment commentByCid = mapper.queryCommentByCid(comment.getCid());
        return commentByCid != null
                ?new JsonResult<>("10000",null)
                :new JsonResult<>("20000",null);
    }

    @Override
    public JsonResult<List<String>> getUserComment(String uid) {
        List<String> comment = mapper.queryUserComment(uid);
        return comment.size()!=0
                ?new JsonResult<>("10000",comment)
                :new JsonResult<>("20000",null);
    }

    @Override
    public JsonResult<List<String>> getProblemComment(String pid) {
        List<String> comment = mapper.queryProblemComment(pid);
        return comment.size()!=0
                ?new JsonResult<>("10000",comment)
                :new JsonResult<>("20000",null);
    }

    @Override
    public JsonResult<String> deleteComment(String cid) {
        mapper.deleteComment(cid);
        Comment comment = mapper.queryCommentByCid(cid);
        return comment == null
                ?new JsonResult<>("10000",null)
                :new JsonResult<>("20000",null);
    }
}
