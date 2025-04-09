package com.lwh.examproject1.Service;

import com.lwh.examproject1.Dao.ChoiceQuestion;
import com.lwh.examproject1.Mapper.ChoiceQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChoiceQuestionService1 {
    @Autowired
    private ChoiceQuestionMapper questionMapper;

    public List<ChoiceQuestion> getAllQuestions() {
        return questionMapper.selectAllChoiceQuestions();
    }

    public void addQuestion(ChoiceQuestion question) {
         questionMapper.insertChoiceQuestion(question);
    }

    public void updateQuestion(ChoiceQuestion question) {
         questionMapper.updateChoiceQuestion(question);
    }

    public void deleteQuestion(int cid) {
         questionMapper.deleteChoiceQuestion(cid);
    }
    public ChoiceQuestion getQuestionById(int cid) {
        return questionMapper.selectChoiceQuestionByCid(cid);
    }
    public List<ChoiceQuestion> getRandomQuestions(int count) {
        return questionMapper.selectRandomChoiceQuestions(count);
    }


}
