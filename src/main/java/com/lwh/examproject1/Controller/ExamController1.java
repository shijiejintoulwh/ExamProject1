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
    @PostMapping("/submit")
    @Transactional  // 添加事务注解
    public ResponseEntity<?> submitExam(@RequestBody Map<String, Object> answers, HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        if (student == null) {
            return ResponseEntity.status(401).body(Collections.singletonMap("error", "未登录"));
        }

        try {
            int score = calculateScore(answers);
            examHistoryService.saveHistory(student.getSid(), score);
            return ResponseEntity.ok(Collections.singletonMap("score", score));
        } catch (DataAccessException e) {  // 捕获数据库异常
            return ResponseEntity.internalServerError()
                    .body(Collections.singletonMap("error", "成绩保存失败"));
        }
    }

    public int calculateScore(Map<String, Object> answers) {
        int correctCount = 0;

        // 修正后的选择题验证
        List<Map<String, Object>> choiceAnswers = (List<Map<String, Object>>) answers.get("choices");
        for (Map<String, Object> answer : choiceAnswers) {
            int cid = (int) answer.get("cid");
            String userAnswer = (String) answer.get("canswer");
            ChoiceQuestion question = choiceService.getQuestionById(cid);
            if (question.getCanswer().equalsIgnoreCase(userAnswer)) {
                correctCount++;
            }
        }

        // 修正后的填空题验证
        List<Map<String, Object>> fillAnswers = (List<Map<String, Object>>) answers.get("fills");
        for (Map<String, Object> answer : fillAnswers) {
            int fid = (int) answer.get("fid");
            String userAnswer = (String) answer.get("fanswer");
            FillQuestion question = fillService.getQuestionById(fid);
            if (question.getFanswer().equalsIgnoreCase(userAnswer)) {
                correctCount++;
            }
        }

        return correctCount * 10;
    }


    @GetMapping("/history")
    public ResponseEntity<List<ExamHistory>> getHistory(HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        if (student == null) {
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.ok(examHistoryService.getHistoryByStudent(student.getSid()));
    }


}


