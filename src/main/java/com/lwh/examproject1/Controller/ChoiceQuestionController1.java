package com.lwh.examproject1.Controller;

import com.lwh.examproject1.Dao.ChoiceQuestion;
import com.lwh.examproject1.Service.ChoiceQuestionService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/choice")
@CrossOrigin(origins = "*")
public class ChoiceQuestionController1 {
    @Autowired
    private ChoiceQuestionService1 questionService;

    @GetMapping("/list")
    public List<ChoiceQuestion> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addQuestion(@RequestBody ChoiceQuestion question) {
        try {
            System.out.println("接收到的请求数据：" + question); // 添加日志
            questionService.addQuestion(question);
            System.out.println("插入成功，生成的主键：" + question.getCid()); // 验证主键回填
            return ResponseEntity.ok(Collections.singletonMap("message", "添加成功"));
        } catch (Exception e) {
            e.printStackTrace(); // 打印完整堆栈信息
            return ResponseEntity.status(500)
                    .body(Collections.singletonMap("error", "添加失败: " + e.getMessage()));
        }
    }

    @PutMapping("/{cid}")
    public ResponseEntity<?> updateQuestion(
            @PathVariable int cid,
            @RequestBody ChoiceQuestion question) {
        question.setCid(cid);
        questionService.updateQuestion(question);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{cid}")
    public void deleteQuestion(@PathVariable int cid) {

        questionService.deleteQuestion(cid);
    }

    @GetMapping("/{cid}")
    public ResponseEntity<?> getQuestionById(@PathVariable int cid) {
        try {
            return ResponseEntity.ok(questionService.getQuestionById(cid));
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }

}