package src.com.System.bean;

public class Teacher {
    private Integer teacherid;
    private String email;
    private String tname;
    private String tsex;
    private String prof;
    private String departname;
    private String phone;
    private String teachpwd;
    private String remark;

    public Teacher() {
        super();
    }

    public Teacher(String teachemail, String teachpwd) {
        super();
        this.email = teachemail;
        this.teachpwd = teachpwd;
    }

    public Teacher(Integer teacherid, String email,String tname, String tsex, String prof, String departname, String phone,String teachpwd, String remark) {
        this.teacherid = teacherid;
        this.email = email;
        this.tname = tname;
        this.tsex = tsex;
        this.prof = prof;
        this.departname = departname;
        this.phone = phone;
        this.teachpwd = teachpwd;
        this.remark = remark;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTeachpwd() {
        return teachpwd;
    }

    public void setTeachpwd(String teachpwd) {
        this.teachpwd = teachpwd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "email='" + email + '\'' +
                ", teacherid=" + teacherid +
                ", tname='" + tname + '\'' +
                ", tsex='" + tsex + '\'' +
                ", prof='" + prof + '\'' +
                ", departname='" + departname + '\'' +
                ", phone='" + phone + '\'' +
                ", teachpwd='" + teachpwd + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}