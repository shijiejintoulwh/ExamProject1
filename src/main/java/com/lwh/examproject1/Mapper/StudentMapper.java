package com.lwh.examproject1.Mapper;

import com.lwh.examproject1.Dao.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from student where s_id=#{sid}")
    Student selectStudentBySid(String sid);

    @Select("select * from student")
    List<Student> selsectStudentAll();

    @Insert("insert into student(s_id,s_name,sex,cardnumber,pwd,department,phone) values(#{sid},#{sname},#{sex},#{cardnumber},#{pwd},#{department},#{phone})")
    void insertStudent(Student student);

    @Update("update student set s_name=#{sname},sex=#{sex},cardnumber=#{cardnumber},pwd=#{pwd},department=#{department},phone=#{phone} where s_id=#{sid}")
    void updateStudent(Student student);

    @Delete("delete from student where s_id=#{sid}")
    void deleteStudent(String sid);
}
