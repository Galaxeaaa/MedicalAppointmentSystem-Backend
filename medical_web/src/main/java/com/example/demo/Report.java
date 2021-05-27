package com.example.demo;

import java.sql.Time;
import java.sql.Timestamp;

public class Report {
	private String id;
	private String usr;
	private String doctor;
	private String doctor_name;
	private String department;
	private String disease;
	private String disease_descr;
	private Timestamp rep_time;
	private Boolean reg_state;
	
	public Report(String id,String usr,String doctor, String doctor_name,String department,String disease, String disease_descr,Timestamp rep_time,Boolean reg_state) {
		this.id=id;
		this.usr=usr;
		this.department=department;
		this.doctor=doctor;
		this.doctor_name=doctor_name;
		this.disease=disease;
		this.disease_descr=disease_descr;
		this.reg_state=reg_state;
		this.rep_time=rep_time;
		
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getUsr() {
		return this.usr;
	}
	
	public String getDoctor() {
		return this.doctor;
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
	
	public Timestamp getRep_time() {
		return this.rep_time;
	}
	
	public Boolean getReg_state() {
		return this.reg_state;
	}
	
}
