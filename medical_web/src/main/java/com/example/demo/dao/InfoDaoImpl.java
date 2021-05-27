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
public class InfoDaoImpl implements InfoDao {

    @Override
    public List<User> getInfo(@Param("name") String name){
    	String sql = "select id,name,medicalHist,graph from usr where name='"+name+"'";
    		
    	try{
            Connection conn = JdbcUtils.getConnection();
            Statement stm = conn.createStatement();        
            ResultSet rs = stm.executeQuery(sql);
            List<User> reports=new ArrayList<User>();
         
            while(rs.next()){
            	User re=new User(
            			rs.getString("id"),
            			rs.getString("name"),
            			rs.getString("medicalHist"),
            			rs.getString("graph")			
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
    
    
    @Override
    public List<Doctor> getInfo_doctor(@Param("id") String id){
    	String sql = "select * from doctor where id='"+id+"'";
    		
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
            			rs.getString("vx")
    			
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
