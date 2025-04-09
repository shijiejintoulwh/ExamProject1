package com.lwh.examproject1.Dao;

/*选择题类*/
public class ChoiceQuestion {
    private int cid;//题目编号
    private String cquestion;//问题
    private String cchoiceA;//选项a
   private String cchoiceB;//选项b
    private String cchoiceC;//选项c
    private String cchoiceD;//选项d
    private String canswer;//答案选项

    public ChoiceQuestion(String cquestion, String cchoiceA, String cchoiceB, String cchoiceC, String cchoiceD, String canswer) {
        this.cquestion = cquestion;
        this.cchoiceA = cchoiceA;
        this.cchoiceB = cchoiceB;
        this.cchoiceC = cchoiceC;
        this.cchoiceD = cchoiceD;
        this.canswer = canswer;
    }

    public ChoiceQuestion(int cid, String cquestion, String cchoiceA, String cchoiceB, String cchoiceC, String cchoiceD, String canswer) {
        this.cid = cid;
        this.cquestion = cquestion;
        this.cchoiceA = cchoiceA;
        this.cchoiceB = cchoiceB;
        this.cchoiceC = cchoiceC;
        this.cchoiceD = cchoiceD;
        this.canswer = canswer;
    }

    public ChoiceQuestion() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCquestion() {
        return cquestion;
    }

    public void setCquestion(String cquestion) {
        this.cquestion = cquestion;
    }

    public String getCchoiceA() {
        return cchoiceA;
    }

    public void setCchoiceA(String cchoiceA) {
        this.cchoiceA = cchoiceA;
    }

    public String getCchoiceB() {
        return cchoiceB;
    }

    public void setCchoiceB(String cchoiceB) {
        this.cchoiceB = cchoiceB;
    }

    public String getCchoiceC() {
        return cchoiceC;
    }

    public void setCchoiceC(String cchoiceC) {
        this.cchoiceC = cchoiceC;
    }

    public String getCchoiceD() {
        return cchoiceD;
    }

    public void setCchoiceD(String cchoiceD) {
        this.cchoiceD = cchoiceD;
    }

    public String getCanswer() {
        return canswer;
    }

    public void setCanswer(String canswer) {
        this.canswer = canswer;
    }

    @Override
    public String toString() {
        return "choiceQuestion{" +
                "cid=" + cid +
                ", cquestion='" + cquestion + '\'' +
                ", cchoiceA='" + cchoiceA + '\'' +
                ", cchoiceB='" + cchoiceB + '\'' +
                ", cchoiceC='" + cchoiceC + '\'' +
                ", cchoiceD='" + cchoiceD + '\'' +
                ", canswer='" + canswer + '\'' +
                '}';
    }
}
