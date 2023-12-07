package com.example.carbonproject.service;

import com.example.carbonproject.controller.UserController;
import com.example.carbonproject.entity.User;
import com.example.carbonproject.mapper.UserMapper;
import com.example.carbonproject.utils.CookieUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final CookieUtils cookieUtils;

    public UserService(UserMapper userMapper, CookieUtils cookieUtils) {
        this.userMapper = userMapper;
        this.cookieUtils = cookieUtils;
    }

    /**
     * 检查系统中是否存在某个电子邮件。
     *
     * @param email 要检查的电子邮件
     * @return 如果电子邮件存在则返回true，否则返回false
     */
    public boolean emailExist(String email) {
        return userMapper.countByEmail(email) > 0;
    }

    /**
     * 获取所有用户信息。
     *
     * @return 包含所有用户信息的User对象列表
     */
    public List<User> getAllUserInfo() {
        return userMapper.getAllUserInfo();
    }

    /**
     * 根据邮箱获取用户信息。
     *
     * @param email 用户的邮箱
     * @return 包含用户信息的User对象
     */
    public User getUserInfoByEmail(String email) {
        return userMapper.getUserInfoByEmail(email);
    }

    /**
     * 插入用户信息。
     *
     * @param user 要插入的用户信息
     */
    public void insertUserInfo(User user) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        user.setCreateTime(timestamp);
        userMapper.insertUserInfo(user);
    }

    /**
     * 根据邮箱删除用户信息
     *
     * @param email 用户邮箱
     */
    public void deleteUserInfoByEmail(String email) {
        userMapper.deleteUserInfoByEmail(email);
    }

    /**
     * 根据邮箱修改用户信息
     *
     * @param user 用户信息
     */
    public void updateUserInfoByEmail(User user) {
        userMapper.updateUserInfoByEmail(user);
    }

    /**
     * 更新用户邮箱
     *
     * @param oldEmail 旧邮箱
     * @param newEmail 新邮箱
     */
    public void updateUserEmail(String oldEmail, String newEmail) {
        userMapper.updateUserEmail(oldEmail, newEmail);
    }

    /**
     * 获取请求用户的邮箱
     *
     * @param request http请求
     * @return 邮箱String
     */
    public String getRequestEmail(HttpServletRequest request) {
        return getUserInfoByEmail(cookieUtils.getSubjectFromCookieToken(request)).getEmail();
    }

    /**
     * 判断用户是否为管理员
     *
     * @param request http请求
     * @return boolean结果
     */
    public boolean notAdmin(HttpServletRequest request) {
        String email = cookieUtils.getSubjectFromCookieToken(request);
        User user = getUserInfoByEmail(email);
        return user.getIsAdmin() <= 0;
    }
}
