package com.example.demo.dao;

import com.example.demo.Report;
import org.apache.ibatis.annotations.*;
//import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface ReportDao {
	/**
     * 新增数据
     */
    @Insert("insert into report(usr_id,usr_name,doctor_id,doctor_name,department,disease,disease_descr,rep_time,reg_state) values (#{usr_id},#{usr_name},#{doctor_id},#{doctor_name},#{department},#{disease},#{disease_descr},#{rep_time},#{reg_state})")
    boolean addReport(Report report);

    /**
     * 删除数据
     */
    @Delete("delete from report where id=#{id}")
    void deleteReport(int id);

    /**
     * 根据查询数据
     *
     */
    @Select("select * from report where usr=#{usr}")
    List<Report> getReports(@Param("usr") String usr, @Param("role") String role, String sql);
    
    @Select("select * from report where doctor_id=#{usr}")
    List<Report> getReports_doctor(@Param("usr") String usr, @Param("role") String role, String sql);

}
