package com.lwh.examproject1.Dao;

/*填空题类*/
public class FillQuestion {
    private int fid;//题目编号
    private String fquestion;//题目
    private String fanswer;//答案

    public FillQuestion(int fid, String fquestion, String fanswer) {
        this.fid = fid;
        this.fquestion = fquestion;
        this.fanswer = fanswer;
    }

    public FillQuestion() {
    }

    public FillQuestion(String fquestion, String fanswer) {
        this.fquestion = fquestion;
        this.fanswer = fanswer;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFquestion() {
        return fquestion;
    }

    public void setFquestion(String fquestion) {
        this.fquestion = fquestion;
    }

    public String getFanswer() {
        return fanswer;
    }

    public void setFanswer(String fanswer) {
        this.fanswer = fanswer;
    }

    @Override
    public String toString() {
        return "FillQuestion{" +
                "fid=" + fid +
                ", fquestion='" + fquestion + '\'' +
                ", fanswer='" + fanswer + '\'' +
                '}';
    }
}

