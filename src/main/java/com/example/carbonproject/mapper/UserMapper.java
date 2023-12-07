package com.example.carbonproject.mapper;

import com.example.carbonproject.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getAllUserInfo();

    User getUserInfoByEmail(String email);

    void insertUserInfo(User user);

    void deleteUserInfoByEmail(String email);

    void updateUserInfoByEmail(User user);

    void updateUserEmail(String oldEmail, String newEmail);

    int countByEmail(String email);
}
