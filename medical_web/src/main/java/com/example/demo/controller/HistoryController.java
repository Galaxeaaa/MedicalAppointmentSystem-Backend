package com.example.demo.controller;

import com.example.demo.*;
import com.example.demo.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/do/history")
public class HistoryController {
    @Autowired
    private HistoryServiceImpl historyService;


    @RequestMapping(value = "/gethistory", method = RequestMethod.GET)
    public List<History> getReports(@RequestParam(value = "name", required = true) String name) {
        System.out.println("查询病历");
        return historyService.getHistory(name);
      
    }

}

