package src.com.System.servlet;

import src.com.System.bean.Office;
import src.com.System.bean.Student;
import src.com.System.bean.Teacher;
import src.com.System.dao.OfficeDAO;
import src.com.System.dao.StudentDAO;
import src.com.System.dao.TeacherDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/CssRegisterServlet")
public class CssRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求和响应编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //获取前台提交的email和密码
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String strvalue = request.getParameter("type");
        if(strvalue.contains("stu")) {
            //封装成javaBean Model数据模型
            Student student =new Student(null,email,null,0,null,null,email,password,null);
            //保存student到数据库 studentDAO
            StudentDAO studentDAO = new StudentDAO();
            //判定是否由相同的email
            Integer count = studentDAO.selectStudentEmailCount(email);
            if(count>0){
                //数据库已经由相同email的用户
                //通过response对象给客户端一个错误提示
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('申请注册的email已经被占用!');");
                writer.write(" window.location.href = 'register.jsp';");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }else{
                //flag是否注册成功
                boolean flag = studentDAO.savestudent(student);

                //注册成功就跳转到登录页面
                if(flag){
                    //注册成功就跳转到登录页面，重定向
                    response.sendRedirect("/CourseSchedulingSystem/login.jsp");
                }else {
                    PrintWriter out2 = response.getWriter();
                    out2.println("邮箱注册失败");
                    //注册失败就返回注册页面 请求转发
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
                    dispatcher.forward(request,response);
                }
            }
        }
        else if(strvalue.contains("teach")){
            //封装成javaBean Model数据模型
            Teacher teacher =new Teacher(null,email,null,null,null,null,null,password,null);
            //保存student到数据库 studentDAO
            TeacherDAO teacherDAO = new TeacherDAO();
            //判定是否由相同的email
            Integer count = teacherDAO.selectTeacherEmailCount(email);
            if(count>0){
                //数据库已经由相同email的用户
                //通过response对象给客户端一个错误提示
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('申请注册的email已经被占用!');");
                writer.write(" window.location.href = 'register.jsp';");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }else{
                //flag是否注册成功
                boolean flag = teacherDAO.saveTeacher(teacher);
                //注册成功就跳转到登录页面
                if(flag){
                    //注册成功就跳转到登录页面，重定向
                    response.sendRedirect("/CourseSchedulingSystem/login.jsp");
                }else {
                    PrintWriter out3 = response.getWriter();
                    out3.println("邮箱注册失败");
                    //注册失败就返回注册页面 请求转发
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
                    dispatcher.forward(request,response);
                }
            }
        }
        else if(strvalue.contains("office")){
            //封装成javaBean Model数据模型
            Office office =new Office(null,email,password,new Date());
            //保存student到数据库 studentDAO
            OfficeDAO officeDAO = new OfficeDAO();
            //判定是否由相同的email
            Integer count = officeDAO.selectOfficeEmailCount(email);
            if(count>0){
                //数据库已经由相同email的用户
                //通过response对象给客户端一个错误提示
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('申请注册的email已经被占用!');");
                writer.write(" window.location.href = 'register.jsp';");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }else{
                //flag是否注册成功
                boolean flag = officeDAO.saveOffice(office);
                //注册成功就跳转到登录页面
                if(flag){
                    //注册成功就跳转到登录页面，重定向
                    response.sendRedirect("/CourseSchedulingSystem/login.jsp");
                }else {
                    out.println("邮箱注册失败");
                    //注册失败就返回注册页面 请求转发
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
                    dispatcher.forward(request,response);
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
