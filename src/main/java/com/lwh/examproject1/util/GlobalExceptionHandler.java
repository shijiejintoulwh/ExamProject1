package com.lwh.examproject1.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice// 声明为全局控制器异常处理器
public class GlobalExceptionHandler {
    // 捕获所有类型的异常
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception e) {
        // 返回500状态码 + 错误信息
        return ResponseEntity.status(500)
                .body(Collections.singletonMap("error", e.getMessage()));
    }
}
