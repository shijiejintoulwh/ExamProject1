package com.lwh.examproject1.Service;

import com.lwh.examproject1.Dao.Administrarator;
import com.lwh.examproject1.Dao.Student;
import com.lwh.examproject1.Dao.Teacher;
import com.lwh.examproject1.Mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;

    public Student Stulogin(String sid, String pwd) {
       return loginMapper.selectStudentBySidpwd(sid,pwd);
    }
    public Teacher selteacher(String tid, String pwd) {
        return loginMapper.selteacher(tid,pwd);
    }
    public Administrarator selectAdministrarator(String aid, String pwd) {
        return loginMapper.selectAdministrarator(aid,pwd);
    }

}
