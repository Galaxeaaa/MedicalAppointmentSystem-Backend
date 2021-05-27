package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.*;

public interface HistoryDao {
	 @Select("select * from usr_history where name=#{name}")
	    List<History> getHistory(@Param("name") String name);
	    
}
