package com.example.carbonproject.service;

import com.example.carbonproject.entity.User;
import com.example.carbonproject.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getUserList() {
        return userMapper.getUserList();
    }
}
