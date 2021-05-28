package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.*;

public interface HistoryDao {
	
	 @Insert("insert into usr_history(id,case_name,advice,doctor,check_state,op_record,nur_record) values (#{id},#{case_name},#{advice},#{doctor},#{check_state},#{op_record},#{nur_record})")
	    boolean addHistory(History report);
	 
	 @Select("select * from usr_history where id=#{name}")
	    List<History> getHistory(@Param("name") String name);
	    
}
