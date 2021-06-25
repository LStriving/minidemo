package com.question.minidemo.service.Imp;

import com.question.minidemo.dto.Answer;
import com.question.minidemo.dto.Problem;
import com.question.minidemo.dto.User;
import com.question.minidemo.mapper.AnswerMapper;
import com.question.minidemo.mapper.ProblemMapper;
import com.question.minidemo.mapper.UserMapper;
import com.question.minidemo.service.AnswerService;
import com.question.minidemo.utils.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("AnswerService")
public class AnswerServiceImp implements AnswerService {
    @Resource
    AnswerMapper answerMapper;
    @Resource
    ProblemMapper problemMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public JsonResult<Answer> getAnswer(String aid) {
        Answer answer = answerMapper.queryAnswerByAId(aid);
        JsonResult<Answer> json;
        json = answer != null
                ?new JsonResult<>("10000",answer)
                :new JsonResult<>("20000",null);
        return json;
    }

    @Override
    public JsonResult<String> addAnswer(Answer answer) {
        answerMapper.insertAnswer(answer);
        Answer res = answerMapper.queryAnswerByAId(answer.getAid());
        JsonResult<String> json;
        json = res != null
                ?new JsonResult<>("10000",null)
                :new JsonResult<>("20000",null);
        return json;
    }

    @Override
    public JsonResult<List<String>> getUserAnswer(String uid) {
        List<String> answer = answerMapper.queryAnswerByUId(uid);
        JsonResult<List<String>> json;
        json=answer.size()!=0
                ?new JsonResult<>("10000",answer)
                :new JsonResult<>("20000",answer);
        return json;
    }

    @Override
    public JsonResult<List<String>> getProblemAnswer(String pid) {
        List<String> answer = answerMapper.queryAnswerByPId(pid);
        JsonResult<List<String>> json;
        json=answer.size()!=0
                ?new JsonResult<>("10000",answer)
                :new JsonResult<>("20000",answer);
        return json;
    }

    @Override
    public JsonResult<String> deleteAnswer(String aid) {
        Answer answer = answerMapper.queryAnswerByAId(aid);
        JsonResult<String> json;
        json = answer == null
                ?new JsonResult<>("10000",null)
                :new JsonResult<>("20000",null);
        return json;
    }

    /*
        用户确认回答（回答者获得赏金，提问者扣除赏金，设置题目为已解决）
     */
    @Override
    public JsonResult<String> ConfirmAnswer(String aid) {
        try {
            Answer answer = answerMapper.queryAnswerByAId(aid);
            Problem problem = problemMapper.queryProblemById(answer.getPid());
            User a_user = userMapper.queryUserById(answer.getUid());//回答者
            User p_user = userMapper.queryUserById(problem.getUid());//发布者
            int bill = problem.getBill();
            a_user.setBill(a_user.getBill() + bill);
            p_user.setBill(p_user.getBill() - bill);
            userMapper.updateUser(a_user);
            userMapper.updateUser(p_user);
            problem.setStatus(1);
            problemMapper.updateProblem(problem);
            return new JsonResult<> ("10000",null);
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("========回答认证失败========");
            return new JsonResult<> ("20000",null);
        }
    }
}
