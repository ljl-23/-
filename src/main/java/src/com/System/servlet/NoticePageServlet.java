package src.com.System.servlet;

import src.com.System.bean.Notice;
import src.com.System.dao.NoticeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/NoticePageServlet")
public class NoticePageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        StringBuffer sqlRow = new StringBuffer("SELECT \n" +
                "tb_notice.noticeid,\n" +
                "tb_notice.nname,\n" +
                "tb_notice.matter\n" +
                " FROM \n" +
                "tb_notice\n");

        NoticeDAO noticeDAO = new NoticeDAO();
        List<Notice> noticeList = noticeDAO.getNoticeList(sqlRow.toString());
        request.setAttribute("noticeList",noticeList);
        request.getRequestDispatcher("officeNotice.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
