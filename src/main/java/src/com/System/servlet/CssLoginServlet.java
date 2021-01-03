package src.com.System.servlet;

import src.com.System.bean.Office;
import src.com.System.bean.Student;
import src.com.System.bean.Teacher;
import src.com.System.dao.StudentDAO;
import src.com.System.dao.TeacherDAO;
import src.com.System.dao.OfficeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/CssLoginServlet")
public class CssLoginServlet extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求和响应编码
      /*  request.setCharacterEncoding("UTF-8");*/
        response.setContentType("text/html;charset=UTF-8");
        //获取前台提交的账号和密码和用户类型
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String strvalue = request.getParameter("type");
        //根据登录的用户类型跳转不同的页面
        if(strvalue.contains("stu")) {
            StudentDAO studentDAO = new StudentDAO();
            //获取javaBean Model数据模型
            Student student =studentDAO.getUserByStudentid(email,password);
           /* //调用业务逻辑
            boolean flag = ;
            //根据业务处理结果，流程跳转*/
            if (student!=null) {
                //将学生信息放入Session中
                request.getSession().setAttribute("student", student);
                request.getRequestDispatcher("student.jsp").forward(request, response);
            } else if(student == null){
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('用户名或者密码错误！');");
                writer.write(" window.location.href = 'login.jsp';");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }else if(strvalue.contains("teach")){
            TeacherDAO teacherDAO = new TeacherDAO();
            //获取javaBean Model数据模型
            Teacher teacher = teacherDAO.getUserByTeacherid(email,password);
            if (teacher!=null) {
                //将学生信息放入Session中
                request.getSession().setAttribute("teacher", teacher);
                request.getRequestDispatcher("teacher.jsp").forward(request, response);
            } else if(teacher == null){
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('用户名或者密码错误！');");
                writer.write(" window.location.href = 'login.jsp';");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }else{
            OfficeDAO officeDAO = new OfficeDAO();
            //获取javaBean Model数据模型
            Office office = officeDAO.getUserByofficeid(email,password);
            if (office!=null) {
                //将信息放入Session中
                request.getSession().setAttribute("SESSION_OFFICE", office);
                request.getRequestDispatcher("/CourseSchedulingPageServlet").forward(request, response);
            }else if(office == null){
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('用户名或者密码错误！');");
                writer.write(" window.location.href = 'login.jsp';");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }
    }
}
