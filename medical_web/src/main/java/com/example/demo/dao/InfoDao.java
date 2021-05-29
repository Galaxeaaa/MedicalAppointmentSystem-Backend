package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.*;

public interface InfoDao {
	 @Select("select id,name,graph,birth_date,gender,tel,address from usr where id=#{id}")
	    List<User>getInfo(@Param("id") String id);
	   
	 @Select("select * from doctor where id=#{id}")
	    List<Doctor> getInfo_doctor(@Param("id") String id);
	 
	 @Update("update usr set name=#{name},graph=#{graph},birth_date=#{birth_date},gender=#{gender},tel=#{tel},address=#{address} where id=#{id}")
	 boolean addInfo_usr(String id,String name,String graph,String birth_date,String gender,String tel,String address);

	@Update("update doctor set name=#{name},graph=#{graph},birth_date=#{birth_date},gender=#{gender},tel=#{tel},address=#{address} where id=#{id}")
	boolean addInfo_doc(String id,String name,String graph,String birth_date,String gender,String tel,String address);
	   
}
