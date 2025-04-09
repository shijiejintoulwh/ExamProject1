package com.lwh.examproject1.Dao;
/*教师类*/
public class Teacher {
    private String tid;//登录id
    private String tname;//教师姓名
    private String sex;//性别
    private String cardnumber;//身份证号码
    private String pwd;//密码
    private String title;//职称
    private String phone;//电话

    public Teacher(String tid, String tname, String sex, String cardnumber, String pwd, String title, String phone) {
        this.tid = tid;
        this.tname = tname;
        this.sex = sex;
        this.cardnumber = cardnumber;
        this.pwd = pwd;
        this.title = title;
        this.phone = phone;
    }

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", sex='" + sex + '\'' +
                ", cardnumber='" + cardnumber + '\'' +
                ", pwd='" + pwd + '\'' +
                ", title='" + title + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
