public class Teacher {

    private String title; // 添加职称字段

    public Teacher() {
    }

    public Teacher(String tid, String tname, String sex, String cardnumber, String pwd, String title, String phone) {
        this.tid = tid;
        this.tname = tname;
        this.sex = sex;
        this.cardnumber = cardnumber;
        this.pwd = pwd;
        this.title = title; // 初始化职称字段
        this.phone = phone;
    }

    // 添加职称的getter和setter方法
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", sex='" + sex + '\'' +
                ", cardnumber='" + cardnumber + '\'' +
                ", pwd='" + pwd + '\'' +
                ", title='" + title + '\'' + // 在toString中添加职称字段
                ", phone='" + phone + '\'' +
                '}';
    }
}