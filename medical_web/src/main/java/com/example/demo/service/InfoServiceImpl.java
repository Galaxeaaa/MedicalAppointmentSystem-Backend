package com.example.demo.service;

import com.example.demo.*;
import com.example.demo.dao.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {
	@Autowired
	 private InfoDao infoDao;
	
	public 	 boolean addInfo_usr(String id,String name,String graph,String birth_date,String gender,String tel,String address) {
		return infoDao.addInfo_usr(id,name,graph,birth_date,gender,tel,address);
	}
	public 	 boolean addInfo_doc(String id,String name,String graph,String birth_date,String gender,String tel,String address) {
		return infoDao.addInfo_doc(id,name,graph,birth_date,gender,tel,address);
	}
	
	  public List<User> getInfo(String name) {
		  
		  return infoDao.getInfo(name);
		  		  
	  }
	  
 public List<Doctor> getInfo_doctor(String id) {
		  
		  return infoDao.getInfo_doctor(id);
		  		  
	  }
}