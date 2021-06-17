package com.example.demo.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.History;

public interface LoginService {
	 boolean Login_doc(String userName,String pwd);
	 boolean Login_usr(String userName,String pwd);
	 boolean Check_name(String name);
	 boolean Check_name_doc(String name);
	 boolean Register(String name,String pwd, String tel, String question1, String answer1, String question2, String answer2, String question3, String answer3);
	 boolean Register_doc(String name,String pwd, String tel, String title, String department, String hospital);
	 
}