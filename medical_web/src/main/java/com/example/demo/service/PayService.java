package com.example.demo.service;

public interface PayService {

    boolean setPayRecord(String userId, String payTime);

    String getLastPayTime(String userId);

    boolean lessThan1hr(String userId);
}
