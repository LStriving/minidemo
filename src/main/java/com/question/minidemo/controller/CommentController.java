package com.question.minidemo.controller;

import com.question.minidemo.dto.Comment;
import com.question.minidemo.service.CommentService;
import com.question.minidemo.utils.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    CommentService commentService;

    /*
        针对某个问题发表评论
     */
    @RequestMapping("/add")
    public JsonResult<String> add(@RequestParam("cid")String cid,
                                  @RequestParam("content")String content,
                                  @RequestParam("pid")String pid,
                                  @RequestParam("uid")String uid
                                  ){
       return review(cid,content,pid,uid,"_");//没有父评论默认设置为"_"
    }
    /*
        针对某个评论进行再评论(或者回复)
     */
    @RequestMapping("/review")
    public JsonResult<String> review(@RequestParam("cid")String cid,
                                     @RequestParam("content")String content,
                                     @RequestParam("pid")String pid,
                                     @RequestParam("uid")String uid,
                                     @RequestParam("p_cid")String p_cid){
        return commentService.addComment(cid,content,pid,uid,p_cid);
    }
    @RequestMapping("/delete")
    public JsonResult<String> delete(@RequestParam("cid")String cid){
        return commentService.deleteComment(cid);
    }

    @RequestMapping("/get")
    public JsonResult<Comment> get(@RequestParam("cid")String cid){
        return commentService.getComment(cid);
    }

    //某个问题的所有评论
    @RequestMapping("/getPro")
    public JsonResult<List<String>> getPro(@RequestParam("pid")String pid){
        return commentService.getProblemComment(pid);
    }
    @RequestMapping("/getUser")
    public JsonResult<List<String>> getUser(@RequestParam("uid")String uid){
        return commentService.getUserComment(uid);
    }
    
}
