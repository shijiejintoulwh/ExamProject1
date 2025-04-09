package com.lwh.examproject1.Dao;
/*管理员类*/
public class Administrarator {
    private String adid;//登录id
    private String aname;//姓名
    private String sex;//性别
    private String cardnumber;//身份证号码
    private String pwd;//密码
    private String phone;//电话

    public Administrarator(String adid, String aname, String sex, String cardnumber, String pwd, String phone) {
        this.adid = adid;
        this.aname = aname;
        this.sex = sex;
        this.cardnumber = cardnumber;
        this.pwd = pwd;
        this.phone = phone;
    }

    public Administrarator() {
    }

    @Override
    public String toString() {
        return "Administrarator{" +
                "adid='" + adid + '\'' +
                ", aname='" + aname + '\'' +
                ", sex='" + sex + '\'' +
                ", cardnumber='" + cardnumber + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getAdid() {
        return adid;
    }

    public void setAdid(String adid) {
        this.adid = adid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
