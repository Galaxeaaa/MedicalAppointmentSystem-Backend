package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.*;

public interface LoginDao {
	 @Select("select id,password from usr where id=#{id} and password=#{password}")
	 Boolean Login_usr(@Param("id") String name, @Param("password") String password);

	@Select("select id,password from doctor where id=#{id} and password=#{password}")
	Boolean Login_doc(@Param("id") String name, @Param("password") String password);
	 
	 
	 @Insert("insert into usr(id,password, tel)  values (#{name},#{password}, #{tel})")
	 boolean Register(@Param("name") String name, @Param("password") String password, @Param("tel") String tel);
	 
	 @Insert("insert into doctor(id,password, tel, registerTime, title, department, hospital)  values (#{name},#{password}, #{tel}, curdate(), #{title}, #{department}, #{hospital})")
	 Boolean Register_doctor(@Param("name") String name,@Param("password") String password, @Param("tel") String tel,
							 @Param("title")String title, @Param("department")String department, @Param("hospital")String hospital);
	 
	
	 @Select("select name from usr where id=#{name}")
	 Boolean Check_name(@Param("name") String name);
	 
	 @Select("select name from doctor where id=#{name}")
	 Boolean Check_name_doctor(@Param("name") String name);
	 
	    
}