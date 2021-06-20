package com.example.demo.service;

import com.example.demo.AppointRecord;
import com.example.demo.dao.AppointDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointServiceImpl implements AppointService{

    @Autowired
    private AppointDao appointDao;

    public boolean addRecord(String pid, String did) {
        System.out.println("In AppointService: " + pid + " appoint " + did);
        String appointId = (System.currentTimeMillis()+"");
        AppointRecord appointRecord = new AppointRecord(appointId, pid, did);
        return appointDao.insert(appointRecord);
    }

    public boolean removeRecord(String pid, String did) {
        System.out.println("In AppointService: remove(" + pid + ", " + did + ")");
        return appointDao.delete(pid, did);
    }
}
