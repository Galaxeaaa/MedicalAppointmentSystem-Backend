package com.example.demo.service;

import java.util.List;

import com.example.demo.*;

public interface InfoService {
	 List<User> getInfo(String userName);
	 List<Doctor> getInfo_doctor(String userName);
	 
}