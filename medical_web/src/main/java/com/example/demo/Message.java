package com.example.demo;

import java.sql.Timestamp;

public class Message {

    private String msgid;
    private String src;
    private String name = "";
    private String dest;
    private String content;
    private String msg_time;
    private String type;

    public Message(){}

    public Message(String src_id, String name, String dest_id, String content,String time,String type) {
        this.src = src_id;
        this.name = name;
        this.dest = dest_id;
        this.content = content;
        this.msg_time = time;
        this.type = type;
    }

    public Message(String src_id, String dest_id, String content, Timestamp time, String type) {
        this.src = src_id;
        this.dest = dest_id;
        this.content = content;
        this.msg_time = time.toString();
        this.type = type;
    }

    public boolean isMatch(String id){
        return id.equals(dest);
    }

    public void setMsg_id(String msg_id) {
        this.msgid = msg_id;
    }

    public void setMsg_time(String msg_time) {
        this.msg_time = msg_time;
    }

    public String getMsgid() {
        return msgid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getSrc() {
        return src;
    }

    public String getDest() {
        return dest;
    }

    public String getMsg_time() {
        return msg_time;
    }

    public String getType() {
        return type;
    }
}
