package com.example.demo;

public class User {
	private String id;
	private String name;
	private String medicalHist;
	private String graph;

	public User(String id,String name,String medicalHist,String graph) {
		this.id=id;
		this.name=name;
		this.medicalHist=medicalHist;
		this.graph=graph;
		
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMedicalHist() {
		return medicalHist;
	}
	
	public String getGraph() {
		return graph;
	}
	
}
