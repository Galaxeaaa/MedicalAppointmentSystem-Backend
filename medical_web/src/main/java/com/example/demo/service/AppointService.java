package com.example.demo.service;

public interface AppointService {

    boolean addRecord(String pid, String did);

    boolean removeRecord(String pid, String did);
}
