package src.com.System.servlet;

import src.com.System.bean.Course;
import src.com.System.dao.CourseDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/CssCourseServlet")
public class CssCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置post提交时候，参数解码方式
        // request.setCharacterEncoding("UTF-8");
        String  method = request.getParameter("method");
        //建立基本信息
        if("add".equals(method)){
            //封装对象
            Course course =requestDataObj(request);
            CourseDAO courseDAO = new CourseDAO();
            //将对象保存到数据库
            Integer courseid = courseDAO.saveCourse(course);
            //将当前登录用户的建立ID，保存到Session中
            request.getSession().setAttribute("SESSION_COURSEID",courseid);
            //跳转到用户信息显示页面，展示刚添加的学生信息
            request.setAttribute("course",course);
            //请求转发到学生信息展示页面
            request.getRequestDispatcher("/CoursePageServlet").forward(request,response);
        }
        else if("findById".equals(method)){
            String courseid = request.getParameter("courseid");
            CourseDAO courseDAO = new CourseDAO();
            String id = String.valueOf(courseid);
            Course course = courseDAO.getCourseById(id);//根据ID查询学生信息
            //将其放入request的作用域中
            request.setAttribute("course",course);
            request.getRequestDispatcher("/CoursePageServlet").forward(request,response);
        }
        else if(method.equals("update")){
            String id = request.getParameter("courseid");
            Course course = requestDataObj(request);
            course.setCourseid(Integer.valueOf(id));
            CourseDAO courseDAO  = new CourseDAO();
            boolean flag = courseDAO.updateCourse(course);
            request.getRequestDispatcher("/CoursePageServlet").forward(request,response);
        }else if(method.equals("delete")){
            int courseid = Integer.parseInt(request.getParameter("courseid"));
            CourseDAO courseDAO = new CourseDAO();
            courseDAO.delCourseById(courseid);
            request.getRequestDispatcher("/CoursePageServlet").forward(request,response);

        }else if("check".equals(method)){
            String tnames = request.getParameter("tnames");
            CourseDAO courseDAO = new CourseDAO();
            List<Course> courseList =  null;

            if(tnames.equals("")){
                request.getRequestDispatcher("/CoursePageServlet").forward(request,response);
            }else {
                courseList = courseDAO.checkCourse(tnames);
                request.setAttribute("courseList",courseList);
                request.getRequestDispatcher("officeCourse.jsp").forward(request,response);
            }
        }

    }
    private Course requestDataObj(HttpServletRequest request){
        //获取页面参数
        String cname =request.getParameter("cname");
        String tname =request.getParameter("tname");
        String departname =request.getParameter("departname");
        //封装对象
        Course course = new Course(null,cname,tname,departname);
        return course;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
