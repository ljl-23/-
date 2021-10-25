package src.com.System.servlet;

import src.com.System.bean.Teacher;
import src.com.System.dao.TeacherDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/TeacherSelfServlet")
public class TeacherSelfServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  method = request.getParameter("method");
        if(method.equals("update")){
            String id = request.getParameter("teacherid");
            Teacher teacher = requestDataObj(request);
            teacher.setTeacherid(Integer.valueOf(id));
            TeacherDAO teacherDAO  = new TeacherDAO();
            boolean flag = teacherDAO.updateTeacher(teacher);
            request.getSession().setAttribute("teacher", teacher);
            request.getRequestDispatcher("teacher.jsp").forward(request, response);
        }  else if(method.equals("self")){
            int teacherid = Integer.parseInt(request.getParameter("teacherids"));
            TeacherDAO teacherDAO  = new TeacherDAO();
            Teacher teacher = teacherDAO.getTeacherById(teacherid);
            request.getSession().setAttribute("teacher", teacher);
            request.getRequestDispatcher("teacher.jsp").forward(request, response);
        }
    }
    private Teacher requestDataObj(HttpServletRequest request){
        //获取页面参数
        String teachemail =request.getParameter("teachemail");
        String tname =request.getParameter("tname");
        String tsex =request.getParameter("tsex");
        String prof =request.getParameter("prof");
        String departname =request.getParameter("departname");
        String phone =request.getParameter("phone");
        String teachpwd =request.getParameter("teachpwd");
        String remark =request.getParameter("remark");
        //封装对象
        Teacher teacher = new Teacher(null,teachemail,tname,tsex,prof,departname,phone,teachpwd,remark);
        return teacher;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
