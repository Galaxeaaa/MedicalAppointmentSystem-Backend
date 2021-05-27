package com.example.demo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.*;
import com.example.demo.JdbcUtils;

@Mapper
public class HistoryDaoImpl implements HistoryDao {
	
    public void addHistory(Report report) {
		
		
	}

    

    public void deleteHistory(int id) {
    	
    }

    /**
     * 根据查询数据
     *
     */
    @Override
    public List<History> getHistory(@Param("name") String name){
    	String sql = "select * from user_history where name='"+name+"'";
    		
    	try{
            Connection conn = JdbcUtils.getConnection();
            Statement stm = conn.createStatement();        
            ResultSet rs = stm.executeQuery(sql);
            List<History> reports=new ArrayList<History>();
         
            while(rs.next()){
            	History re=new History(
            			rs.getString("medicalHist"),
            			rs.getString("name"),
            			rs.getString("case_name"),
            			rs.getString("advice"),
            			rs.getString("doctor"),
            			rs.getString("check_state"),
            			rs.getString("op_record"),
            			rs.getString("nur_reocrd")			
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
    

}