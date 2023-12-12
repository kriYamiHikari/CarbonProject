package com.example.carbonproject.service;

import com.example.carbonproject.controller.UserController;
import com.example.carbonproject.controller.advice.CustomException;
import com.example.carbonproject.entity.User;
import com.example.carbonproject.mapper.UserMapper;
import com.example.carbonproject.utils.CookieUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final CookieUtils cookieUtils;

    public UserService(UserMapper userMapper, CookieUtils cookieUtils) {
        this.userMapper = userMapper;
        this.cookieUtils = cookieUtils;
    }

    public String getUserAvatarByEmail(String email) {
        return userMapper.getUserAvatarByEmail(email);
    }

    public void updateUserAvatarByEmail(MultipartFile file, String email) {
        User dataUserinfo = getUserInfoByEmail(email);

        String originalFilename = file.getOriginalFilename();
        String fileSuffix = originalFilename != null ? originalFilename.substring(originalFilename.lastIndexOf(".") + 1) : null;

        String projectPath = System.getProperty("user.dir");
        String avatarPath = projectPath + "\\files\\avatars";

        if (StringUtils.hasText(dataUserinfo.getAvatar())) {
            File deleteFile = new File(avatarPath + "\\" + dataUserinfo.getAvatar());
            boolean deleted = deleteFile.delete();
        }

        String imgFileName = UUID.randomUUID() + "." + fileSuffix;
        String savePath = avatarPath + "\\" + imgFileName;
        File saveFile = new File(savePath);
        if (!saveFile.getParentFile().exists()) {
            boolean created = saveFile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(saveFile);
            User user = new User();
            user.setEmail(email);
            user.setAvatar(imgFileName);
            userMapper.updateUserInfoByEmail(user);
        } catch (IOException e) {
            throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, "上传头像失败");
        }
    }

    public void downloadUserAvatar(String filename, HttpServletResponse response) {
        String filePath = System.getProperty("user.dir") + "\\files\\avatars\\" + filename;
        File file = new File(filePath);
        if (file.exists()) {
            response.setContentType("image/jpeg");
            try {
                byte[] fileData = Files.readAllBytes(Paths.get(filePath));
                response.getOutputStream().write(fileData);
                response.getOutputStream().flush();
                response.getOutputStream().close();
            } catch (IOException e) {
                throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, "下载头像失败");
            }
        }

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
        if (!emailExist(email)) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "该邮箱不存在，请重新输入");
        }
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
        if (user.getIsAdmin() == null) user.setIsAdmin(0);
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
