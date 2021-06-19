package com.example.demo.dao;

import com.example.demo.JdbcUtils;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Mapper
public class ScoreDaoImpl implements ScoreDao {

    public boolean setScore(String did, String score) {
        String sql = "update doctor set score = score + " + score + ", scoreNum = scoreNum + 1 where id = " + did;
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
