package com.lwh.examproject1.Mapper;

import com.lwh.examproject1.Dao.ChoiceQuestion;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChoiceQuestionMapper {

    @Select("select * from choicequestion")
    List<ChoiceQuestion> selectAllChoiceQuestions();

    @Select("select * from choicequestion where c_id=#{cid}")
    ChoiceQuestion selectChoiceQuestionByCid(int cid);

    @Insert("INSERT INTO choicequestion(c_question,c_choiceA,c_choiceB,c_choiceC,c_choiceD,c_answer) " +
            "VALUES(#{cquestion},#{cchoiceA},#{cchoiceB},#{cchoiceC},#{cchoiceD},#{canswer})")
    @Options(useGeneratedKeys = true, keyProperty = "cid", keyColumn = "c_id")
    void insertChoiceQuestion(ChoiceQuestion choiceQuestion);


    @Update("update choicequestion set c_question=#{cquestion},c_choiceA=#{cchoiceA},c_choiceB=#{cchoiceB},c_choiceC=#{cchoiceC},c_choiceD=#{cchoiceD},c_answer=#{canswer} where c_id=#{cid}")
    @Options(useGeneratedKeys = true, keyProperty = "cid")
    void updateChoiceQuestion(ChoiceQuestion choiceQuestion);

    @Delete("delete from choicequestion where c_id=#{cid}")
    void deleteChoiceQuestion(int cid);

    @Select("SELECT * FROM choicequestion ORDER BY RAND() LIMIT #{count}")
    List<ChoiceQuestion> selectRandomChoiceQuestions(int count);


}
