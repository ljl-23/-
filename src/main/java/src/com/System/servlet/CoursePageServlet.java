package src.com.System.servlet;

import src.com.System.bean.Course;
import src.com.System.dao.CourseDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/CoursePageServlet")
public class CoursePageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        StringBuffer sqlRow = new StringBuffer("SELECT \n" +
                "tb_course.courseid,\n" +
                "tb_course.cname,\n" +
                "tb_course.tname,\n" +
                "tb_course.departname \n" +
                "FROM \n" +
                "tb_course");

        CourseDAO courseDAO = new CourseDAO();
        List<Course> courseList = courseDAO.getCourseListByPage(sqlRow.toString());
        request.setAttribute("courseList",courseList);
        request.getRequestDispatcher("officeCourse.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
