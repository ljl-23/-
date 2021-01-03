package src.com.System.bean;

public class Notice {
    private Integer noticeid;
    private String  nname;
    private String matter;

    public Notice() {
    }

    public Notice(Integer noticeid, String nname, String matter) {
        this.noticeid = noticeid;
        this.nname = nname;
        this.matter = matter;
    }

    public Integer getNoticeid() {
        return noticeid;
    }

    public void setNoticeid(Integer noticeid) {
        this.noticeid = noticeid;
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    @Override
    public String toString() {
        return "notice{" +
                "noticeid=" + noticeid +
                ", nname='" + nname + '\'' +
                ", matter='" + matter + '\'' +
                '}';
    }
}
