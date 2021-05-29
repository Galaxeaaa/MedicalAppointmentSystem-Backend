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

import com.example.demo.Report;
import com.example.demo.JdbcUtils;

@Mapper
public class ReportDaoImpl implements ReportDao {
	
    public boolean addReport(Report report) {
    	 	String sql = "insert into report(usr_id,usr_name,doctor_id,doctor_name,department,disease,disease_descr,rep_time,reg_state) values ('"+report.getUser_id()+"','"+report.getUsr_name()+"','"+report.getDoctor_id()+"','"+report.getDoctor_name()+"','"+report.getDepartment()+"','"+report.getDisease()+"','"+report.getDisease_descr()+"','"+report.getRep_time().toString().replace('/', '-')+"',"+report.getReg_state()+")";
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

    

    public void deleteReport(int id) {
    	
    }

    /**
     * 根据查询数据
     *
     */
    @Override
    public List<Report> getReports(@Param("usr") String usr, @Param("role") String role, String sqll){
    		
    	try{
            Connection conn = JdbcUtils.getConnection();
            Statement stm = conn.createStatement();        
            ResultSet rs = stm.executeQuery(sqll);
            List<Report> reports=new ArrayList<Report>();
         
            while(rs.next()){
            	Report re=new Report(
            			rs.getInt("id"),
            			rs.getString("usr_id"),
            			rs.getString("usr_name"),
            			rs.getString("doctor_id"),
            			rs.getString("doctor_name"),
            			rs.getString("department"),
            			rs.getString("disease"),
            			rs.getString("disease_descr"),
//            			rs.getTimestamp("rep_time").toString(),
						rs.getTimestamp("rep_time"),
            			rs.getBoolean("reg_state")			
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
    public List<Report> getReports_doctor(@Param("usr") String usr, @Param("role") String role, String sqll){
    	try{
            Connection conn = JdbcUtils.getConnection();
            Statement stm = conn.createStatement();        
            ResultSet rs = stm.executeQuery(sqll);
            List<Report> reports=new ArrayList<Report>();
         
            while(rs.next()){
            	Report re=new Report(
            			rs.getInt("id"),
            			rs.getString("usr_id"),
            			rs.getString("usr_name"),
            			rs.getString("doctor_id"),
            			rs.getString("doctor_name"),
            			rs.getString("department"),
            			rs.getString("disease"),
            			rs.getString("disease_descr"),
//            			rs.getTimestamp("rep_time").toString(),
						rs.getTimestamp("rep_time"),
            			rs.getBoolean("reg_state")			
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
