package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.*;

public interface LoginDao {
	 @Select("select id,password from usr where id=#{id} and password=#{password}")
	 Boolean Login(@Param("id") String name, @Param("password") String password);
	 
	 /* @Select("select * from usr where name=#{name} and password=#{password}")
	 Boolean Login_doctor(@Param("name") String name, @Param("password") String password);
	 */
	 
	 @Insert("insert into usr(id,name,password)  values (REPLACE(UUID(),'-',''),#{name},#{password})")
	 boolean Register(@Param("name") String name, @Param("password") String password);
	 
	 /* @Insert("insert into usr(id,name,password)  values (#{id},#{name),#{password}")
	 Boolean Register_doctor(@Param("id") String id,@Param("name") String name, @Param("password") String password);
	 */
	 @Select("select name from usr_id where name=#{name}")
	 Boolean Check_name(@Param("name") String name);
	 
	 /*@Select("select * from usr where name=#{name}")
	 Boolean Check_name_doctor(@Param("name") String name);*/
	 
	    
}