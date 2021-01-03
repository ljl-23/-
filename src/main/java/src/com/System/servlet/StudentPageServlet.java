package src.com.System.servlet;

import src.com.System.bean.Student;
import src.com.System.dao.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/StudentPageServlet")
public class StudentPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        StringBuffer sqlRow = new StringBuffer("SELECT \n" +
                "tb_student.studentid,\n" +
                "tb_student.sname,\n" +
                "tb_student.sex,\n" +
                "tb_student.sage,\n" +
                "tb_student.classname,\n" +
                "tb_student.phone,\n" +
                "tb_student.email,\n" +
                "tb_student.stupwd,\n" +
                "tb_student.remark\n" +
                " FROM \n" +
                " tb_student");
        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.getStudentListByPage(sqlRow.toString());
        request.setAttribute("studentList",studentList);
        request.getRequestDispatcher("officeStudnet.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
