package com.example.carbonproject.config;

import com.example.carbonproject.annotation.AdminOnly;
import com.example.carbonproject.annotation.SkipAuth;
import com.example.carbonproject.controller.advice.CustomException;
import com.example.carbonproject.service.UserService;
import com.example.carbonproject.utils.CookieUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    private final JwtConfig jwtConfig;
    private final CookieUtils cookieUtils;
    private final UserService userService;

    public TokenInterceptor(JwtConfig jwtConfig, CookieUtils cookieUtils, UserService userService) {
        this.jwtConfig = jwtConfig;
        this.cookieUtils = cookieUtils;
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpStatus.OK.value());
//            response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
            response.setHeader("Access-Control-Allow-Headers", "content-type");
//            response.setHeader("access-control-allow-credentials", "true");
        }

        if (handler instanceof HandlerMethod) {
            SkipAuth skipAuth = ((HandlerMethod) handler).getMethodAnnotation(SkipAuth.class);
            AdminOnly adminOnly = ((HandlerMethod) handler).getMethodAnnotation(AdminOnly.class);
            // 如果是跳过权限控制的接口，直接放过
            if (skipAuth != null) {
                return true;
            }
            // 如果是管理员接口，判断是否有管理员权限
            if (adminOnly != null) {
                if (userService.notAdmin(request)) {
                    throw new CustomException(HttpStatus.FORBIDDEN, "权限不足，该接口仅限管理员使用！");
                }
            }
        }

        String token = cookieUtils.getCookieValue(request, jwtConfig.getHeader());
        if (token != null) {
            try {
                jwtConfig.getClaimByToken(token);
            } catch (Exception e) {
                throw new CustomException(HttpStatus.UNAUTHORIZED, "登录已过期，请重新登录");
//                sendError(response, "登录已过期，请重新登录");
//                return false;
            }
        } else {
            throw new CustomException(HttpStatus.UNAUTHORIZED, "未登录，请先登陆");
//            sendError(response, "未登录，请先登陆！");
//            return false;
        }

        return true;
    }

//    private void sendError(HttpServletResponse response,String msg) throws IOException {
//        ResponseEntity<RespPlainBean> responseEntity = RespPlainBean.error(HttpStatus.UNAUTHORIZED, msg, null);
//        response.setStatus(responseEntity.getStatusCodeValue());
//        response.setContentType("application/json;charset=UTF-8");
//        ObjectMapper objectMapper = new ObjectMapper();
//        response.getWriter().write(objectMapper.writeValueAsString(responseEntity.getBody()));
//    }

}
