package com.lwh.examproject1.Mapper;

import com.lwh.examproject1.Dao.Administrarator;
import com.lwh.examproject1.Dao.Student;
import com.lwh.examproject1.Dao.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    @Select("select * from student where s_id=#{sid} and pwd=#{pwd}")
    Student selectStudentBySidpwd(@Param("sid") String id, @Param("pwd") String pwd);
    @Select("select * from teacher where t_id=#{tid} and pwd=#{pwd}")
    Teacher selteacher(@Param("tid") String id, @Param("pwd") String pwd);
    @Select("select * from administrator where ad_id=#{aid} and pwd=#{pwd}")
    Administrarator selectAdministrarator(@Param("aid") String id, @Param("pwd") String pwd);
}
