package com.example.demo.dao;

import com.example.demo.AppointRecord;
import com.example.demo.JdbcUtils;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Mapper
public class AppointDaoImpl implements AppointDao {

    public boolean insert(AppointRecord appointRecord) {
        String sql = "insert into appoint_record (id, user, doctor) values ('"
                    + appointRecord.getId() + "' ,'"
                    + appointRecord.getPid() + "' ,'"
                    + appointRecord.getDid() + "')";
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

    public boolean delete(String pid, String did) {
        String sql = "delete from appoint_record where user = " + pid + " and doctor = " + did;
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
}
