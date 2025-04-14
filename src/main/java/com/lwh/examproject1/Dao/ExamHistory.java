package com.lwh.examproject1.Dao;

import java.util.Date;

public class ExamHistory {
    private int id; // 主键ID
    private String studentId; // 学生ID
    private int score; // 考试分数
    private Date examTime; // 考试时间

    public ExamHistory(int id, String studentId, int score, Date examTime) {
        this.id = id;
        this.studentId = studentId;
        this.score = score;
        this.examTime = examTime;
    }

    @Override
    public String toString() {
        return "ExamHistory{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", score=" + score +
                ", examTime=" + examTime +
                '}';
    }

    public ExamHistory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }
}
