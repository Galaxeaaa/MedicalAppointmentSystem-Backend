package com.example.demo.service;

import com.example.demo.Report;
import com.example.demo.dao.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	 private ReportDao reportDao;
	
	
	 public boolean addReport(Report  report) {
		 return reportDao.addReport(report);
	 }

	 public boolean deleteReport(int id) {
		 return true;
	 }

	  public List<Report> getReports(String usr,String role) {
		  
		  String sql;
		  if(role.equals("doctor")) {
	    		sql = "select * from report where doctor_id='"+usr+"'";
	    		return reportDao.getReports_doctor(usr,role,sql);
	    	}
	    	else {
	    		sql = "select * from report where usr_id='"+usr+"'";
	    		return reportDao.getReports(usr,role,sql);
	    	}
		
		  
	  }
}
