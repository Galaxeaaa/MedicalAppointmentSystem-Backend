package com.example.demo.dao;

import java.sql.Connection;
import java.sql.Date;
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

@Mapper
public class InfoDaoImpl implements InfoDao {
	@Override
	public boolean addInfo(String id,String name,String graph,String birth_date,String gender,String tel,String address) {
    	//id是指用户id
		String sql="update usr set name='"+name+"',birth_date='"+birth_date+"',graph='"+graph+"',gender='"+gender+"',tel='"+tel+"',address='"+address+"' where id='"+id+"'";
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

    


    @Override
    public List<User> getInfo(@Param("id") String id){
    	String sql = "select id,name,graph,birth_date,gender,tel,address from usr where id='"+id+"'";
    		
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
            			rs.getString("vx"),
                        rs.getTime("registerTime")
    			
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
