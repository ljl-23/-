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

@WebServlet(urlPatterns = "/SwitchPageServlet")
public class SwitchPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        StringBuffer sqlRow = new StringBuffer("SELECT \n" +
                "tb_switch.switchid,\n" +
                "tb_switch.tname,\n" +
                "tb_switch.message,\n" +
                "tb_switch.reason\n" +
                " FROM \n" +
                "tb_switch\n");

        SwitchInfoDAO switchInfoDAO = new SwitchInfoDAO();
        List<SwitchInfo> switchInfoList = switchInfoDAO.getSwitchInfoList(sqlRow.toString());
        request.setAttribute("switchInfoList",switchInfoList);
        request.getRequestDispatcher("officeSwitch.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
