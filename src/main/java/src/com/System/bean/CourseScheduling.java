package src.com.System.bean;

public class CourseScheduling {
    private Integer lessid;
    private String weeks;
    private String howless;
    private String classname;
    private String cousename;
    private String roomname;
    private String tname;
    private String grade;

    public CourseScheduling() {
    }

    public CourseScheduling(Integer lessid, String weeks, String howless, String classname, String cousename, String roomname, String tname, String grade) {
        this.lessid = lessid;
        this.weeks = weeks;
        this.howless = howless;
        this.classname = classname;
        this.cousename = cousename;
        this.roomname = roomname;
        this.tname = tname;
        this.grade = grade;
    }

    public Integer getLessid() {
        return lessid;
    }

    public void setLessid(Integer lessid) {
        this.lessid = lessid;
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }

    public String getHowless() {
        return howless;
    }

    public void setHowless(String howless) {
        this.howless = howless;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getCousename() {
        return cousename;
    }

    public void setCousename(String cousename) {
        this.cousename = cousename;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "CourseScheduling{" +
                "lessid=" + lessid +
                ", weeks='" + weeks + '\'' +
                ", howless='" + howless + '\'' +
                ", classname='" + classname + '\'' +
                ", cousename='" + cousename + '\'' +
                ", roomname='" + roomname + '\'' +
                ", tname='" + tname + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
