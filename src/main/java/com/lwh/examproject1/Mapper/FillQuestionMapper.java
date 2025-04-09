package com.lwh.examproject1.Mapper;

import com.lwh.examproject1.Dao.FillQuestion;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FillQuestionMapper {
    @Select("select * from fillquestion")
    List<FillQuestion> selectFillQuestionAll();

    @Select("select * from fillquestion where f_id=#{fid}")
    FillQuestion selectFillQuestionByFid(int fid);

    @Insert("insert into fillquestion(f_question,f_answer) values(#{fquestion},#{fanswer})")
    @Options(useGeneratedKeys = true, keyProperty = "fid")
    void insertFillQuestion(FillQuestion fillQuestion);

    /*  @Update("update fillquestion set f_question=#{fquestion},f_answer=#{fanswer} where f_id=#{fid}")

      void updateFillQuestion(FillQuestion fillQuestion);*/
    @Update("UPDATE fillquestion SET f_question=#{fquestion},f_answer=#{fanswer} WHERE f_id=#{fid}")
    void updateFillQuestion(FillQuestion fillQuestion);


    @Delete("delete from fillquestion where f_id=#{fid}")
    void deleteFillQuestion(int fid);

    @Select("SELECT * FROM fillquestion ORDER BY RAND() LIMIT #{count}")
    List<FillQuestion> selectRandomFillQuestions(int count);


}
