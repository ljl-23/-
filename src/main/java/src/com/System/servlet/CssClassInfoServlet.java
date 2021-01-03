package src.com.System.servlet;

import src.com.System.bean.ClassInfo;
import src.com.System.dao.ClassInfoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/CssClassInfoServlet")
public class CssClassInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置post提交时候，参数解码方式
        // request.setCharacterEncoding("UTF-8");
        String  method = request.getParameter("method");
        //建立基本信息
        if("add".equals(method)){
            //封装对象
            ClassInfo classInfo =requestDataObj(request);
            ClassInfoDAO classInfoDAO = new ClassInfoDAO();
            //将对象保存到数据库
            Integer classid = classInfoDAO.saveClassInfo(classInfo);
            //将当前登录用户的建立ID，保存到Session中
            request.getSession().setAttribute("SESSION_CLASSID",classid);
            //跳转到用户信息显示页面，展示刚添加的班级信息
            request.setAttribute("classInfo",classInfo);
            //请求转发到班级信息展示页面
            request.getRequestDispatcher("/ClassPageServlet").forward(request,response);
        }
        else if("findById".equals(method)){
            String classid = request.getParameter("classid");
            ClassInfoDAO classInfoDAO = new ClassInfoDAO();
            String id = String.valueOf(classid);
            ClassInfo classInfo = classInfoDAO.getClassInfoById(id);//根据ID查询班级信息
            //将其放入request的作用域中
            request.setAttribute("classInfo",classInfo);
            request.getRequestDispatcher("/ClassPageServlet").forward(request,response);
        }
        else if(method.equals("update")){
            String id = request.getParameter("classid");
            ClassInfo classInfo = requestDataObj(request);
            classInfo.setClassid(Integer.valueOf(id));
            ClassInfoDAO classInfoDAO  = new ClassInfoDAO();
            boolean flag = classInfoDAO.updateClassInfo(classInfo);
            if(flag){
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('修改成功！');");
                writer.write(" window.location.href = '/CourseSchedulingSystem/ClassPageServlet';");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
            else {
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('修改失败！');");
                writer.write(" window.location.href = '/CourseSchedulingSystem/ClassPageServlet';");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }
        else if(method.equals("delete")){
            int id = Integer.parseInt(request.getParameter("classid"));
            ClassInfoDAO classInfoDAO = new ClassInfoDAO();
            classInfoDAO.delClassInfoById(id);
            request.getRequestDispatcher("/ClassPageServlet").forward(request,response);

        }else if("check".equals(method)){
            String profnames = request.getParameter("profnames");
            ClassInfoDAO classInfoDAO = new ClassInfoDAO();
            List<ClassInfo> classInfoList =  null;

            if(profnames.equals("")){
                response.sendRedirect("/CourseSchedulingSystem/ClassPageServlet");
            }else {
                classInfoList = classInfoDAO.checkClassInfo(profnames);
                request.setAttribute("classInfoList",classInfoList);
                request.getRequestDispatcher("officeClass.jsp").forward(request,response);
            }
        }

    }
    private ClassInfo requestDataObj(HttpServletRequest request){
        //获取页面参数
        String classname =request.getParameter("classname");
        String prof =request.getParameter("profname");
        String grade =request.getParameter("gradename");
        String depart =request.getParameter("departname");
        int coursenum =Integer.parseInt(request.getParameter("coursenum"));
        //封装对象
        ClassInfo classInfo = new ClassInfo(null,classname,prof,grade,depart,coursenum);
        return classInfo;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
