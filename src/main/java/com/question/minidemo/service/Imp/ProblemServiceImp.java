package com.question.minidemo.service.Imp;

import com.question.minidemo.dto.Problem;
import com.question.minidemo.dto.User;
import com.question.minidemo.mapper.ProblemMapper;
import com.question.minidemo.mapper.UserMapper;
import com.question.minidemo.service.ProblemService;
import com.question.minidemo.utils.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ProblemService")
public class ProblemServiceImp implements ProblemService {
    @Resource
    UserMapper userMapper;
    @Resource
    ProblemMapper problemMapper;
    @Override
    public JsonResult<Problem> getProblem(String pid) {
        Problem problem = problemMapper.queryProblemById(pid);
        JsonResult<Problem> json;
        json = problem != null
                ?new JsonResult<>("10000",problem)
                :new JsonResult<>("20000",null);
        return json;
    }

    @Override
    public JsonResult<Problem> addProblem(Problem problem) {
        User user= userMapper.queryUserById(problem.getUid());
        if(user.getBill()<problem.getBill()||problem.getBill()<=0){
            return new JsonResult<>("30000",null);//赏金设置非法
        }
        problemMapper.insertProblem(problem);
        JsonResult<Problem> json;
        Problem res=problemMapper.queryProblemById(problem.getPid());
        json = res != null
                ?new JsonResult<>("10000",null)     //成功
                :new JsonResult<>("20000",null);    //失败
        return json;
    }

    @Override
    public JsonResult<Problem> deleteProblem(String pid) {
        problemMapper.deleteProblem(pid);
        Problem res = problemMapper.queryProblemById(pid);
        JsonResult<Problem> json;
        json = res == null
                ?new JsonResult<>("10000",null)
                :new JsonResult<>("20000",null);
        return json;
    }

    @Override
    public JsonResult<List<String>> getUserProblem(String uid) {
        List<String> pid = problemMapper.queryUserProblem(uid);
        JsonResult<List<String>> json;
        json=pid.size()!=0
                ?new JsonResult<>("10000",pid)
                :new JsonResult<>("20000",pid);
        return json;
    }

    @Override
    public JsonResult<List<String>> getAllProblem() {
        List<String> pid = problemMapper.queryAll();
        JsonResult<List<String>> json;
        json=pid.size()!=0
                ?new JsonResult<>("10000",pid)
                :new JsonResult<>("20000",pid);
        return json;
    }

    @Override
    public JsonResult<List<String>> getUserProblemUnsolved(String uid) {
        List<String> pid = problemMapper.queryUserProblem(uid);
        if(pid==null)return new JsonResult<>("20000",null);
        for(int i=0;i<pid.size();i++){
            Problem problem = problemMapper.queryProblemById(pid.get(i));
            if(problem!=null&&problem.getStatus()==1){
                pid.remove(i);
                i--;
            }
        }
        JsonResult<List<String>> json;
        json=pid.size()!=0
                ?new JsonResult<>("10000",pid)
                :new JsonResult<>("20000",pid);
        return json;
    }

    @Override
    public JsonResult<List<String>> getUserProblemSolved(String uid) {
        List<String> pid = problemMapper.queryUserProblem(uid);
        if(pid==null)return new JsonResult<>("20000",null);
        for(int i=0;i<pid.size();i++){
            Problem problem = problemMapper.queryProblemById(pid.get(i));
            if(problem!=null&&problem.getStatus()==0){
                pid.remove(i);
                i--;
            }
        }
        JsonResult<List<String>> json;
        json=pid.size()!=0
                ?new JsonResult<>("10000",pid)
                :new JsonResult<>("20000",pid);
        return json;
    }

}
