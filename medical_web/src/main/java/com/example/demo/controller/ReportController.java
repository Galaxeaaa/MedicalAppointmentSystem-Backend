package com.example.demo.controller;

import com.example.demo.Report;
import com.example.demo.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/do/report")
public class ReportController {
    @Autowired
    private ReportServiceImpl reportService;

    @RequestMapping(value = "/addreport", method = RequestMethod.POST)
    public boolean addReport(@RequestBody Report report) {
        System.out.println("新增报告单");
        return reportService.addReport(report);
    }
/*
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam(value = "id", required = true) int Id) {
        System.out.println("删除数据：");
        return userService.deleteUser(Id);
    }*/


    @RequestMapping(value = "/getreports", method = RequestMethod.GET)
    public List<Report> getReports(@RequestParam(value = "usr", required = false) String usr, @RequestParam(value = "role", required = true) String role) {
        System.out.println("查询报告单：");
        
       return reportService.getReports(usr,role);
  
      
    }

}
