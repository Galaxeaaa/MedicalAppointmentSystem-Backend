package com.example.demo.dao;

import com.example.demo.JdbcUtils;
import com.example.demo.PayRecord;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

@Mapper
public class PayDaoImpl implements PayDao {

    public boolean setPayRecord(PayRecord payRecord) {
        String sql = "insert into pay (pay_id, usr_id, pay_time) values ('"
                    + payRecord.getPayId() + "' ,'" + payRecord.getUserId() + "' ,'" + payRecord.getTime() + "')";
        try {
            Connection conn = JdbcUtils.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            rs.close();
            stm.close();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return false;
        }
    }

    public List<PayRecord> getPayRecord(String userId) {
        String sql = "select * from pay where usr_id = " + userId + " order by pay_time DESC";
        try {
            List<PayRecord> recordList = new ArrayList<PayRecord>();
            Connection conn = JdbcUtils.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                PayRecord pr = new PayRecord(
                        rs.getString("pay_id"),
                        rs.getString("user_id"),
                        rs.getTimestamp("pay_time")
                );
                recordList.add(pr);
            }

            rs.close();
            stm.close();
            conn.close();
            return recordList;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }
}
