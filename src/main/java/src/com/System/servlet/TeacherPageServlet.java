package src.com.System.servlet;

import src.com.System.bean.Teacher;
import src.com.System.dao.TeacherDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/TeacherPageServlet")
public class TeacherPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        StringBuffer sqlRow = new StringBuffer("SELECT \n" +
                "tb_teacher.teacherid,\n" +
                "tb_teacher.email,\n" +
                "tb_teacher.tname,\n" +
                "tb_teacher.tsex,\n" +
                "tb_teacher.prof,\n" +
                "tb_teacher.departname,\n" +
                "tb_teacher.phone,\n" +
                "tb_teacher.teachpwd,\n" +
                "tb_teacher.remark\n" +
                " FROM \n" +
                "tb_teacher");
        TeacherDAO teacherDAO = new TeacherDAO();
        List<Teacher> teacherList = teacherDAO.getTeacherListByPage(sqlRow.toString());
        request.setAttribute("teacherList",teacherList);
        request.getRequestDispatcher("officeTeacher.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
