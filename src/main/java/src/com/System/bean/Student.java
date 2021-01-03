package src.com.System.bean;

public class Student {
    private Integer studentid;
    private String sname;
    private String sex;
    private Integer sage;
    private String classname;
    private String phone;
    private String email;
    private String stupwd;
    private String remark;

    public Student() {
        super();
    }
    public Student(String email, String stupwd) {
        super();
        this.email = email;
        this.stupwd = stupwd;
    }

    public Student(Integer studentid, String sname, String sex, Integer sage, String classname, String phone, String email, String stupwd, String remark) {
        this.studentid = studentid;
        this.sname = sname;
        this.sex = sex;
        this.sage = sage;
        this.classname = classname;
        this.phone = phone;
        this.email = email;
        this.stupwd = stupwd;
        this.remark = remark;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
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

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStupwd() {
        return stupwd;
    }

    public void setStupwd(String stupwd) {
        this.stupwd = stupwd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentid +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", sage=" + sage +
                ", classname='" + classname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", stupwd='" + stupwd + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}

