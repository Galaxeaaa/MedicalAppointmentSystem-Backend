package com.example.demo.dao;

import com.example.demo.AppointRecord;
import org.apache.ibatis.annotations.Update;

public interface AppointDao {

    @Update("insert into appoint_record (id, user, doctor) values (#{id}, #{pid}, #{did})")
    boolean insert(AppointRecord appointRecord);

    @Update("delete from appoint_record where user = #{pid} and doctor = #{did}")
    boolean delete(String pid, String did);
}
