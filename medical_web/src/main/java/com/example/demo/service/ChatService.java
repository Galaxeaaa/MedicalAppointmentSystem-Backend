package com.example.demo.service;

import com.example.demo.Doctor;
import com.example.demo.Message;
import com.example.demo.User;

import java.util.List;

public interface ChatService {
    boolean connect(String pid, String did);
    boolean disconnect(String pid, String did);
    List<Doctor> getDoctorList(String id);
    List<User> getPatientList(String id);
    boolean sendMessage(String src_id,  String name, String dest_id, String content,String time,String type);
    List<Message> askMessage(String id);
    List<Message> getHistoryMsg(String selfid, String id);
}
