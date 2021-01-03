package src.com.System.bean;

import org.omg.PortableInterceptor.INACTIVE;

public class Course {
    private Integer courseid;
    private String cname;
    private String tname;
    private String departname;

    public Course() {
    }

    public Course(Integer courseid, String cname, String tname, String departname) {
        this.courseid = courseid;
        this.cname = cname;
        this.tname = tname;
        this.departname = departname;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }
    @Override
    public String toString() {
        return "Course{" +
                "courseid='" + courseid + '\'' +
                ", cname='" + cname + '\'' +
                ", tname='" + tname + '\'' +
                ", departname='" + departname + '\'' +
                '}';
    }
}
