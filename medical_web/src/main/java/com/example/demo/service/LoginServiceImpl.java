package com.example.demo.service;

import com.example.demo.History;
import com.example.demo.Question;
import com.example.demo.dao.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	 private LoginDao loginDao;

	public List<Question> getQuestions_usr(String id)
	{
		return loginDao.getQuestions_usr(id);
	}

	public Boolean chPswd_usr(String id, String pswd)
	{
		return loginDao.chPswd_usr(id, pswd);
	}

	  public boolean Login_usr(String name,String pwd) {
		 // String sql = "select name,password from usr where name='"+name+"' and password='"+pwd+"'";
		 // System.out.println(sql);
		  Integer res= loginDao.Login_usr(name,pwd);

		  if(res==null)
			  return false;
		  else
			  return true;
		  
	  }
	public boolean Login_doc(String name,String pwd) {
		// String sql = "select name,password from usr where name='"+name+"' and password='"+pwd+"'";
		// System.out.println(sql);
		Integer res= loginDao.Login_doc(name,pwd);

		if(res==null)
			return false;
		else
			return true;

	}
public boolean Register(String name,String pwd, String tel, String question1, String answer1, String question2, String answer2, String question3, String answer3) {
		  
		  return loginDao.Register(name,pwd, tel, question1, answer1, question2, answer2, question3, answer3);
		  
		  
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