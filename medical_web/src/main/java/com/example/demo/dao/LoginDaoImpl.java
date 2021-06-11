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
	
	
	 public Boolean Login_usr(@Param("id") String name, @Param("password") String password) {
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

	public Boolean Login_doc(@Param("id") String name, @Param("password") String password) {
		String sql = "select id,password from doctor where id='"+name+"' and password='"+password+"'";
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



	public boolean Register(@Param("name") String name, @Param("password") String password, @Param("tel")String tel) {
		 String sql = "insert into usr(id,password, tel) values ('"+name+"','"+password+"','"+tel+"')";

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
 
	 public Boolean Register_doctor(@Param("name") String name,@Param("password") String password, @Param("tel")String tel,
									@Param("title")String title, @Param("department")String department, @Param("hospital")String hospital) {
		 String sql = "insert into doctor(id,password,tel, registerTime, title, department, hospital) values ('"+name+"','"+password+"','"+tel+"', curdate(), '"+title+"','"+department+"','"+hospital+"')";

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
	 
	 public Boolean Check_name_doctor(@Param("name") String name) {
		 String sql = "select name from doctor where name='"+name+"'";
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
