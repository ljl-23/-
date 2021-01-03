package src.com.System.dao;

import src.com.System.bean.Office;
import src.com.System.utils.DBUtils;

public class OfficeDAO {

    public Office getUserByofficeid(String email, String password) {
        String sql="SELECT \n" +
                "tb_office.offid,\n" +
                "tb_office.offemail,\n" +
                "tb_office.offpwd,\n" +
                "tb_office.offRegisterData\n" +
                " FROM \n" +
                "tb_office where offemail=? and offpwd=?";
        return DBUtils.getSingleObj(Office.class,sql,email,password);
    }

    public Integer selectOfficeEmailCount(String email) {
        String  sql="select count(*) from tb_office a where a.offemail = ?";
        Integer count = DBUtils.getCount(sql,email);
        return count;
    }

    public boolean saveOffice(Office office) {
        String sql = "insert into tb_office(offemail,offpwd,offRegisterData)"
                + "values(?,?,?)";
        return DBUtils.save(sql,office.getOffname(),office.getOffpwd(),office.getOffRegisterData());
    }
}
