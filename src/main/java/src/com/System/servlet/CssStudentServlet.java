package src.com.System.servlet;
import src.com.System.bean.Student;
import src.com.System.dao.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/CssStudentServlet")
public class CssStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置post提交时候，参数解码方式
        // request.setCharacterEncoding("UTF-8");
        String  method = request.getParameter("method");
        //建立基本信息
        if("add".equals(method)){
            //封装对象
            Student student =requestDataObj(request);
            StudentDAO studentDAO = new StudentDAO();
            //将对象保存到数据库
            Integer studentid = studentDAO.saveStudents(student);
            //将当前登录用户的建立ID，保存到Session中
            request.getSession().setAttribute("SESSION_STUDENTID",studentid);
            //跳转到用户信息显示页面，展示刚添加的学生信息
            request.setAttribute("student",student);
            //请求转发到学生信息展示页面
            request.getRequestDispatcher("/StudentPageServlet").forward(request,response);
        }
        else if("findById".equals(method)){
            Integer stuId = Integer.parseInt(request.getParameter("studentid"));
            StudentDAO studentDAO = new StudentDAO();
            String id = String.valueOf(stuId);
            Student student = studentDAO.getStudentById(stuId);//根据ID查询学生信息
            //将其放入request的作用域中
            request.setAttribute("student",student);
            request.getRequestDispatcher("/StudentPageServlet").forward(request,response);
        }
        else if(method.equals("update")){
            String id = request.getParameter("studentid");
            Student student = requestDataObj(request);
            student.setStudentid(Integer.valueOf(id));
            StudentDAO studentDAO  = new StudentDAO();
            studentDAO.updateStudent(student);
            request.getRequestDispatcher("/StudentPageServlet").forward(request,response);
        }else if(method.equals("delete")){
            String  id =request.getParameter("studentid3");
            StudentDAO studentDAO = new StudentDAO();
            int stuid =Integer.valueOf(id);
            studentDAO.delStudentById(stuid);
            request.getRequestDispatcher("/StudentPageServlet").forward(request,response);

        }else if("check".equals(method)){
            String classnames = request.getParameter("classnames");
            StudentDAO studentDAO = new StudentDAO();
            List<Student> studentList =  null;

            if(classnames.equals("")){
                request.getRequestDispatcher("/StudentPageServlet").forward(request,response);
            }else {
                studentList = studentDAO.checkStudent(classnames);
                request.setAttribute("studentList",studentList);
                request.getRequestDispatcher("officeStudnet.jsp").forward(request,response);
            }
        }
    }
    private Student requestDataObj(HttpServletRequest request){
        //获取页面参数
        String sname =request.getParameter("sname");
        String sex =request.getParameter("sex");
        int age =Integer.parseInt(request.getParameter("sage"));
        String classname =request.getParameter("classname");
        String phone =request.getParameter("phone");
        String email =request.getParameter("email");
        String stupwd =request.getParameter("stupwd");
        String remark =request.getParameter("remark");
        //封装对象
        Student stu = new Student(null,sname,sex,age,classname,phone,email,stupwd,remark);
        return stu;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
