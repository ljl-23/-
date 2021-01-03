package src.com.System.dao;

import src.com.System.bean.CourseScheduling;
import src.com.System.utils.DBUtils;

import java.util.List;

public class CourseSchedulingDAO {
    //保存排课学生信息
    public Integer  saveCourseScheduling(CourseScheduling cs) {
        String sql="insert into tb_less(lessid,weeks,howless,classname,cousename,roomname,tname,grade) values(?,?,?,?,?,?,?,?)";
        return DBUtils.updateForPrimary(sql,cs.getLessid(),cs.getWeeks(),cs.getHowless(),cs.getClassname(),cs.getCousename(),cs.getRoomname(),cs.getTname(),cs.getGrade());
    }
    // 根据排课编号查找排课信息
    public CourseScheduling getCourseSchedulingById(String csid) {
        String sql = "SELECT \n" +
                "tb_less.lessid,\n" +
                "tb_less.weeks,\n" +
                "tb_less.howless,\n" +
                "tb_less.classname,\n" +
                "tb_less.cousename,\n" +
                "tb_less.roomname,\n" +
                "tb_less.tname,\n" +
                "tb_less.grade \n" +
                "FROM \n" +
                "tb_less " +
                "where lessid=?";
        CourseScheduling cs =  DBUtils.getSingleObj(CourseScheduling.class,sql,csid);
        return cs;
    }
    //修改排课信息
    public boolean updateCourseScheduling(CourseScheduling cs) {
        String sql = "update tb_less set weeks=?,howless=?,classname=?,cousename=?,roomname=?,tname=?,grade=? where lessid=?";
        boolean flag = DBUtils.update(sql,cs.getWeeks(),cs.getHowless(),cs.getClassname(),cs.getCousename(),cs.getRoomname(),cs.getTname(),cs.getGrade(),cs.getLessid());
        return flag;
    }


    //查询所有信息
    public List<CourseScheduling> getCsListByPage(String sql) {
        List<CourseScheduling> companyList= DBUtils.getList(CourseScheduling.class,sql);
        return companyList;
    }
   /* //查询一共多少行
    public Integer getCsCount(String sql,Object...param) {
        Integer count = DBUtils.getCount(sql,param);
        return count;
    }*/

    public void delCourseSchedulingById(int id) {
        String sql="delete from tb_less where lessid="+id;
        DBUtils.update1(sql);
    }
    public List<CourseScheduling> checkCourseSchedulingteach(String tnames){
        String sql = "select * from tb_less where tname='"+tnames+"'";
        List<CourseScheduling> companyList= DBUtils.getList(CourseScheduling.class,sql);
        return companyList;
    }
    public List<CourseScheduling> checkCourseScheduling2(String classnames){
        String sql = "select * from tb_less where classname='"+classnames+"'";
        List<CourseScheduling> companyList= DBUtils.getList(CourseScheduling.class,sql);
        return companyList;
    }
    public List<CourseScheduling> checkCourseScheduling(String weeks){
        String sql = "select * from tb_less where weeks='"+weeks+"'";
        List<CourseScheduling> companyList= DBUtils.getList(CourseScheduling.class,sql);
        return companyList;
    }
}
