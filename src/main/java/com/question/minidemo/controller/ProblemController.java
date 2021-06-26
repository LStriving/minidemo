package com.question.minidemo.controller;

import com.question.minidemo.dto.Problem;
import com.question.minidemo.service.ProblemService;
import com.question.minidemo.utils.JsonResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pro")
public class ProblemController {
    @Resource
    ProblemService problemService;

    @RequestMapping("/publish")
    public JsonResult<Problem> publish(@RequestParam("pid")String pid,
                                       @RequestParam("uid")String uid,
                                       @RequestParam("content")String content,
                                       @RequestParam("title")String title,
                                       @RequestParam("bill")int bill,
                                       @RequestParam("tag")String tag){
        //检查bill的合法性
        Problem problem = new Problem();
        problem.publishPro(pid,uid,content,bill,tag,title);
        return problemService.addProblem(problem);
    }

    @RequestMapping("/delete")
    public JsonResult<Problem> delete(@RequestParam("pid")String pid){
        return problemService.deleteProblem(pid);
    }

    @RequestMapping("/query")
    public JsonResult<Problem> query(@RequestParam("pid")String pid){
        return problemService.getProblem(pid);
    }

    @RequestMapping("/queryAll")
    public JsonResult<List<String>>queryAll(){
         return problemService.getAllProblem();
    }

    /*
        获取个人发布的所有题目
     */
    @RequestMapping("/queryUserAll")
    public JsonResult<List<String>> queryUserAll(@RequestParam("uid")String uid){
        return problemService.getUserProblem(uid);
    }
    /*
        获取个人未被解决的问题
     */
    @RequestMapping("/queryUserUnsolved")
    public JsonResult<List<String>> queryUserUnsolved(@RequestParam("uid")String uid){
         return problemService.getUserProblemUnsolved(uid);
    }
    /*
            获取个人已经被解决的问题
     */
    @RequestMapping("/queryUserSolved")
    public JsonResult<List<String>> queryUserSolved(@RequestParam("uid")String uid){
        return problemService.getUserProblemSolved(uid);
    }

    /*
        上传图片 待解决
     */
    @RequestMapping("/uploadImg")
    public JsonResult<String> uploadImg(HttpServletRequest req, @RequestParam("image")MultipartFile image, Model model){
//        if (image.isEmpty()) {
//            System.out.println("文件为空空");
//        }
        String fileName = image.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D://question//pic"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            image.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "//question//pic//" + fileName;
        model.addAttribute("filename", filename);
        return new JsonResult<>("10000",null);


    }
    @RequestMapping ("/search")
    public JsonResult<List<String>>search(@RequestParam("pattern")String pattern){
        return problemService.search(pattern);
    }


}
