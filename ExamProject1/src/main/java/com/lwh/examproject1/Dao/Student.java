public class Student {

    private String department; // 添加系别字段

    public Student() {
    }

    public Student(String sid, String sname, String sex, String cardnumber, String pwd, String department, String phone) {
        this.sid = sid;
        this.sname = sname;
        this.sex = sex;
        this.cardnumber = cardnumber;
        this.pwd = pwd;
        this.department = department; // 初始化系别字段
        this.phone = phone;
    }

    // 添加系别的getter和setter方法
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", cardnumber='" + cardnumber + '\'' +
                ", pwd='" + pwd + '\'' +
                ", department='" + department + '\'' + // 在toString中添加系别字段
                ", phone='" + phone + '\'' +
                '}';
    }
}