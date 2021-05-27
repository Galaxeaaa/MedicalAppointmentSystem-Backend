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
	
	
	  public boolean Login(String name,String pwd) {
		 // String sql = "select name,password from usr where name='"+name+"' and password='"+pwd+"'";
		 // System.out.println(sql);
		  Boolean res= loginDao.Login(name,pwd);

		  if(res==null)
			  return false;
		  else
			  return true;
		  
	  }
public boolean Register(String name,String pwd) {
		  
		  return loginDao.Register(name,pwd);
		  
		  
	  }
public boolean Check_name(String name) {
	  
	  Boolean res= loginDao.Check_name(name);
	  if(res==null)
		  return false;
	  else
		  return true;
	  
	  
}
}