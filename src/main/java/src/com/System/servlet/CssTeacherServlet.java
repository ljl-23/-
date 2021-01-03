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
import java.util.List;

@WebServlet(urlPatterns = "/CssTeacherServlet")
public class CssTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置post提交时候，参数解码方式
        // request.setCharacterEncoding("UTF-8");
        String  method = request.getParameter("method");
        //建立基本信息
        if("add".equals(method)){
            //封装对象
            Teacher teacher =requestDataObj(request);
            TeacherDAO teacherDAO = new TeacherDAO();
            //将对象保存到数据库
            Integer teacherid = teacherDAO.saveTeachers(teacher);
            //将当前登录用户的建立ID，保存到Session中
            request.getSession().setAttribute("SESSION_TEACHERID",teacherid);
            //跳转到用户信息显示页面，展示刚添加的学生信息
            request.setAttribute("teacher",teacher);
            //请求转发到学生信息展示页面
            request.getRequestDispatcher("/TeacherPageServlet").forward(request,response);
        }
        else if("findById".equals(method)){
            Integer teacherid = Integer.parseInt(request.getParameter("teacherid"));
            TeacherDAO teacherDAO = new TeacherDAO();
            Teacher teacher = teacherDAO.getTeacherById(teacherid);//根据ID查询学生信息
            //将其放入request的作用域中
            request.setAttribute("teacher",teacher);
            request.getRequestDispatcher("/TeacherPageServlet").forward(request,response);
        }
        else if(method.equals("update")){
            String teacherid = request.getParameter("teacherid");
            Teacher teacher = requestDataObj(request);
            teacher.setTeacherid(Integer.valueOf(teacherid));
            TeacherDAO teacherDAO  = new TeacherDAO();
            boolean flag = teacherDAO.updateTeacher(teacher);
            if(flag){
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('修改成功！');");
                writer.write(" window.location.href = '/CourseSchedulingSystem/TeacherPageServlet';");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
            else {
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('修改失败！');");
                writer.write(" window.location.href = '/CourseSchedulingSystem/TeacherPageServlet';");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }else if(method.equals("delete")){
            int Id = Integer.parseInt(request.getParameter("teacherid"));
            TeacherDAO teacherDAO = new TeacherDAO();
            teacherDAO.delTeacherById(Id);
            request.getRequestDispatcher("/TeacherPageServlet").forward(request,response);

        }else if("check".equals(method)){
            String profs = request.getParameter("profs");
            TeacherDAO teacherDAO= new TeacherDAO();
            List<Teacher> teacherList =  null;

            if(profs.equals("")){
                response.sendRedirect("/CourseSchedulingSystem/TeacherPageServlet");
            }else {
                teacherList = teacherDAO.checkTeacher(profs);
                request.setAttribute("teacherList",teacherList);
                request.getRequestDispatcher("officeTeacher.jsp").forward(request,response);
            }

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
