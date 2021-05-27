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
	
	  public List<User> getInfo(String name) {
		  
		  return infoDao.getInfo(name);
		  		  
	  }
	  
 public List<Doctor> getInfo_doctor(String id) {
		  
		  return infoDao.getInfo_doctor(id);
		  		  
	  }
}