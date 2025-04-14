package com.lwh.examproject1.Controller;

import com.lwh.examproject1.Dao.FillQuestion;
import com.lwh.examproject1.Service.FillQuestionService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController    // 声明为REST控制器
@RequestMapping("/api/fill") // 基础路径
@CrossOrigin(origins = "*") // 允许跨域访问
public class FillQuestionController1 {
    // 自动注入业务逻辑层组件
    @Autowired
    private FillQuestionService1 questionService;

    // 获取全部填空题
    @GetMapping("/list")
    public List<FillQuestion> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    //添加填空题
    @PostMapping("/add")
    public void addQuestion(@RequestBody FillQuestion question) {
        questionService.addQuestion(question);
    }

    // 更新填空题（带异常处理）
    @PutMapping("/{fid}")
    public ResponseEntity<?> updateQuestion(@PathVariable int fid, @RequestBody FillQuestion question) {
        try {
            question.setFid(fid); // 必须设置路径参数
            questionService.updateQuestion(question);
            // 返回成功响应（包含消息）
            return ResponseEntity.ok(Collections.singletonMap("message", "更新成功"));
        } catch (Exception e) {
            // 捕获所有异常，返回服务器错误状态码
            return ResponseEntity.status(500)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    // 查询单个填空题
    @GetMapping("/{fid}")
    public ResponseEntity<?> getQuestionById(@PathVariable int fid) {
        try {
            // 返回200 OK + 查询结果
            return ResponseEntity.ok(questionService.getQuestionById(fid));
        } catch (Exception e) {
            // 捕获所有异常，返回服务器错误状态码
            return ResponseEntity.status(500)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    //删除填空题
    @DeleteMapping("/{fid}")
    public void deleteQuestion(@PathVariable int fid) {
        questionService.deleteQuestion(fid);
    }
}