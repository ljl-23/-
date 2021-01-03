package src.com.System.servlet;

import src.com.System.bean.CourseScheduling;
import src.com.System.bean.Notice;
import src.com.System.dao.CourseSchedulingDAO;
import src.com.System.dao.NoticeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/StudentCsShowServlet")
public class StudentCsShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  method = request.getParameter("method");
        if("check".equals(method)){
            String classnames = request.getParameter("classnames");
            CourseSchedulingDAO courseSchedulingDAO = new CourseSchedulingDAO();
            List<CourseScheduling> courseSchedulingList =  courseSchedulingDAO.checkCourseScheduling2(classnames);
            request.setAttribute("courseSchedulingList",courseSchedulingList);
            request.getRequestDispatcher("StudentCs.jsp").forward(request,response);

        }
        else if("notice".equals(method)){
            StringBuffer sqlRow = new StringBuffer("SELECT \n" +
                    "tb_notice.noticeid,\n" +
                    "tb_notice.nname,\n" +
                    "tb_notice.matter\n" +
                    " FROM \n" +
                    "tb_notice\n");

            NoticeDAO noticeDAO = new NoticeDAO();
            List<Notice> noticeList = noticeDAO.getNoticeList(sqlRow.toString());
            request.setAttribute("noticeList",noticeList);
            request.getRequestDispatcher("StudentNotice.jsp").forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
