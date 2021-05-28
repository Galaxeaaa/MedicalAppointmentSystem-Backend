package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.*;

public interface InfoDao {
	 @Select("select id,name,graph,birth_date,gender,tel,address from usr where id=#{id}")
	    List<User> getInfo(@Param("id") String id);
	   
	 @Select("select * from doctor where id=#{id}")
	    List<Doctor> getInfo_doctor(@Param("id") String id);
	   
}
