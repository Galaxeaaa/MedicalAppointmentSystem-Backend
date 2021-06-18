package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.*;

public interface LoginDao {
	@Select("select question1, answer1, question2, answer2, question3, answer3 from usr where id=#{id}")
	List<Question> getQuestions_usr(@Param("id") String name);

	@Select("update usr set password=#{password} where id=#{id}")
	Boolean chPswd_usr(@Param("id") String name, @Param("password") String pswd);
	
	@Select("update doctor set password=#{password} where id=#{id}")
	Boolean chPswd_doc(@Param("id") String name, @Param("password") String pswd);

	 @Select("select count(*) as cnt from usr where id=#{id} and password=#{password}")
	 Integer Login_usr(@Param("id") String id, @Param("password") String password);

	@Select("select count(*) as cnt from doctor where id=#{id} and password=#{password}")
	Integer Login_doc(@Param("id") String name, @Param("password") String password);
	 
	 
	 @Insert("insert into usr(id,password, tel, question1, answer1, question2, answer2, question3, answer3)  values (#{name},#{password}, #{tel}, #{question1}, #{answer1}, #{question2}, #{answer2}, #{question3}, #{answer3})")
	 boolean Register(@Param("name") String name, @Param("password") String password, @Param("tel") String tel, @Param("question1") String question1, @Param("answer1") String answer1, @Param("question2") String question2, @Param("answer2") String answer2, @Param("question3") String question3, @Param("answer3") String answer3);
	 
	 @Insert("insert into doctor(id,password, tel, registerTime, title, department, hospital)  values (#{name},#{password}, #{tel}, curdate(), #{title}, #{department}, #{hospital})")
	 Boolean Register_doctor(@Param("name") String name,@Param("password") String password, @Param("tel") String tel,
							 @Param("title")String title, @Param("department")String department, @Param("hospital")String hospital);
	 
	
	 @Select("select name from usr where id=#{name}")
	 Boolean Check_name(@Param("name") String name);
	 
	 @Select("select name from doctor where id=#{name}")
	 Boolean Check_name_doctor(@Param("name") String name);
	 
	    
}
