package com.lwh.examproject1.Service;

import com.lwh.examproject1.Dao.Teacher;
import com.lwh.examproject1.Mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public List<Teacher> getAllTeachers() {
        return teacherMapper.selectTeacherAll();
    }

    public void addTeacher(Teacher teacher) {
        if (teacherMapper.selectTeacherByTid(teacher.getTid()) != null) {
            throw new RuntimeException("教师已存在");
        }
        teacherMapper.insertTeacher(teacher);
    }

   public void updateTeacher(Teacher teacher) {
    if (teacher == null || teacher.getTid() == null || teacher.getTid().isEmpty()) {
        throw new IllegalArgumentException("教师ID不能为空");
    }

    Teacher existingTeacher = teacherMapper.selectTeacherByTid(teacher.getTid());
    if (existingTeacher == null) {
        throw new TeacherNotFoundException("教师不存在，TID: " + teacher.getTid());
    }

    teacherMapper.updateTeacher(teacher);
}


    public void deleteTeacher(String tid) {
        teacherMapper.deleteTeacher(tid);
    }

    public Teacher getTeacherById(String tid) {
        return teacherMapper.selectTeacherByTid(tid);
    }
    public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(String message) {
        super(message);
    }
}

}
