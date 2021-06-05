package com.example.demo.dao;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.example.demo.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatDaoImpl implements ChatDao{

    @Override
    public List<Doctor> getDoctorList(@Param("id") String id){
        String sql = "select * from doctor";

        try{
            Connection conn = JdbcUtils.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Doctor> reports=new ArrayList<Doctor>();

            while(rs.next()){
                Doctor re=new Doctor(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("title"),
                        rs.getString("department"),
                        rs.getString("hospital"),
                        rs.getString("medicine"),
                        rs.getString("introduction"),
                        rs.getString("project"),
                        rs.getString("registerID"),
                        rs.getInt("registerSum"),
                        rs.getInt("score"),
                        rs.getString("evaluate"),
                        rs.getString("email"),
                        rs.getString("tel"),
                        rs.getString("vx"),
                        rs.getDate("registerTime")
                );
                reports.add(re);
            }
            rs.close();
            stm.close();
            conn.close();

            return reports;
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }

    public List<User> getPatientList(String id){
        String sql = "select id,name,graph,birth_date,gender,tel,address from usr ";

        try{
            Connection conn = JdbcUtils.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<User> reports=new ArrayList<User>();

            while(rs.next()){
                User re=new User(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("graph"),
                        rs.getTimestamp("birth_date"),
                        rs.getString("gender"),
                        rs.getString("tel"),
                        rs.getString("address")
                );
                reports.add(re);
            }

            rs.close();
            stm.close();
            conn.close();

            return reports;
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }


    public boolean sendMessage(Message msg){
        String sql="insert into message(msgid, src, dest, content, msg_time, type) values ('"+msg.getMsgid()+"','"+msg.getSrc()+"','"+msg.getDest()+"','"+msg.getContent()+"',NOW(),'"+msg.getType()+"')";
        try{
            Connection conn = JdbcUtils.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            rs.close();
            stm.close();
            conn.close();

            return true;
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return false;
        }
    }
    
    public List<Message> getHistoryMsg(String selfid, String id){
        String sql = "select msgid, src, dest, content, msg_time, type from message where (src == '"+selfid+"' and dest = '"+id+"') or  (src == '"+id+"' and dest = '"+selfid+"') order by msg_time";
        try{
            Connection conn = JdbcUtils.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Message> historyMsg=new ArrayList<Message>();

            while(rs.next()){
                Message msg = new Message(
                        rs.getString("src"),
                        rs.getString("dest"),
                        rs.getString("content"),
                        rs.getTimestamp("msg_time"),
                        rs.getString("type")
                );

                historyMsg.add(msg);
            }

            rs.close();
            stm.close();
            conn.close();

            return historyMsg;
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return null;
        }

    }
}
