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

@WebServlet(urlPatterns = "/StudentSelfServlet")
public class StudentSelfServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  method = request.getParameter("method");
        if(method.equals("update")){
            String id = request.getParameter("studentid");
            Student student = requestDataObj(request);
            student.setStudentid(Integer.valueOf(id));
            StudentDAO studentDAO  = new StudentDAO();
            boolean flag = studentDAO.updateStudent(student);
            if(flag){
                request.getSession().setAttribute("student", student);
                request.getRequestDispatcher("student.jsp").forward(request, response);
            }
            else {
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('修改失败！');");
                writer.write(" window.location.href = '/CourseSchedulingSystem/student.jsp';");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }
        else if(method.equals("self")){
            int stuId = Integer.parseInt(request.getParameter("studentids"));
            StudentDAO studentDAO  = new StudentDAO();
            Student student = studentDAO.getStudentById(stuId);
            request.getSession().setAttribute("student", student);
            request.getRequestDispatcher("student.jsp").forward(request, response);
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
