package com.example.demo.service;

import java.sql.Date;
import java.util.List;

import com.example.demo.*;

public interface InfoService {
	 List<User> getInfo(String userName);
	 List<Doctor> getInfo_doctor(String userName);
	 boolean addInfo_usr(String id,String name,String graph,String birth_date,String gender,String tel,String address);
	boolean addInfo_doc(String id,
			String name,
			String title,
			String department,
			String hospital,
			String medicine,
			String introduction,
			String project,
			String registerID,
			int registerSum,
			int score,
			String evaluate,
			String email,
			String tel,
			String vx,
			Date registerTime);

	boolean chpswd(boolean isdoc, String id, String newpswd);

	 
}