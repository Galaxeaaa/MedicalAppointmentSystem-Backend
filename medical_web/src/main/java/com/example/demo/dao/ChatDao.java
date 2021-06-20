package com.example.demo.dao;

import com.example.demo.Doctor;
import com.example.demo.Message;
import com.example.demo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ChatDao {

    @Select("select id, name, graph, birth_date, gender, tel, address from usr where id in (select user from appoint_record where doctor = #{id})")
    List<User> getPatientList(@Param("id") String id);

    @Select("select id, name, title, department, hospital, medicine, introduction, project, registerID, registerSum, score, evaluate, tel, vx, email, registerTime from doctor where id in (select doctor from appoint_record where user = #{id})")
    List<Doctor> getDoctorList(@Param("id") String id);

    @Update("insert into message(msgid, src, dest, content, msg_time, type) values (#{msgid},#{src},#{dest},#{content},NOW(),#{type})")
    boolean sendMessage(Message msg);

    @Select("select msgid, src, dest, content, msg_time, type from message where (src = #{selfid} and dest = #{id}) or  (src = #{id} and dest = #{selfid}) order by msg_time")
    List<Message> getHistoryMsg(String selfid, String id);

}
