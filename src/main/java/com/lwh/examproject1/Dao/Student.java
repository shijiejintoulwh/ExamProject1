package com.lwh.examproject1.Dao;

/*学生类*/
public class Student {
    private String sid;//考生登录id
    private String sname;//考生姓名
    private String sex;//性别
    private String cardnumber;//身份证号码
    private String pwd;//密码
    private String department;//系别
    private String phone;//电话
    public Student() {
    }

    public Student(String sid, String sname, String sex, String cardnumber, String pwd, String department, String phone) {
        this.sid = sid;
        this.sname = sname;
        this.sex = sex;
        this.cardnumber = cardnumber;
        this.pwd = pwd;
        this.department = department;
        this.phone = phone;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", cardnumber='" + cardnumber + '\'' +
                ", pwd='" + pwd + '\'' +
                ", department='" + department + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
