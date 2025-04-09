package com.lwh.examproject1.test;

import com.lwh.examproject1.Dao.Student;
import com.lwh.examproject1.Mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestStudentMapper {
    @Autowired
    private StudentMapper stum;

    @Test
    public void cy() {
        System.out.println(stum.selectStudentBySid("20180001"));
    }

    @Test
    public void insertstu() {
        Student student = new Student("20180004", "小明", "男", "123456789", "123", "计算机科学与技术", "123456789");
        stum.insertStudent(student);

    }

    @Test
    public void upstu() {
        System.out.println(stum.selectStudentBySid("20180004"));
        Student student = new Student("20180004", "小明", "男", "123456789", "123213", "计算机科学与技术", "48616526");
        stum.updateStudent(student);
        System.out.println(stum.selectStudentBySid("20180004"));
    }

    @Test
    public void delstu() {
        System.out.println(stum.selectStudentBySid("20180004"));
        stum.deleteStudent("20180004");
    }
}
