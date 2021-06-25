package com.question.minidemo.service;

import com.question.minidemo.dto.User;
import com.question.minidemo.utils.JsonResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
@Repository
@Service()
public interface UserService {
    JsonResult<User> getUserByID(String id);
    JsonResult<User> addUser(String email,String pwd,String uid);
    JsonResult<User> addUser(String name, String pwd,String id,String email,String gender,String birth,String city);
    JsonResult<User> login(String email, String pwd);
    JsonResult<User> updateUser(String name, String gender, String city, String birth, String id);
    void updateUserBill(String uid,int bill);
}
