package com.example.demo.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.*;

public interface InfoDao {
	 @Select("select id,name,graph,birth_date,gender,tel,address from usr where id=#{id}")
	    List<User>getInfo(@Param("id") String id);

	@Select("SELECT u.id id,u.name name,u.title title,d.name department ,h.name hospital,u.medicine medicine,u.introduction introduction,u.project project,u.registerID registerID,u.registerSum registerSum, u.score score, u.evaluate evaluate, u.tel tel, u.vx vx, u.email email, u.registerTime registerTime from doctor u, department d, hospital h WHERE u.department=d.id and u.hospital=h.id")
	List<Doctor> getInfo_doctorall();

	@Select("<script>"+
			"SELECT u.id id,u.name name,u.title title,d.name department ,h.name hospital,u.medicine medicine,u.introduction introduction,u.project project,u.registerID registerID,u.registerSum registerSum, u.score score, u.evaluate evaluate, u.tel tel, u.vx vx, u.email email, u.registerTime registerTime from doctor u, department d, hospital h " +
			"<where>" +
			"<choose>"+
			"<when test='name!=\"\"'>"+
			"and u.name=#{name}"+
			"</when>"+
			"<when test='department!=\"\"'>"+
			"and d.name=#{department}"+
			"</when>"+
			"<when test='registerTime!=\"\"'>"+
			"and u.registerTime=#{registerTime}"+
			"</when>"+
			"<when test='hospital!=\"\"'>"+
			"and h.name=#{hospital}"+
			"</when>"+
			"<otherwise>"+
			"</otherwise>"+
			"</choose>"+
			"and u.department=d.id and u.hospital=h.id" +
			"</where>"+
			"</script>")
	List<Doctor> getInfo_doctor(@Param("name") String name,@Param("department") String department,@Param("registerTime") String registerTime,@Param("hospital") String hospital);

	@Select("select id, name, title, department, hospital, medicine, introduction, project, registerID, registerSum, score, evaluate, tel, vx, email, registerTime from doctor where name=#{name}")
	 	List<Doctor> getInfo_doctorname(@Param("name") String name);


	@Select("select registerSum from doctor where id=#{id}")
		int getInfo_isregister(@Param("id") String id);

	 @Update("update usr set name=#{name},graph=#{graph},birth_date=#{birth_date},gender=#{gender},tel=#{tel},address=#{address} where id=#{id}")
	 boolean addInfo_usr(String id,String name,String graph,String birth_date,String gender,String tel,String address);

	@Update("update doctor set registerSum=registerSum+1 where id=#{id}")
	boolean setregister_doc(String id);

	@Update("update doctor set name=#{name},title=#{title}, department=#{department}, hospital=#{hospital}, medicine=#{medicine}, introduction=#{introduction} where id=#{id}")
	boolean addInfo_doc(String id,
						String name,
						String title,
						String department,
						String hospital,
						String medicine,
						String introduction,
						String project,
						String registerID,
						int registerSum,
						int score,
						String evaluate,
						String email,
						String tel,
						String vx,
						Date registerTime);
	   
}
