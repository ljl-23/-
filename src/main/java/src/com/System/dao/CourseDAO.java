package src.com.System.dao;

import src.com.System.bean.Course;
import src.com.System.utils.DBUtils;

import java.util.List;

public class CourseDAO {
    //保存课程信息
    public Integer saveCourse(Course course) {
        String sql="insert into tb_course(courseid,cname,tname,departname) values(?,?,?,?)";
        return DBUtils.updateForPrimary(sql,course.getCourseid(),course.getCname(),course.getTname(),course.getDepartname());
    }
    // 根据课程编号查找课程信息
    public Course getCourseById(String cid) {
        String sql = "SELECT \n" +
                "tb_course.courseid,\n" +
                "tb_course.cname,\n" +
                "tb_course.tname,\n" +
                "tb_course.departname\n" +
                " FROM \n" +
                "tb_course where courseid=?";
        Course course =  DBUtils.getSingleObj(Course.class,sql,cid);
        return course;
    }
    //修改课程信息
    public boolean updateCourse(Course course) {
        String sql = "update tb_course set cname=?,tname=?,departname=? where courseid=?";
        boolean flag = DBUtils.update(sql,course.getCname(),course.getTname(),course.getDepartname(),course.getCourseid());
        return flag;
    }
    //查询所有信息
    public List<Course> getCourseListByPage(String sql) {
        List<Course> courseList= DBUtils.getList(Course.class,sql);
        return courseList;
    }

    public void delCourseById(int id) {
        String sql="delete from tb_course where courseid="+id;
        DBUtils.update1(sql);
    }

    public List<Course> checkCourse(String tnames) {
        String sql = "select * from tb_course where tname='"+tnames+"'";
        List<Course> courseList= DBUtils.getList(Course.class,sql);
        return courseList;
    }
}
