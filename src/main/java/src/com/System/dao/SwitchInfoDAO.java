package src.com.System.dao;

import src.com.System.bean.SwitchInfo;
import src.com.System.utils.DBUtils;

import java.util.List;

public class SwitchInfoDAO {
    //保存调课信息
    public Integer  saveSwitch(SwitchInfo switchInfo) {
        String sql="insert into tb_switch(switchid,tname,message,reason) values(?,?,?,?)";
        return DBUtils.updateForPrimary(sql,switchInfo.getSwitchid(),switchInfo.getTname(),switchInfo.getMessage(),switchInfo.getReason());
    }

    //修改调课信息
    public boolean updateSwitchInfo(SwitchInfo switchInfo) {
        String sql = "update tb_switch set tname=?,message=?,reason=? where switchid=?";
        boolean flag = DBUtils.update(sql,switchInfo.getTname(),switchInfo.getMessage(),switchInfo.getReason(),switchInfo.getSwitchid());
        return flag;
    }
    //查询所有信息
    public List<SwitchInfo> getSwitchInfoList(String sql) {
        List<SwitchInfo> switchInfoList= DBUtils.getList(SwitchInfo.class,sql);
        return switchInfoList;
    }
    public void delSwitchInfoById(int id) {
        String sql="delete from tb_switch where switchid="+id;
        DBUtils.update1(sql);
    }

    public List<SwitchInfo> checkSwitchInfo(String tnames){
        String sql = "select * from tb_switch where tname='"+tnames+"'";
        List<SwitchInfo> switchInfoList= DBUtils.getList(SwitchInfo.class,sql);
        return switchInfoList;
    }
}
