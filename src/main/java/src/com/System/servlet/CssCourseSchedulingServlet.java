package src.com.System.servlet;

import src.com.System.bean.CourseScheduling;
import src.com.System.dao.CourseSchedulingDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/CssCourseSchedulingServlet")
public class CssCourseSchedulingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置post提交时候，参数解码方式
        /*request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");*/
        String  method = request.getParameter("method");
        if("add".equals(method)){
            //封装对象
            CourseScheduling cs =requestDataObj(request);
            CourseSchedulingDAO csDAO = new CourseSchedulingDAO();
            //将对象保存到数据库
            Integer csid = csDAO.saveCourseScheduling(cs);
            //将当前登录用户的建立ID，保存到Session中
            request.getSession().setAttribute("SESSION_CSID",csid);
            //跳转到用户信息显示页面，展示刚添加的学生信息
            request.setAttribute("COURSESCHEDULING",cs);
            //请求转发到学生信息展示页面
            request.getRequestDispatcher("/CourseSchedulingPageServlet").forward(request,response);
        }
        else if("findById".equals(method)){
            String csId = request.getParameter("lessid");
            CourseSchedulingDAO courseSchedulingDAO = new CourseSchedulingDAO();
            String id = String.valueOf(csId);
            CourseScheduling cs = courseSchedulingDAO.getCourseSchedulingById(id);//根据ID查询排课信息
            //将其放入request的作用域中
            request.setAttribute("COURSESCHEDULING",cs);
            request.getRequestDispatcher("find/CourseSchedulingfindBy.jsp").forward(request,response);
        }
        else if(method.equals("update")){
            String id = request.getParameter("lessid");
            CourseScheduling cs = requestDataObj(request);
            cs.setLessid(Integer.valueOf(id));
            CourseSchedulingDAO courseSchedulingDAO  = new CourseSchedulingDAO();
            boolean flag = courseSchedulingDAO.updateCourseScheduling(cs);
            request.getRequestDispatcher("/CourseSchedulingPageServlet").forward(request, response);
        }
        else if(method.equals("delete")){
            int csId = Integer.parseInt(request.getParameter("lessid"));
            CourseSchedulingDAO courseSchedulingDAO = new CourseSchedulingDAO();
            courseSchedulingDAO.delCourseSchedulingById(csId);
            request.getRequestDispatcher("/CourseSchedulingPageServlet").forward(request,response);

        }else if("check".equals(method)){
            String weeks_id = request.getParameter("weeks_id");
            CourseSchedulingDAO courseSchedulingDAO = new CourseSchedulingDAO();
            List<CourseScheduling> courseSchedulingList =  null;

            if(weeks_id.equals("")){
                request.getRequestDispatcher("/CourseSchedulingPageServlet").forward(request,response);
            }else {
                courseSchedulingList = courseSchedulingDAO.checkCourseScheduling(weeks_id);
                request.setAttribute("courseSchedulingList",courseSchedulingList);
                request.getRequestDispatcher("office.jsp").forward(request,response);
            }
        }
    }
    private CourseScheduling requestDataObj(HttpServletRequest request){
        //获取页面参数
        //int lessid = Integer.parseInt(request.getParameter("lessid"));
        String weeks =request.getParameter("weeks");
        String howless =request.getParameter("howless");
        String classname =request.getParameter("classname");
        String cousename =request.getParameter("cousename");
        String roomname =request.getParameter("roomname");
        String tname =request.getParameter("tname");
        String garde =request.getParameter("grade");
        //封装对象
        CourseScheduling cs = new CourseScheduling(null,weeks,howless,classname,cousename,roomname,tname,garde);
        return cs;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
