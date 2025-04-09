package com.lwh.examproject1.Service;

import com.lwh.examproject1.Dao.ExamHistory;
import com.lwh.examproject1.Mapper.ExamHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExamHistoryService {
    @Autowired
    private ExamHistoryMapper examHistoryMapper;


    public void saveHistory(String studentId, int score) {
        ExamHistory history = new ExamHistory();
        history.setStudentId(studentId);
        history.setScore(score);
        history.setExamTime(new Date());
        examHistoryMapper.insertHistory(history);
    }

    public List<ExamHistory> getHistoryByStudent(String studentId) {
        return examHistoryMapper.selectByStudentId(studentId);
    }

}
