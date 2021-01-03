package src.com.System.bean;

public class SwitchInfo {
    private Integer switchid;
    private String tname;
    private String message;
    private String reason;

    public SwitchInfo() {
    }

    public SwitchInfo(Integer switchid, String tname, String message, String reason) {
        this.switchid = switchid;
        this.tname = tname;
        this.message = message;
        this.reason = reason;
    }

    public Integer getSwitchid() {
        return switchid;
    }

    public void setSwitchid(Integer switchid) {
        this.switchid = switchid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "switchInfo{" +
                "switchid=" + switchid +
                ", tname='" + tname + '\'' +
                ", message='" + message + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
