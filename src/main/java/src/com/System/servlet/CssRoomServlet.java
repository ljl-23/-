package src.com.System.servlet;

import src.com.System.bean.Room;
import src.com.System.dao.RoomDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/CssRoomServlet")
public class CssRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置post提交时候，参数解码方式
        // request.setCharacterEncoding("UTF-8");
        String  method = request.getParameter("method");
        //建立基本信息
        if("add".equals(method)){
            //封装对象
            Room room =requestDataObj(request);
            RoomDAO roomDAO = new RoomDAO();
            //将对象保存到数据库
            Integer roomid = roomDAO.saveRoom(room);
            //将当前登录用户的建立ID，保存到Session中
            request.getSession().setAttribute("SESSION_ROOMID",roomid);
            //跳转到用户信息显示页面，展示刚添加的学生信息
            request.setAttribute("room",room);
            //请求转发到学生信息展示页面
            request.getRequestDispatcher("/RoomPageServlet").forward(request,response);
        }
        else if("findById".equals(method)){
            String roomid = request.getParameter("roomid");
            RoomDAO roomDAO = new RoomDAO();
            String id = String.valueOf(roomid);
            Room room = roomDAO.getRoomById(id);//根据ID查询学生信息
            //将其放入request的作用域中
            request.setAttribute("room",room);
            request.getRequestDispatcher("/RoomPageServlet").forward(request,response);
        }
        else if(method.equals("update")){
            String roomid = request.getParameter("roomid");
            Room room = requestDataObj(request);
            room.setRoomid(Integer.valueOf(roomid));
            RoomDAO roomDAO  = new RoomDAO();
            boolean flag = roomDAO.updateRoom(room);
            request.getRequestDispatcher("/RoomPageServlet").forward(request,response);
        }
        else if(method.equals("delete")){
            String  id = request.getParameter("roomid");
            RoomDAO roomDAO = new RoomDAO();
            int roomid = Integer.valueOf(id);
            roomDAO.delRoomById(roomid);
            request.getRequestDispatcher("/RoomPageServlet").forward(request,response);

        }else if("check".equals(method)){
            Integer roomids = Integer.parseInt(request.getParameter("roomids"));
            RoomDAO roomDAO = new RoomDAO();
            List<Room> roomList =  null;

            if(roomids.equals("")){
                request.getRequestDispatcher("/RoomPageServlet").forward(request,response);
            }else {
                roomList = roomDAO.checkRoom(roomids);
                request.setAttribute("roomList",roomList);
                request.getRequestDispatcher("officeRoom.jsp").forward(request,response);
            }
        }

    }
    private Room requestDataObj(HttpServletRequest request){
        //获取页面参数
        String roomname =request.getParameter("roomname");
        //封装对象
        Room room = new Room(null,roomname);
        return room;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
