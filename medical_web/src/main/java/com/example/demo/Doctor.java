package com.example.demo;
import java.sql.Date;

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
	private Date registerTime;
	
	public Doctor(String id,String name,String title,String department,String hospital,
	String medicine,String introduction,String project,String registerID,
	Integer registerSum, Integer score,String evaluate,String email,
    String tel,String vx, Date registerTime) {
		this.id=id;
		this.name=name==null ? "" : name;
		this.title=title==null ? "" : title;
		this.department=department==null ? "" : department;
		this.hospital=hospital==null ? "" : hospital;
		this.medicine=medicine==null ? "" : medicine;
		this.introduction=introduction==null ? "" : introduction;
		this.project=project==null ? "" : project;
		this.registerID=registerID==null ? "" : registerID;
		this.registerSum=registerSum==null ? 0 : registerSum;
		this.score=score==null ? 0 : score;
		this.evaluate=evaluate==null ? "" : evaluate;
		this.tel=tel==null ? "" : tel;
		this.vx=vx==null ? "" : vx;
		this.email=email==null ? "" : email;
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
	
	public Date getRegisterTime() {
		return registerTime; 
	}
}
