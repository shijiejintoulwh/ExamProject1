package com.lwh.examproject1.Service;

import com.lwh.examproject1.Dao.Teacher;
import com.lwh.examproject1.Mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService1 {
    @Autowired
    private TeacherMapper teacherMapper;

    public Teacher getTeacherById(String tid) {
        return teacherMapper.selectTeacherByTid(tid);
    }

    public void updateTeacher(Teacher teacher) {

         teacherMapper.updateTeacher(teacher);
    }

}
