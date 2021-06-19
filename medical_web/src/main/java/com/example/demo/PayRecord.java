package com.example.demo;

import java.sql.Timestamp;

public class PayRecord {

    private String payId;
    private String userId;
    private String time;

    public PayRecord(){}

    public PayRecord(String payId, String userId, String time) {
        this.payId = payId;
        this.userId = userId;
        this.time = time;
    }

    public PayRecord(String payId, String userId, Timestamp time) {
        this.payId = payId;
        this.userId = userId;
        this.time = time.toString();
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "PayRecord{" +
                "payId='" + payId + '\'' +
                ", user='" + userId + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
