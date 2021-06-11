package com.example.demo.service;

import com.example.demo.History;
import com.example.demo.dao.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	 private LoginDao loginDao;
	
	
	  public boolean Login_usr(String name,String pwd) {
		 // String sql = "select name,password from usr where name='"+name+"' and password='"+pwd+"'";
		 // System.out.println(sql);
		  Boolean res= loginDao.Login_usr(name,pwd);

		  if(res==null)
			  return false;
		  else
			  return true;
		  
	  }
	public boolean Login_doc(String name,String pwd) {
		// String sql = "select name,password from usr where name='"+name+"' and password='"+pwd+"'";
		// System.out.println(sql);
		Boolean res= loginDao.Login_doc(name,pwd);

		if(res==null)
			return false;
		else
			return true;

	}
public boolean Register(String name,String pwd, String tel) {
		  
		  return loginDao.Register(name,pwd, tel);
		  
		  
	  }
public boolean Register_doc(String name,String pwd, String tel, String title, String department, String hospital) {
	  
	  return loginDao.Register_doctor(name,pwd, tel, title, department, hospital);
	  
	  
}
public boolean Check_name(String name) {
	  
	  Boolean res= loginDao.Check_name(name);
	  if(res==null)
		  return false;
	  else
		  return true;
	  
	  
}
public boolean Check_name_doc(String name) {
	  
	  Boolean res= loginDao.Check_name_doctor(name);
	  if(res==null)
		  return false;
	  else
		  return true;
	  
	  
}
}