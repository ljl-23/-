package src.com.System.servlet;

import src.com.System.bean.SwitchInfo;
import src.com.System.dao.SwitchInfoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/TeacherSwitchServlet")
public class TeacherSwitchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  method = request.getParameter("method");
        if("add".equals(method)){
            //封装对象
            SwitchInfo switchInfo =requestDataObj(request);
            SwitchInfoDAO switchInfoDAO = new SwitchInfoDAO();
            //将对象保存到数据库
            Integer sid = switchInfoDAO.saveSwitch(switchInfo);
            //将当前登录用户的建立ID，保存到Session中
            request.getSession().setAttribute("SESSION_SID",sid);
            //跳转到信息显示页面，展示当前用户申请的调课信息
            String tnamet =switchInfo.getTname();
            List<SwitchInfo> switchInfoList = switchInfoDAO.checkSwitchInfo(tnamet);
            request.setAttribute("switchInfoList",switchInfoList);
            //请求转发到学生信息展示页面
            request.getRequestDispatcher("/TeacherSwitch.jsp").forward(request,response);
        }
    }
    private SwitchInfo requestDataObj(HttpServletRequest request){
        //获取页面参数
        String tname =request.getParameter("tname");
        String message =request.getParameter("message");
        String reason =request.getParameter("reason");
        //封装对象
        SwitchInfo switchInfos = new SwitchInfo(null,tname,message,reason);
        return switchInfos;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
