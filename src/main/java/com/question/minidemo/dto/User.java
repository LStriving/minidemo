package com.question.minidemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String uid;
    private String name;
    private String password;
    private String profile;//头像的url
    private String gender;
    private int bill=0;
    private int level=0;
    private String backgroundImg;//背景图片的url
    private String email;
    private String birth;
    private String city;
    public void setBasicInfo(String uid,String email,String password,String name,String gender,String birth,String city){
       setUid(uid);
       setEmail(email);
       setPassword(password);
       setName(name);
       setGender(gender);
       setBirth(birth);
       setCity(city);
    }

}
