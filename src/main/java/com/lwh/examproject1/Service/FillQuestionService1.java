package com.lwh.examproject1.Service;

import com.lwh.examproject1.Dao.FillQuestion;
import com.lwh.examproject1.Mapper.FillQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FillQuestionService1 {
    @Autowired
    private FillQuestionMapper questionMapper;
    public List<FillQuestion> getAllQuestions() {
        return questionMapper.selectFillQuestionAll();
    }

    public void addQuestion(FillQuestion question) {
      questionMapper.insertFillQuestion(question);
    }

    public void updateQuestion(FillQuestion question) {
        questionMapper.updateFillQuestion(question);
    }

    public void deleteQuestion(int fid) {
       questionMapper.deleteFillQuestion(fid);
    }
    public FillQuestion getQuestionById(int fid) {
        return questionMapper.selectFillQuestionByFid(fid);
    }
// 在现有代码中添加
public List<FillQuestion> getRandomQuestions(int count) {
    return questionMapper.selectRandomFillQuestions(count);
}

// 保持其他已有方法不变

}
