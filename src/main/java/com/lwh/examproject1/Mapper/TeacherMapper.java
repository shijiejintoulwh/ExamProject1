package com.lwh.examproject1.Mapper;

import com.lwh.examproject1.Dao.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {
    @Select("select * from teacher where t_id=#{tid}")
    Teacher selectTeacherByTid(String tid);

    @Select("select * from teacher")
    List<Teacher> selectTeacherAll();

    @Insert("insert into teacher(t_id,t_name,sex,cardnumber,pwd,title,phone) values(#{tid},#{tname},#{sex},#{cardnumber},#{pwd},#{title},#{phone})")
    void insertTeacher(Teacher teacher);

    @Update("update teacher set t_name=#{tname},sex=#{sex},cardnumber=#{cardnumber},pwd=#{pwd},title=#{title},phone=#{phone} where t_id=#{tid}")
    void updateTeacher(Teacher teacher);

    @Delete("delete from teacher where t_id=#{tid}")
    void deleteTeacher(String tid);

}
