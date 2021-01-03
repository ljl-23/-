package src.com.System.dao;
import src.com.System.bean.Room;
import src.com.System.utils.DBUtils;

import java.util.List;

public class RoomDAO {
    //保存教室信息
    public Integer saveRoom(Room room) {
        String sql="insert into tb_room(roomid,roomname) values(?,?)";
        return DBUtils.updateForPrimary(sql,room.getRoomid(),room.getRoomname());
    }
    // 根据教室编号查找教室信息
    public Room getRoomById(String rid) {
        String sql = "SELECT \n" +
                "tb_room.roomid,\n" +
                "tb_room.roomname\n" +
                " FROM \n" +
                "tb_room\n" +
                " where roomid=?";
        Room room =  DBUtils.getSingleObj(Room.class,sql,rid);
        return room;
    }
    //修改教室信息
    public boolean updateRoom(Room room) {
        String sql = "update tb_room set roomname=? where roomid=?";
        boolean flag = DBUtils.update(sql,room.getRoomname(),room.getRoomid());
        return flag;
    }

    //分页查询
    public List<Room> getRoomListByPage(String sql) {
        List<Room> roomList= DBUtils.getList(Room.class,sql);
        return roomList;
    }

    public void delRoomById(int id) {
        String sql="delete from tb_room where roomid="+id;
        DBUtils.update1(sql);
    }

    public List<Room> checkRoom(Integer id){
        String sql = "select * from tb_room where roomid='"+id+"'";
        List<Room> roomList= DBUtils.getList(Room.class,sql);
        return roomList;
    }
}
