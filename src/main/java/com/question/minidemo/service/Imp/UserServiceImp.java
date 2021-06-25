package com.question.minidemo.service.Imp;

import com.question.minidemo.dto.User;
import com.question.minidemo.mapper.UserMapper;
import com.question.minidemo.service.UserService;
import com.question.minidemo.utils.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserService")
public class UserServiceImp implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public JsonResult<User> addUser(String name, String pwd,String id,String email,String gender,String birth,String city) {
        User user = new User();
        user.setBasicInfo(id,email,pwd,name,gender,birth,city);
        userMapper.insertUser(user);
        JsonResult<User> json;
        json = userMapper.queryUserById(id) != null
                ?new JsonResult<>("10000",null)
                :new JsonResult<>("20000",null);
        return json;
    }

    @Override
    public JsonResult<User> addUser(String email,String pwd,String uid){
        User user = new User();
        user.setEmail(email);
        user.setPassword(pwd);
        user.setUid(uid);
        userMapper.insertUser(user);
        JsonResult<User> json;
        json = userMapper.queryUserById(uid) != null
                ?new JsonResult<>("10000",null)
                :new JsonResult<>("20000",null);
        return json;
    }
    @Override
    public JsonResult<User> login(String email, String pwd) {
        User user = userMapper.queryUserByMail(email);
        JsonResult<User> json;
        json = user != null
                ?new JsonResult<>("10000",user)
                :new JsonResult<>("20000",null);
        return json;
    }

    @Override
    public JsonResult<User> updateUser(String name, String gender, String city, String birth, String id) {
        User user = userMapper.queryUserById(id);
        user.setName(name);
        user.setBirth(birth);
        user.setCity(city);
        user.setGender(gender);
        userMapper.updateUser(user);
        User userByID = userMapper.queryUserById(id);
        if(userByID.getName().equals(name)&&userByID.getGender().equals(gender)
                &&userByID.getBirth().equals(birth)&&userByID.getCity().equals(city)){
            return new JsonResult<>("10000",null);
        }else return new JsonResult<>("20000",null);
    }

    @Override
    public void updateUserBill(String uid, int bill) {
        User user = userMapper.queryUserById(uid);
        user.setBill(bill);
        userMapper.updateUser(user);
    }

    @Override
    public JsonResult<User> getUserByID(String id) {
        User user = userMapper.queryUserById(id);
        JsonResult<User> json;
        json = user != null
                ?new JsonResult<>("10000",user)
                :new JsonResult<>("20000",null);
        return json;
    }
}
