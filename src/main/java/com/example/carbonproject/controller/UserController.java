package com.example.carbonproject.controller;

import com.example.carbonproject.config.JwtConfig;
import com.example.carbonproject.Annotaion.SkipAuth;
import com.example.carbonproject.controller.advice.CustomException;
import com.example.carbonproject.entity.User;
import com.example.carbonproject.entity.response.RespDataBean;
import com.example.carbonproject.entity.response.RespPlainBean;
import com.example.carbonproject.entity.response.RespUserLoginBean;
import com.example.carbonproject.service.UserService;
import com.example.carbonproject.utils.CookieUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final JwtConfig jwtConfig;

    public UserController(UserService userService, JwtConfig jwtConfig, CookieUtils cookieUtils) {
        this.userService = userService;
        this.jwtConfig = jwtConfig;
    }

    /**
     * 更新用户邮箱
     *
     * @param params 参数
     * @return 响应
     */
    @PutMapping("/updateEmail")
    public ResponseEntity<RespPlainBean> updateUserEmail(HttpServletRequest request, @RequestBody HashMap<String, String> params) {
        if (!StringUtils.hasText(params.get("oldEmail")) || !StringUtils.hasText(params.get("newEmail"))) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "参数错误！oldEmail或newEmail为空");
        }
        String oldEmail = params.get("oldEmail");
        String newEmail = params.get("newEmail");
        if (!userService.emailExist(oldEmail)) throw new CustomException(HttpStatus.BAD_REQUEST, "该邮箱不存在！");
        if (userService.emailExist(newEmail)) throw new CustomException(HttpStatus.BAD_REQUEST, "该邮箱已被注册！");
        if (userService.notAdmin(request) && !userService.getRequestEmail(request).equals(oldEmail)) {
            throw new CustomException(HttpStatus.FORBIDDEN, "权限不足！只有管理员可修改其他用户的邮箱");
        }
        userService.updateUserEmail(oldEmail, newEmail);
        return RespPlainBean.success("邮箱更新成功！");
    }

    /**
     * 获取所有用户信息
     *
     * @return 带数据响应体
     */
    @GetMapping("/getAllUserInfo")
    public ResponseEntity<RespDataBean> getAllUserInfo(HttpServletRequest request) {
        if (userService.notAdmin(request))
            throw new CustomException(HttpStatus.FORBIDDEN, "权限不足！只有管理员可获取全部用户！");
        List<User> userList = userService.getAllUserInfo();
        return RespDataBean.success("获取所有用户信息成功！", userList);
    }

    /**
     * 判断邮箱是否存在*
     *
     * @param params 参数
     * @return boolean响应
     */
    @PostMapping("/emailExist")
    public boolean emailExist(@RequestBody HashMap<String, String> params) {
        if (!StringUtils.hasText(params.get("email"))) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "参数错误！email为空");
        }
        String email = params.get("email");
        return userService.emailExist(email);
    }

    /**
     * 登陆接口
     *
     * @param user 用户信息
     * @return 响应
     */
    @PostMapping("/login")
    @SkipAuth
    public ResponseEntity<RespUserLoginBean> login(@RequestBody User user) {
        if (!StringUtils.hasText(user.getEmail()) || !StringUtils.hasText(user.getPassword())) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "参数错误！email或password为空");
        }
        if (!userService.emailExist(user.getEmail())) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "该邮箱不存在，请重新输入!");
        }

        User dateUserInfo = userService.getUserInfoByEmail(user.getEmail());
        if (user.getPassword().equals(dateUserInfo.getPassword())) {
            String token = jwtConfig.createToken(user.getEmail());
            String role = dateUserInfo.getIsAdmin() > 0 ? "管理员" : "用户";
            String msg = String.format("欢迎回来~ %s%s", role, dateUserInfo.getUsername());
            return RespUserLoginBean.success(msg, token, dateUserInfo);
        } else {
            throw new CustomException(HttpStatus.UNAUTHORIZED, "密码错误！请重新输入！");
        }
    }

    /**
     * 通过电子邮件获取用户信息。
     *
     * @param params 一个包含请求参数的HashMap对象，其中"email"键表示用户的电子邮件
     * @return 一个包含RespDataBean对象的ResponseEntity对象，其中包含用户信息和成功消息（如果操作成功）
     * @throws CustomException 如果"email"参数缺失或电子邮件在数据库中不存在
     */
    @PostMapping("/getUserInfoByEmail")
    public ResponseEntity<RespDataBean> getUserInfoByEmail(@RequestBody HashMap<String, String> params) {
        if (!StringUtils.hasText(params.get("email"))) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "参数错误！email为空");
        }
        String email = params.get("email");
        if (!userService.emailExist(email)) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "该邮箱不存在，请重新输入");
        }
        User user = userService.getUserInfoByEmail(email);
        user.setPassword("******");
        return RespDataBean.success("获取用户信息成功！", user);
    }

    /**
     * 注册接口
     *
     * @param user 用户信息
     * @return 响应
     */
    @PostMapping("/register")
    @SkipAuth
    public ResponseEntity<RespPlainBean> register(@RequestBody User user) {
        if (!StringUtils.hasText(user.getEmail()) || !StringUtils.hasText(user.getPassword())) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "参数错误！email或password为空");
        }
        if (!StringUtils.hasText(user.getUsername())) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "参数错误！username不能为空");
        }
        if (userService.emailExist(user.getEmail())) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "该邮箱已被注册，请重新输入！");
        }
        userService.insertUserInfo(user);
        return RespPlainBean.success("注册成功，请登录！");
    }

    /**
     * 根据邮箱修改用户信息
     *
     * @param request http请求
     * @param user    用户信息
     * @return 响应
     */
    @PutMapping("/updateUserInfoByEmail")
    public ResponseEntity<RespPlainBean> updateUserInfoByEmail(HttpServletRequest request, @RequestBody User user) {
        String requestEmail = userService.getRequestEmail(request);
        if (!StringUtils.hasText(user.getEmail())) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "参数错误！email为空");
        }
        if (userService.notAdmin(request) && !user.getEmail().equals(requestEmail)) {
            throw new CustomException(HttpStatus.FORBIDDEN, "权限不足！只有管理员可修改其他用户的信息");
        }
        if (userService.notAdmin(request) && user.getIsAdmin() > 0) {
            user.setIsAdmin(0);
        }
        userService.updateUserInfoByEmail(user);
        return RespPlainBean.success("用户信息更新成功");
    }

    /**
     * 根据邮箱删除用户信息
     *
     * @param request http请求
     * @param params  参数
     * @return 响应
     */
    @DeleteMapping("/deleteUserInfoByEmail")
    public ResponseEntity<RespPlainBean> deleteUserInfoByEmail(HttpServletRequest request, @RequestBody HashMap<String, String> params) {
        String email = params.get("email");
        if (!StringUtils.hasText(params.get("email"))) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "参数错误！email为空");
        }
        if (!userService.emailExist(email)) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "该邮箱不存在，请重新输入");
        }
        if (userService.notAdmin(request) && !params.get("email").equals(userService.getRequestEmail(request))) {
            throw new CustomException(HttpStatus.FORBIDDEN, "权限不足！只有管理员可删除其他用户");
        }
        userService.deleteUserInfoByEmail(params.get("email"));
        return RespPlainBean.success("用户删除成功");
    }

    /**
     * 根据邮箱重置用户密码
     *
     * @param request http请求
     * @param user    用户信息
     * @return 响应
     */
    @PostMapping("/resetUserPasswordByEmail")
    public ResponseEntity<RespPlainBean> resetUserPasswordByEmail(HttpServletRequest request, @RequestBody User user) {
        String email = user.getEmail();
        if (!StringUtils.hasText(email)) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "参数错误！email为空");
        }
        if (!StringUtils.hasText(user.getPassword())) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "参数错误！password为空");
        }
        if (!userService.emailExist(email)) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "该邮箱不存在，请重新输入");
        }
        user.setUsername(null);
        user.setIsAdmin(null);
        userService.updateUserInfoByEmail(user);
        return RespPlainBean.success("密码重置成功！");
    }
}
