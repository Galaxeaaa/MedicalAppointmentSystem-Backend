package com.example.demo.dao;

import com.example.demo.PayRecord;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PayDao {

    @Update("insert into pay (pay_id, usr_id, pay_time) values (#{payId} ,#{userId} ,#{payTime})")
    boolean setPayRecord(PayRecord payRecord);

    @Select("select * from pay where usr_id = #{userId} order by pay_time DESC")
    List<PayRecord> getPayRecord(@Param("userId") String userId);
}
