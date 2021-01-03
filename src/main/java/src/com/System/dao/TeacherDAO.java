package src.com.System.dao;
import src.com.System.bean.Teacher;
import src.com.System.utils.DBUtils;

import java.util.List;

public class TeacherDAO {
    //根据用户编号查询教师信息
    public Teacher getUserByTeacherid(String username, String password) {
        String sql = "SELECT \n" +
                "tb_teacher.teacherid,\n" +
                "tb_teacher.email,\n" +
                "tb_teacher.tname,\n" +
                "tb_teacher.tsex,\n" +
                "tb_teacher.prof,\n" +
                "tb_teacher.departname,\n" +
                "tb_teacher.phone,\n" +
                "tb_teacher.teachpwd,\n" +
                "tb_teacher.remark\n" +
                " FROM\n" +
                " tb_teacher where email=? and teachpwd=?";
        return DBUtils.getSingleObj(Teacher.class,sql,username,password);
    }
    //查询数据库中该教师邮箱账号是否存在
    public Integer selectTeacherEmailCount(String email) {
        String  sql="select count(*) from tb_teacher a where a.email = ?";
        Integer count = DBUtils.getCount(sql,email);
        return count;
    }
    //保存注册教师对象
    public boolean saveTeacher(Teacher teacher) {
        String sql = "insert into tb_teacher(email,teachpwd)"
                + "values(?,?)";
        return DBUtils.save(sql,teacher.getEmail(),teacher.getTeachpwd());
    }
    //保存教师信息
    public Integer saveTeachers(Teacher teacher) {
        String sql="insert into tb_teacher(teacherid,email,tname,tsex,prof,departname,phone,teachpwd,remark) values(?,?,?,?,?,?,?,?,?)";
        return DBUtils.updateForPrimary(sql,teacher.getTeacherid(),teacher.getEmail(),teacher.getTname(),teacher.getTsex(),teacher.getProf(),teacher.getDepartname(),teacher.getPhone(),teacher.getTeachpwd(),teacher.getRemark());
    }
    // 根据教师编号查找学生信息
    public Teacher getTeacherById(Integer teacherid) {
        String sql ="SELECT * FROM tb_teacher where teacherid=?";
        Teacher teacher =  DBUtils.getSingleObj(Teacher.class,sql,teacherid);
        return teacher;
    }
    //修改教师信息
    public boolean updateTeacher(Teacher teacher) {
        String sql = "update tb_teacher set email=?,tname=?,tsex=?,prof=?,departname=?,phone=?,teachpwd=?,remark=? where teacherid=?";
        boolean flag = DBUtils.update(sql,teacher.getEmail(),teacher.getTname(),teacher.getTsex(),teacher.getProf(),teacher.getDepartname(),teacher.getPhone(),teacher.getTeachpwd(),teacher.getRemark(),teacher.getTeacherid());
        return flag;
    }
    //分页查询
    public List<Teacher> getTeacherListByPage(String sql) {
        List<Teacher> teacherList= DBUtils.getList(Teacher.class,sql);
        return teacherList;
    }
    //删除
    public void delTeacherById(int Id) {
        String sql="delete from tb_teacher where teacherid="+Id;
        DBUtils.update1(sql);
    }

    public List<Teacher> checkTeacher(String profs) {
        String sql = "select * from tb_teacher where prof='"+profs+"'";
        List<Teacher> TeacherList= DBUtils.getList(Teacher.class,sql);
        return TeacherList;
    }
}
