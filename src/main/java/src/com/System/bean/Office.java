package src.com.System.bean;

import java.util.Date;

public class Office {
    private Integer offid;
    private String offname;
    private String offpwd;
    private Date offRegisterData;
    public Office() {
        super();
    }
    public Office(Integer offid, String offname, String offpwd, Date offRegisterData) {
        super();
        this.offid = offid;
        this.offname = offname;
        this.offpwd = offpwd;
        this.offRegisterData = offRegisterData;
    }
    public Integer getOffid() {
        return offid;
    }

    public void setOffid(Integer offid) {
        this.offid = offid;
    }

    public String getOffname() {
        return offname;
    }

    public void setOffname(String offname) {
        this.offname = offname;
    }

    public String getOffpwd() {
        return offpwd;
    }

    public void setOffpwd(String offpwd) {
        this.offpwd = offpwd;
    }

    public Date getOffRegisterData() {
        return offRegisterData;
    }

    public void setOffRegisterData(Date offRegisterData) {
        this.offRegisterData = offRegisterData;
    }

    @Override
    public String toString() {
        return "office{" +
                "offid=" + offid +
                ", offname='" + offname + '\'' +
                ", offpwd='" + offpwd + '\'' +
                ", offRegisterData='" + offRegisterData + '\'' +
                '}';
    }
}
