package chauncy.bean;

import java.sql.Timestamp;

public class CWallData {
    private int did;//数据编号
    private Timestamp start_time;//开始时间
    private Timestamp end_time;//结束时间
    private String diy_text;//自定义字段
    private String content;//表白内容
    private String contact;//联系方式
    private String song;//点歌

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }

    public String getDiy_text() {
        return diy_text;
    }

    public void setDiy_text(String diy_text) {
        this.diy_text = diy_text;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }
}
