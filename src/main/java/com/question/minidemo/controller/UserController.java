package com.question.minidemo.controller;

import com.question.minidemo.dto.User;
import com.question.minidemo.service.UserService;
import com.question.minidemo.utils.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService service;

    @RequestMapping ("/login")
    public JsonResult<User> login(@RequestParam("email")String email,
                      @RequestParam("password")String password){
        return service.login(email,password);
    }
    //后面可能需要加如邮箱验证的功能
    @RequestMapping("/register")
    public JsonResult<User> register( @RequestParam("email")String email,
                                      @RequestParam("password")String password,
                                      @RequestParam("uid")String uid
//                                      @RequestParam("name")String name,
//                                      @RequestParam("gender")String gender,
//                                      @RequestParam("birth")String birth,
//                                      @RequestParam("city")String city
    ){
        return service.addUser(email,password,uid);
    }
    @RequestMapping("/updateInfo")
    public JsonResult<User> updateInfo(@RequestParam("uid")String id,
                                       @RequestParam("name")String name,
                                       @RequestParam("gender")String gender,
                                       @RequestParam("birth")String birth,
                                       @RequestParam("city")String city){
        return service.updateUser(name,gender,city,birth,id);
    }
    @RequestMapping("/queryInfo")
    public JsonResult<User> queryInfo(@RequestParam("uid")String id){
        return service.getUserByID(id);
    }



}
