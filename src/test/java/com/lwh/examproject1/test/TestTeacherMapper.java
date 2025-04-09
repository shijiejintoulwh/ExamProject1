package com.lwh.examproject1.test;

import com.lwh.examproject1.Dao.Teacher;
import com.lwh.examproject1.Mapper.TeacherMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestTeacherMapper {
    @Autowired
    private TeacherMapper teacherMapper;
    @Test
    public void test1() {
        System.out.println(teacherMapper.selectTeacherAll());
    }
    @Test
    public void add() {
        test1();
       teacherMapper.insertTeacher(new Teacher("10001","李老师","女","12345678901","123456","教授","12345678901"));
        test1();
    }
    @Test
    public void update() {
        test1();
        teacherMapper.updateTeacher(new Teacher("10001","修改","女","12345678901","123456","教授","12345678901"));
        test1();
    }
    @Test
    public void selectbyid() {
        System.out.println(teacherMapper.selectTeacherByTid("10001"));
    }

}
