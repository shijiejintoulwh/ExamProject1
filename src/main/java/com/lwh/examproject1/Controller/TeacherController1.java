package com.lwh.examproject1.Controller;

import com.lwh.examproject1.Dao.Teacher;
import com.lwh.examproject1.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController1 {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/list")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        // 调用Service层获取教师列表
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody Teacher teacher) {
        try {
            teacherService.addTeacher(teacher);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // 处理异常，返回错误信息
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable String id, @RequestBody Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable String id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable String id) {
        // 调用Service层获取教师信息
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }
}
