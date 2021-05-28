package com.example.demo;

public class Doctor {
	private String id;
	private String name;
	private String title;
	private String department;
	private String hospital;
	private String medicine;
	private String introduction;
	private String project;
	private String registerID;
	private int registerSum;
	private int score;
	private String evaluate;
	private String email;
	private String tel;
	private String vx;
	private Time registerTime;
	
	public Doctor(String id,String name,String title,String department,String hospital,
	String medicine,String introduction,String project,String registerID,
	Integer registerSum, Integer score,String evaluate,String email,
    String tel,String vx, Time registerTime) {
		this.id=id;
		this.name=name;
		this.title=title;
		this.department=department;
		this.hospital=hospital;
		this.medicine=medicine;
		this.introduction=introduction;
		this.project=project;
		this.registerID=registerID;
		this.registerSum=registerSum;
		this.score=score;
		this.evaluate=evaluate;
		this.tel=tel;
		this.vx=vx;
		this.email=email;
		this.registerTime=registerTime;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getHospital() {
		return hospital;
	}
	
	public String getMedicine() {
		return medicine;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	
	public String getProject() {
		return project;
	}
	
	public String getRegisterID() {
		return registerID;
	}
	
	public int getRegisterSum() {
		return registerSum;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getEvaluate() {
		return evaluate;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getTel() {
		return tel;
	}
	
	public String getVx() {
		return vx;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public Time getRegisterTime() { 
		return registerTime; 
	}
}
