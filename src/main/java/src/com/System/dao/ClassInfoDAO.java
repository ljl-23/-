package src.com.System.dao;

import src.com.System.bean.ClassInfo;
import src.com.System.utils.DBUtils;

import java.util.List;

public class ClassInfoDAO {
    //保存班级信息
    public Integer saveClassInfo(ClassInfo classInfo) {
        String sql="insert into tb_class(classid,classname,profname,gradename,departname,coursenum) values(?,?,?,?,?,?)";
        return DBUtils.updateForPrimary(sql,classInfo.getClassid(),classInfo.getClassname(),classInfo.getProfname(),classInfo.getGradename(),classInfo.getDepartname(),classInfo.getCoursenum());
    }
    // 根据班级编号查找班级信息
    public ClassInfo getClassInfoById(String classid) {
        String sql = "SELECT \n" +
                "tb_class.classid,\n" +
                "tb_class.classname,\n" +
                "tb_class.profname,\n" +
                "tb_class.gradename,\n" +
                "tb_class.departname,\n" +
                "tb_class.coursenum\n" +
                " FROM \n" +
                "tb_class where classid=?";
        ClassInfo classInfo =  DBUtils.getSingleObj(ClassInfo.class,sql,classid);
        return classInfo;
    }
    //修改班级信息
    public boolean updateClassInfo(ClassInfo classInfo) {
        String sql = "update tb_class set classname=?,profname=?,gradename=?,departname=?,coursenum=? where classid=?";
        boolean flag = DBUtils.update(sql,classInfo.getClassname(),classInfo.getProfname(),classInfo.getGradename(),classInfo.getDepartname(),classInfo.getCoursenum(),classInfo.getClassid());
        return flag;
    }

    public List<ClassInfo> getClassListByPage(String sql) {
        List<ClassInfo> classInfoList= DBUtils.getList(ClassInfo.class,sql);
        return classInfoList;
    }

    public void delClassInfoById(int id) {
        String sql="delete from tb_class where classid="+id;
        DBUtils.update1(sql);
    }

    public List<ClassInfo> checkClassInfo(String profnames) {
        String sql = "select * from tb_class where profname='"+profnames+"'";
        List<ClassInfo> classInfoList= DBUtils.getList(ClassInfo.class,sql);
        return classInfoList;
    }
}
