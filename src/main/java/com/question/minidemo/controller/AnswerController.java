package com.question.minidemo.controller;

import com.question.minidemo.dto.Answer;
import com.question.minidemo.service.AnswerService;
import com.question.minidemo.utils.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Resource
    AnswerService service;
    /**
       *@return 返回相应问题的回答id列表
     */
    @RequestMapping("/getProAns")
    public JsonResult<List<String>> getRroAns(@RequestParam("pid")String pid){
        return service.getProblemAnswer(pid);
    }
    @RequestMapping("/getUserAns")
    public JsonResult<List<String>> getUserAns(@RequestParam("uid")String uid){
        return service.getUserAnswer(uid);
    }

    @RequestMapping("/query")
    public JsonResult<Answer> query(@RequestParam("aid")String aid){
        return service.getAnswer(aid);
    }

    @RequestMapping("/delete")
    public JsonResult<String> delete(@RequestParam("aid")String aid){
            return service.deleteAnswer(aid);
    }

    @RequestMapping("/write")
    public JsonResult<String> write(@RequestParam("aid")String aid,
                                    @RequestParam("content")String content,
                                    @RequestParam("pid")String pid,
                                    @RequestParam("uid")String uid){
        return service.addAnswer(new Answer(aid,content,pid,uid));
    }

    @RequestMapping("/getConfirmed")
    public JsonResult<String> getConfirmed(@RequestParam("aid")String aid){
        return service.ConfirmAnswer(aid);
    }
}
