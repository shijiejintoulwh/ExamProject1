package com.lwh.examproject1.Controller;

import com.lwh.examproject1.Dao.ChoiceQuestion;
import com.lwh.examproject1.Dao.ExamHistory;
import com.lwh.examproject1.Dao.FillQuestion;
import com.lwh.examproject1.Dao.Student;
import com.lwh.examproject1.Service.ChoiceQuestionService1;
import com.lwh.examproject1.Service.ExamHistoryService;
import com.lwh.examproject1.Service.FillQuestionService1;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/exam")
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "*")
public class ExamController1 {
    @Autowired
    private ChoiceQuestionService1 choiceService;

    @Autowired
    private FillQuestionService1 fillService;

    // 获取随机选择题
    @GetMapping("/choice/random")
    public List<ChoiceQuestion> getRandomChoiceQuestions() {
        return choiceService.getRandomQuestions(5);
    }

    // 获取随机填空题
    @GetMapping("/fill/random")
    public List<FillQuestion> getRandomFillQuestions() {
        return fillService.getRandomQuestions(5);
    }

    @Autowired
    private ExamHistoryService examHistoryService;

    // 在现有ExamController中添加
    @PostMapping("/submit")// 处理POST请求，访问路径为/api/exam/submit
    @Transactional  // 添加事务注解，声明事务边界（数据库操作要么全成功，要么全回滚）
    // 接收JSON格式的答案数据，获取HTTP会话
    public ResponseEntity<?> submitExam(@RequestBody Map<String, Object> answers, HttpSession session) {
        // 会话验证：获取登录学生信息
        Student student = (Student) session.getAttribute("student");

        if (student == null) {
            // 返回401未授权状态（包含错误信息）
            return ResponseEntity.status(401).body(Collections.singletonMap("error", "未登录"));
        }

        try {
            // 计算考试成绩（业务逻辑）
            int score = calculateScore(answers);
            // 保存考试记录（数据库操作）
            examHistoryService.saveHistory(student.getSid(), score);
            // 返回成功响应（包含考试成绩）
            return ResponseEntity.ok(Collections.singletonMap("score", score));
        } catch (DataAccessException e) {  // 捕获数据库异常
            // 处理数据库异常（如连接失败、SQL错误等）
            return ResponseEntity.internalServerError()
                    .body(Collections.singletonMap("error", "成绩保存失败"));
        }
    }

    public int calculateScore(Map<String, Object> answers) {
        // 初始化正确计数器
        int correctCount = 0;

        // 修正后的选择题验证
        List<Map<String, Object>> choiceAnswers = (List<Map<String, Object>>) answers.get("choices");
        for (Map<String, Object> answer : choiceAnswers) {
            // 提取题目ID和用户答案
            int cid = (int) answer.get("cid");
            String userAnswer = (String) answer.get("canswer");
            // 通过服务层获取正确答案
            ChoiceQuestion question = choiceService.getQuestionById(cid);
            // 忽略大小写的答案比对
            if (question.getCanswer().equalsIgnoreCase(userAnswer)) {
                correctCount++;
            }
        }

        // 处理填空题部分（逻辑与选择题类似）
        // 从答案数据中获取填空题部分（强制转换为列表）
        List<Map<String, Object>> fillAnswers = (List<Map<String, Object>>) answers.get("fills");
        // 遍历每个填空题答案
        for (Map<String, Object> answer : fillAnswers) {
            // 提取题目ID和用户答案（强制类型转换）
            int fid = (int) answer.get("fid");
            String userAnswer = (String) answer.get("fanswer");
            // 通过服务层获取题目对象
            FillQuestion question = fillService.getQuestionById(fid);
            // 比对正确答案（忽略大小写）
            if (question.getFanswer().equalsIgnoreCase(userAnswer)) {
                correctCount++;// 正确计数器累加
            }
        }
        // 计算总分（每题10分）
        return correctCount * 10;
    }


    @GetMapping("/history")// 处理GET请求，访问路径为/api/exam/history
    public ResponseEntity<List<ExamHistory>> getHistory(HttpSession session) {
        // 从会话中获取学生登录信息
        Student student = (Student) session.getAttribute("student");
        // 身份验证检查
        if (student == null) {
            // 返回401未授权状态码（无响应体）
            return ResponseEntity.status(401).build();
        }
        // 通过服务层获取历史记录
        return ResponseEntity.ok(examHistoryService.getHistoryByStudent(student.getSid()));
    }


}


