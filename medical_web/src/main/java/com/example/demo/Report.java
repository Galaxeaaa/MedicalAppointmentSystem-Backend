package com.example.demo;

import java.sql.Time;
import java.sql.Timestamp;

public class Report {
	private int id;
	private String usr_id;
	private String usr_name;
	private String doctor_id;
	private String doctor_name;
	private String department;
	private String disease;
	private String disease_descr;
	private String rep_time;
	private Boolean reg_state;
	
	public Report(Integer id,String usr_id,String usr_name,String doctor_id,String doctor_name,String department,String disease, String disease_descr,Timestamp rep_time,Boolean reg_state) {
		this.id=id;
		this.usr_id=usr_id;
		this.usr_name=usr_name;
		this.department=department;
		this.doctor_id=doctor_id;
		this.doctor_name=doctor_name;
		this.disease=disease;
		this.disease_descr=disease_descr;
		this.reg_state=reg_state;
//		this.rep_time=rep_time.replace('/','-');
		this.rep_time=rep_time.toString();
	}
	
	public String getUser_id() {
		return this.usr_id;
	}
	
	public String getUsr_name() {
		return this.usr_name;
	}
	
	public String getDoctor_id() {
		return this.doctor_id;
	}
	
	public String getDoctor_name() {
		return this.doctor_name;
	}
	
	public String getDepartment() {
		return this.department;
	}
	
	
	public String getDisease() {
		return this.disease;
	}
	
	
	public String getDisease_descr() {
		return this.disease_descr;
	}
	
	public String getRep_time() {
		return this.rep_time;
	}
	
	public Boolean getReg_state() {
		return this.reg_state;
	}
	
}
