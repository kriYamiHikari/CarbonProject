package com.example.carbonproject.controller;

import com.example.carbonproject.entity.User;
import com.example.carbonproject.entity.response.RespDataBean;
import com.example.carbonproject.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("getUserList")
    public RespDataBean getUserList(@CookieValue(name = "token", required = false) String token) {
        List<User> userList = userService.getUserList();
        return RespDataBean.success("获取成功 " + token, userList.size(), userList);
    }

    @PostMapping("postUserList")
    public RespDataBean postUserList(@CookieValue(name = "token", required = false) String token) {
        List<User> userList = userService.getUserList();
        return RespDataBean.success("获取成功 " + token, userList.size(), userList);
    }
}