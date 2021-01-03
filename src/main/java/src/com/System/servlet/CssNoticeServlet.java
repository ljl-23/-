package src.com.System.servlet;

import src.com.System.bean.Notice;
import src.com.System.dao.NoticeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/CssNoticeServlet")
public class CssNoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  method = request.getParameter("method");
        if("add".equals(method)){
            //封装对象
            Notice notice =requestDataObj(request);
            NoticeDAO noticeDAO = new NoticeDAO();
            //将对象保存到数据库
            Integer notid = noticeDAO.saveNotice(notice);
            //将当前登录用户的建立ID，保存到Session中
            request.getSession().setAttribute("SESSION_NOTID",notid);
            //跳转到用户信息显示页面，展示刚添加的学生信息
            request.setAttribute("notice",notice);
            //请求转发到学生信息展示页面
            request.getRequestDispatcher("/NoticePageServlet").forward(request,response);
        }
        else if(method.equals("update")){
            String id = request.getParameter("noticeid");
            Notice notice = requestDataObj(request);
            notice.setNoticeid(Integer.valueOf(id));
            NoticeDAO noticeDAO  = new NoticeDAO();
            boolean flag = noticeDAO.updateNotice(notice);
            if(flag){
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('修改成功！');");
                writer.write(" window.location.href = '/CourseSchedulingSystem/NoticePageServlet';");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
            else {
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('修改失败3！');");
                writer.write(" window.location.href = '/CourseSchedulingSystem/NoticePageServlet';");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }
        else if(method.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("noticeid"));
            NoticeDAO noticeDAO = new NoticeDAO();
            noticeDAO.delNoticeById(id);
            request.getRequestDispatcher("/NoticePageServlet").forward(request, response);

        }
    }
    private Notice requestDataObj(HttpServletRequest request){
        //获取页面参数
        String noticename =request.getParameter("nname");
        String matter =request.getParameter("matter");
        //封装对象
        Notice notice = new Notice(null,noticename,matter);
        return notice;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
