package src.com.System.servlet;

import src.com.System.bean.Room;
import src.com.System.dao.RoomDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/RoomPageServlet")
public class RoomPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        StringBuffer sqlRow = new StringBuffer("SELECT \n" +
                "tb_room.roomid,\n" +
                "tb_room.roomname\n" +
                " FROM \n" +
                "tb_room");

        RoomDAO roomDAO = new RoomDAO();
        List<Room> roomList = roomDAO.getRoomListByPage(sqlRow.toString());
        request.setAttribute("roomList",roomList);
        request.getRequestDispatcher("officeRoom.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
