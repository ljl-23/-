package src.com.System.dao;

import src.com.System.bean.Student;
import src.com.System.utils.DBUtils;

import java.util.List;

public class StudentDAO {

    //根据用户编号查询用户信息
    public Student getUserByStudentid(String username, String password) {
        String sql="SELECT tb_student.email,tb_student.studentid,tb_student.sname,tb_student.sex,tb_student.sage,tb_student.classname,tb_student.phone,tb_student.stupwd,tb_student.remark FROM tb_student where email=? and stupwd=?";
        return DBUtils.getSingleObj(Student.class,sql,username,password);
    }
    //查询数据库中该邮箱账号是否存在
    public Integer selectStudentEmailCount(String email) {
        String  sql="select count(*) from tb_student a where a.email = ?";
        Integer count = DBUtils.getCount(sql,email);
        return count;
    }
    //保存注册对象
    public boolean savestudent(Student student) {
        String sql = "insert into tb_student(email,stupwd) values(?,?)";
        return DBUtils.save(sql,student.getEmail(),student.getStupwd());
    }
    //保存学生信息
    public Integer saveStudents(Student stu) {
        String sql="insert into tb_student(studentid,email,sname,sex,sage,classname,phone,stupwd,remark) values(?,?,?,?,?,?,?,?,?)";
        return DBUtils.updateForPrimary(sql,stu.getStudentid(),stu.getEmail(),stu.getSname(),stu.getSex(),stu.getSage(),stu.getClassname(),stu.getPhone(),stu.getStupwd(),stu.getRemark());
    }
    // 根据学生编号查找学生信息
    public Student getStudentById(Integer stuid) {
        String sql = "SELECT * FROM tb_student where studentid=?";
        Student student =  DBUtils.getSingleObj(Student.class,sql,stuid);
        return student;
    }
    //修改学生信息
    public boolean updateStudent(Student student) {
        String sql = "update tb_student set sname=?,sex=?,sage=?,classname=?,phone=?,email=?,stupwd=?,remark=? where studentid=?";
        boolean flag = DBUtils.update(sql,student.getSname(),student.getSex(),student.getSage(),student.getClassname(),student.getPhone(),student.getEmail(),student.getStupwd(),student.getRemark(),student.getStudentid());
        return flag;
    }
    //查询所有的信息
    public List<Student> getStudentListByPage(String sql) {
        List<Student> studentList= DBUtils.getList(Student.class,sql);
        return studentList;
    }

    public void delStudentById(int stuId) {
        String sql="delete from tb_student where studentid="+stuId;
        DBUtils.update1(sql);
    }

    public List<Student> checkStudent(String classnames) {
        String sql = "select * from tb_student where classname='"+classnames+"'";
        List<Student> studentList= DBUtils.getList(Student.class,sql);
        return studentList;
    }
}
