package com.example.demo.service;

import java.util.List;

import com.example.demo.*;

public interface InfoService {
	 List<User> getInfo(String userName);
	 List<Doctor> getInfo_doctor(String userName);
	 boolean addInfo(String id,String name,String graph,String birth_date,String gender,String tel,String address);
		 
	 
}