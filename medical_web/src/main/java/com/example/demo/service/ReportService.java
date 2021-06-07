package com.example.demo.service;

import java.util.List;

import com.example.demo.Report;


public interface ReportService {
    
    boolean addReport(Report  report);

    boolean delReport(int id);

    List<Report> getReports(String userName, String role);


}

