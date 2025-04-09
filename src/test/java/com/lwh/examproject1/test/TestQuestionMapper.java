package com.lwh.examproject1.test;

import com.lwh.examproject1.Dao.ChoiceQuestion;
import com.lwh.examproject1.Dao.FillQuestion;
import com.lwh.examproject1.Mapper.ChoiceQuestionMapper;
import com.lwh.examproject1.Mapper.FillQuestionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestQuestionMapper {
    @Autowired
    private FillQuestionMapper questionMapper;
    @Autowired
    private ChoiceQuestionMapper choiceQuestionMapper;

    @Test
    public void selectall() {
        System.out.println(choiceQuestionMapper.selectChoiceQuestionByCid(1));
        System.out.println(questionMapper.selectFillQuestionByFid(1));
        System.out.println(questionMapper.selectFillQuestionAll());
        System.out.println(choiceQuestionMapper.selectAllChoiceQuestions());
    }
    @Test
    public void fillinsert() {
        FillQuestion fillQuestion = new FillQuestion();
        fillQuestion.setFid(12);
        fillQuestion.setFquestion("1+1=?");
        fillQuestion.setFanswer("2");
        questionMapper.insertFillQuestion(fillQuestion);
        System.out.println(questionMapper.selectFillQuestionByFid(12));
    }
    @Test
    public void fillupdate() {
        FillQuestion fillQuestion = new FillQuestion();
        fillQuestion.setFid(12);
        fillQuestion.setFquestion("1+2=?");
        fillQuestion.setFanswer("3");
        questionMapper.updateFillQuestion(fillQuestion);
        System.out.println(questionMapper.selectFillQuestionByFid(12));
    }
    @Test
    public void filldelete() {
        System.out.println(questionMapper.selectFillQuestionAll());
        questionMapper.deleteFillQuestion(12);
        System.out.println(questionMapper.selectFillQuestionAll());
    }
    @Test
    public void choiceinsert() {
        ChoiceQuestion choiceQuestion = new ChoiceQuestion();
        choiceQuestion.setCid(12);
        choiceQuestion.setCquestion("1+1=?");
        choiceQuestion.setCchoiceA("2");
        choiceQuestion.setCchoiceB("3");
        choiceQuestion.setCchoiceC("4");
        choiceQuestion.setCchoiceD("5");
        choiceQuestion.setCanswer("A");
        choiceQuestionMapper.insertChoiceQuestion(choiceQuestion);
        System.out.println(choiceQuestionMapper.selectChoiceQuestionByCid(12));
    }
    @Test
    public void choiceupdate() {
        ChoiceQuestion choiceQuestion = new ChoiceQuestion();
        choiceQuestion.setCid(12);
        choiceQuestion.setCquestion("1+2=?");
        choiceQuestion.setCchoiceA("1");
        choiceQuestion.setCchoiceB("3");
        choiceQuestion.setCchoiceC("5");
        choiceQuestion.setCchoiceD("6");
        choiceQuestion.setCanswer("B");
        choiceQuestionMapper.updateChoiceQuestion(choiceQuestion);
        System.out.println(choiceQuestionMapper.selectChoiceQuestionByCid(12));
    }
    @Test
    public void choicedelete() {
        System.out.println(choiceQuestionMapper.selectAllChoiceQuestions());
        choiceQuestionMapper.deleteChoiceQuestion(12);
        System.out.println(choiceQuestionMapper.selectAllChoiceQuestions());
    }
}
