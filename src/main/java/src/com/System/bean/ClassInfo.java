package src.com.System.bean;

public class ClassInfo {
    private Integer classid;
    private String classname;
    private String profname;
    private String gradename;
    private String departname;
    private Integer coursenum;

    public ClassInfo() {
    }

    public ClassInfo(Integer classid, String classname, String profname, String gradename, String departname, Integer coursenum) {
        this.classid = classid;
        this.classname = classname;
        this.profname = profname;
        this.gradename = gradename;
        this.departname = departname;
        this.coursenum = coursenum;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getProfname() {
        return profname;
    }

    public void setProfname(String profname) {
        this.profname = profname;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }

    public Integer getCoursenum() {
        return coursenum;
    }

    public void setCoursenum(Integer coursenum) {
        this.coursenum = coursenum;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "classid=" + classid +
                ", classname='" + classname + '\'' +
                ", profname='" + profname + '\'' +
                ", gradename='" + gradename + '\'' +
                ", departname='" + departname + '\'' +
                ", coursenum='" + coursenum + '\'' +
                '}';
    }
}
