package com.lwh.examproject1.Controller;

import com.lwh.examproject1.Dao.Teacher;
import com.lwh.examproject1.Service.TeacherService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// TeacherController2.java
@RestController
@RequestMapping("/api/teacher")
@CrossOrigin(origins = "*")
public class TeacherController2 {
    @Autowired
    private TeacherService1 teacherService;

    // TeacherController2.java
    @GetMapping("/info")
    public ResponseEntity<?> getTeacherInfo(@RequestParam String tid) {
        Teacher teacher = teacherService.getTeacherById(tid);
        if (teacher == null) {
            return ResponseEntity.status(404).body("教师不存在");
        }
        return ResponseEntity.ok(teacher);
    }
   /* @PutMapping("/info")
    public ResponseEntity<?> updateTeacherInfo(@RequestBody Teacher teacher) {
        // 实现更新教师信息的逻辑
        teacherService.updateTeacher(teacher);
        return ResponseEntity.ok("更新成功");
    }*/
       @PutMapping("/info")
   public ResponseEntity<?> updateTeacherInfo(@RequestBody Teacher teacher) {
       teacherService.updateTeacher(teacher);
       return ResponseEntity.ok(Map.of(
           "status", "success",
           "message", "更新成功",
           "data", teacher
       ));
   }

}
