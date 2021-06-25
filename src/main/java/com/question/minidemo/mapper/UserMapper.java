package com.question.minidemo.mapper;

import com.question.minidemo.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserAll();
    User queryUserByMail(String email);
    User queryUserById(String id);
    void insertUser(User user);
    void updateUser(User user);
}
