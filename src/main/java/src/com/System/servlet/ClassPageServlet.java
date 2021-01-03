package src.com.System.servlet;

import src.com.System.bean.ClassInfo;
import src.com.System.dao.ClassInfoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/ClassPageServlet")
public class ClassPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        StringBuffer sqlRow = new StringBuffer("SELECT \n" +
                "tb_class.classid,\n" +
                "tb_class.classname,\n" +
                "tb_class.profname,\n" +
                "tb_class.gradename,\n" +
                "tb_class.departname,\n" +
                "tb_class.coursenum\n" +
                " FROM \n" +
                "tb_class");

        ClassInfoDAO classInfoDAO = new ClassInfoDAO();
        List<ClassInfo> classInfoList = classInfoDAO.getClassListByPage(sqlRow.toString());
        request.setAttribute("ClassInfoList",classInfoList);
        request.getRequestDispatcher("officeClass.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
