package com.example.demo;

public class AppointRecord {

    private String id;
    private String pid;
    private String did;

    public AppointRecord(String id, String pid, String did) {
        this.id = id;
        this.pid = pid;
        this.did = did;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "AppointRecord{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", did='" + did + '\'' +
                '}';
    }
}
