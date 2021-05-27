package com.example.demo;


import java.sql.Time;

public class History {
	private String medicalHist;
	private String name;
	private String case_name;
	private String advice;
	private String doctor;
	private String check_state;
	private String op_record;
	private String nur_record;
	
	public History(String medicalHist,String name,String case_name, String advice, String doctor,String check_state, String op_record, String nur_record) {
		this.medicalHist=medicalHist;
		this.name=name;
		this.case_name=case_name;
		this.advice=advice;
		this.doctor=doctor;
		this.check_state=check_state;
		this.op_record=op_record;
		this.nur_record=nur_record;
		
	}
	
	public String getMedicalHist() {
		return this.medicalHist;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCase_name() {
		return this.case_name;
	}
	
	public String getDoctor() {
		return this.doctor;
	}
	
	
	public String getAdvice() {
		return this.advice;
	}
	
	
	public String getCheck_state() {
		return this.check_state;
	}
	
	public String getOp_record() {
		return this.op_record;
	}
	
	public String getNur_record() {
		return this.nur_record;
	}
	
}
