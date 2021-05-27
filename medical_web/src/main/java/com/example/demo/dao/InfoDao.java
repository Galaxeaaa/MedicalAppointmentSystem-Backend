package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.*;

public interface InfoDao {
	 @Select("select id,name,medicalHist,graph from usr where name=#{name}")
	    List<User> getInfo(@Param("name") String name);
	   
	 @Select("select * from doctor where id=#{id}")
	    List<Doctor> getInfo_doctor(@Param("id") String id);
	   
}
