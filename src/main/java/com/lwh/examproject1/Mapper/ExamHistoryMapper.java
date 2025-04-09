package com.lwh.examproject1.Mapper;

import com.lwh.examproject1.Dao.ExamHistory;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExamHistoryMapper {
    @Insert("INSERT INTO exam_history(student_id, score) VALUES(#{studentId}, #{score})")
    @Options(useGeneratedKeys = true, keyProperty = "id")  // 添加主键回填
    void insertHistory(ExamHistory history);
    @Select("SELECT * FROM exam_history WHERE student_id = #{studentId} ORDER BY exam_time DESC LIMIT 10")
    @Results({
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "examTime", column = "exam_time")
    })
    List<ExamHistory> selectByStudentId(String studentId);

}
