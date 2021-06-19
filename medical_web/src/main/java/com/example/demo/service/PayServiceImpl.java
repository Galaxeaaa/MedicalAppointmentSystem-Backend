package com.example.demo.service;

import com.example.demo.PayRecord;
import com.example.demo.dao.PayDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private PayDao payDao;

    public boolean setPayRecord(String userId, String payTime) {
        System.out.println(userId + " pay at "+System.currentTimeMillis());
        String payId = (System.currentTimeMillis()+"");
        PayRecord payRecord = new PayRecord(payId, userId, payTime);
        return payDao.setPayRecord(payRecord);
    }

    public String getLastPayTime(String userId) {

        List<PayRecord> payRecords = payDao.getPayRecord(userId);

        if (payRecords == null || payRecords.size() == 0) {
            System.out.println(userId + "didn't pay before");
            return null;
        }

        String lastPayTime = payRecords.get(0).getTime();
        System.out.println(userId + " last paid at "+ lastPayTime);

        return lastPayTime;
    }

    public boolean lessThan1hr(String userId) {

        List<PayRecord> payRecords = payDao.getPayRecord(userId);

        if (payRecords == null || payRecords.size() == 0) {
            System.out.println(userId + "didn't pay before");
            return false;
        } else {
            String lastPayTime = payRecords.get(0).getTime();
            Timestamp ts = Timestamp.valueOf(lastPayTime);
            Timestamp now = new Timestamp(System.currentTimeMillis());
            long deltaMs = now.getTime() - ts.getTime();
            if (deltaMs > 3600000) {
                return false;
            }
        }
        return true;
    }
}
