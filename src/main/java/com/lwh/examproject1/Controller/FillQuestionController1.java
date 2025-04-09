package com.lwh.examproject1.Controller;

import com.lwh.examproject1.Dao.FillQuestion;
import com.lwh.examproject1.Service.FillQuestionService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

// FillQuestionController1.java
@RestController
@RequestMapping("/api/fill")
@CrossOrigin(origins = "*")
public class FillQuestionController1 {
    @Autowired
    private FillQuestionService1 questionService;

    @GetMapping("/list")
    public List<FillQuestion> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @PostMapping("/add")
    public void addQuestion(@RequestBody FillQuestion question) {
        questionService.addQuestion(question);
    }

    @PutMapping("/{fid}")
    public ResponseEntity<?> updateQuestion(@PathVariable int fid, @RequestBody FillQuestion question) {
        try {
            question.setFid(fid); // 必须设置路径参数
            questionService.updateQuestion(question);
            return ResponseEntity.ok(Collections.singletonMap("message", "更新成功"));
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }
    @GetMapping("/{fid}")
    public ResponseEntity<?> getQuestionById(@PathVariable int fid) {
        try {
            return ResponseEntity.ok(questionService.getQuestionById(fid));
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }


    @DeleteMapping("/{fid}")
    public void deleteQuestion(@PathVariable int fid) {
        questionService.deleteQuestion(fid);
    }
}