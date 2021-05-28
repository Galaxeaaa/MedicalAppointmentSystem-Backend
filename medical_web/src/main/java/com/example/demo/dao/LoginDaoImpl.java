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

@Mapper
public class LoginDaoImpl implements LoginDao {
	
	
	 public Boolean Login(@Param("id") String name, @Param("password") String password) {
		 String sql = "select id,password from usr where id='"+name+"' and password='"+password+"'";
		 boolean res=false;
	    	try{
	            Connection conn = JdbcUtils.getConnection();
	            Statement stm = conn.createStatement();        
	            ResultSet rs = stm.executeQuery(sql);
	               
	            if(rs.next()) {
	            	res=true;
	            }
	           
	            rs.close();
	            stm.close();
	            conn.close();

	        }catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e);
	            return false;
	        }
	    	if(res) {
	    		return true;
	    	}
	    	else {
	    		return false;
	    	}
	    }
	    
	
	 
	
	 public boolean Register(@Param("name") String name, @Param("password") String password) {
		 String sql = "insert into usr(id,name,password) values (REPLACE(UUID(),'-',''),'"+name+"','"+password+"')";

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
 
		 
	 
	 

	 public Boolean Check_name(@Param("name") String name) {
		 String sql = "select name from usr where name='"+name+"'";
		 boolean res=false;
	    	try{
	            Connection conn = JdbcUtils.getConnection();
	            Statement stm = conn.createStatement();        
	            ResultSet rs = stm.executeQuery(sql);
	                
	            if(rs.next()) {
	            	res=true;
	            }	           
	            rs.close();
	            stm.close();
	            conn.close();
	            
	        }catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e);
	            return false;
	        }
	    	if(res) {
	    		return true;
	    	}
	    	else {
	    		return false;
	    	}
	 }
    

}
