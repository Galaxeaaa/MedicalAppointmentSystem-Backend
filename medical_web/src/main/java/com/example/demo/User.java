package com.example.demo;

import java.sql.Date;
import java.sql.Timestamp;

public class User {
	private String id;
	private String name;
	private String graph;
	private Timestamp birth_date;
	private String gender;
	private String tel;
	private String address;
	

	public User(String id,String name,String graph,Timestamp birth,String gender,String tel,String address) {
		this.id=id;
		this.name=name;
		this.graph=graph;
		this.birth_date=birth;
		this.gender=gender;
		this.tel=tel;
		this.address=address;
		
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getGraph() {
		return graph;
	}
	
	public Timestamp getBirth_date() {
		return birth_date;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getTel() {
		return tel;
	}
	
	public String getAddress() {
		return address;
	}
	
}
