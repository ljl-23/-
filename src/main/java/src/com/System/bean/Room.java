package src.com.System.bean;

import org.omg.PortableInterceptor.INACTIVE;

public class Room {
    private Integer roomid;
    private String roomname;

    public Room() {
    }

    public Room(Integer roomid, String roomname) {
        this.roomid = roomid;
        this.roomname = roomname;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomid=" + roomid +
                ", roomname='" + roomname + '\'' +
                '}';
    }
}
