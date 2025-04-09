package com.lwh.examproject1.Service;

import com.lwh.examproject1.Dao.Student;
import com.lwh.examproject1.Mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> getAllStudents() {
        return studentMapper.selsectStudentAll();
    }

    public void addStudent(Student student) {
        if (studentMapper.selectStudentBySid(student.getSid()) != null) {
            throw new RuntimeException("学生已存在");
        }
        studentMapper.insertStudent(student);
    }

    public void updateStudent(Student student) {
        if (studentMapper.selectStudentBySid(student.getSid()) == null) {
            throw new RuntimeException("学生不存在");
        }
        studentMapper.updateStudent(student);
    }

    public void deleteStudent(String sid) {
        studentMapper.deleteStudent(sid);
    }

    public Student getStudentById(String sid) {
        return studentMapper.selectStudentBySid(sid);
    }
}
