package src.com.System.servlet;

import src.com.System.bean.CourseScheduling;
import src.com.System.dao.CourseSchedulingDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns= "/CourseSchedulingPageServlet")
public class CourseSchedulingPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

             StringBuffer sqlRow = new StringBuffer( "SELECT \n" +
            "tb_less.lessid,\n" +
            "tb_less.weeks,\n" +
            "tb_less.howless,\n" +
            "tb_less.classname,\n" +
            "tb_less.cousename,\n" +
            "tb_less.roomname,\n" +
            "tb_less.tname,\n" +
            "tb_less.grade \n" +
            "FROM \n" +
            "tb_less");

            CourseSchedulingDAO courseSchedulingDAO = new CourseSchedulingDAO();
            List<CourseScheduling> courseSchedulingList = courseSchedulingDAO.getCsListByPage(sqlRow.toString());
            request.setAttribute("courseSchedulingList",courseSchedulingList);
            request.getRequestDispatcher("office.jsp").forward(request,response);
           }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
