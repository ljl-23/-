package src.com.System.dao;
import src.com.System.bean.Notice;
import src.com.System.utils.DBUtils;

import java.util.List;

public class NoticeDAO {
    //查询所有信息
    public List<Notice> getNoticeList(String sql) {
        List<Notice> noticeList= DBUtils.getList(Notice.class,sql);
        return noticeList;
    }
    //保存信息
    public Integer  saveNotice(Notice notice) {
        String sql="insert into tb_notice(noticeid,nname,matter) values(?,?,?)";
        return DBUtils.updateForPrimary(sql,notice.getNoticeid(),notice.getNname(),notice.getMatter());
    }
    //修改排课信息
    public boolean updateNotice(Notice notice) {
        String sql = "update tb_notice set nname=?,matter=? where noticeid=?";
        boolean flag = DBUtils.update(sql,notice.getNname(),notice.getMatter(),notice.getNoticeid());
        return flag;
    }
    public void delNoticeById(int id) {
        String sql="delete from tb_notice where noticeid="+id;
        DBUtils.update1(sql);
    }
}
