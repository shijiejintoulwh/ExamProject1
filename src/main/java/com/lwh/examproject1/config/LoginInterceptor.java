package com.lwh.examproject1.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 预处理拦截逻辑 - 检查用户会话状态
     *
     * @param request HTTP请求对象，用于获取会话信息
     * @param response HTTP响应对象，用于发送错误响应
     * @param handler 被拦截的处理器对象
     * @return boolean 是否允许继续流程：
     *         true-继续执行后续处理链，false-终止请求处理
     * @throws Exception 可能抛出的异常
     *
     * 实现逻辑：
     * 1. 检查会话中是否存在学生/教师/管理员身份标识
     * 2. 当所有身份标识缺失时，返回401未授权状态
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 会话身份验证逻辑
        HttpSession session = request.getSession();
        if (session.getAttribute("student") == null &&
                session.getAttribute("teacher") == null &&
                session.getAttribute("admin") == null) {
            // 未登录用户拦截处理：发送401状态码和错误提示
            response.sendError(401, "未授权访问");
            return false;
        }
        return true;
    }
}