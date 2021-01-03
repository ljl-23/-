package src.com.System.servlet;

import src.com.System.bean.SwitchInfo;
import src.com.System.dao.SwitchInfoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/CssSwitchServlet")
public class CssSwitchServlet extends HttpServlet {
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
            //跳转到用户信息显示页面，展示刚添加的学生信息
            request.setAttribute("switchInfo",switchInfo);
            //请求转发到学生信息展示页面
            request.getRequestDispatcher("/SwitchPageServlet").forward(request,response);
        }
        else if(method.equals("update")){
            String id = request.getParameter("switchid");
            SwitchInfo switchInfo = requestDataObj(request);
            switchInfo.setSwitchid(Integer.valueOf(id));
            SwitchInfoDAO switchInfoDAO  = new SwitchInfoDAO();
            boolean flag = switchInfoDAO.updateSwitchInfo(switchInfo);
            if(flag){
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('修改成功！');");
                writer.write(" window.location.href = '/CourseSchedulingSystem/SwitchPageServlet';");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
            else {
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('修改失败3！');");
                writer.write(" window.location.href = '/CourseSchedulingSystem/SwitchPageServlet';");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }
        else if(method.equals("delete")){
            int csId = Integer.parseInt(request.getParameter("switchid"));
            SwitchInfoDAO switchInfoDAO = new SwitchInfoDAO();
            switchInfoDAO.delSwitchInfoById(csId);
            request.getRequestDispatcher("/SwitchPageServlet").forward(request,response);

        }else if("check".equals(method)){
            String weeks_id = request.getParameter("weeks_id");
            SwitchInfoDAO switchInfoDAO = new SwitchInfoDAO();
            List<SwitchInfo> switchInfoList =  null;

            if(weeks_id.equals("")){
                response.sendRedirect("/CourseSchedulingSystem/SwitchPageServlet");
            }else {
                switchInfoList = switchInfoDAO.checkSwitchInfo(weeks_id);
                request.setAttribute("switchInfoList",switchInfoList);
                request.getRequestDispatcher("officeSwitch.jsp").forward(request,response);
            }
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
        doPost(request,response);
    }
}
