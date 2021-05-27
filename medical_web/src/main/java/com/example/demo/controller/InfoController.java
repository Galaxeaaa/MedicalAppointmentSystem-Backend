package com.example.demo.controller;

import com.example.demo.*;
import com.example.demo.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/do/getinfo")
public class InfoController {
    @Autowired
    private InfoServiceImpl infoService;

    @RequestMapping(value = "/usr", method = RequestMethod.GET)
    public List<User> getInfo(@RequestParam(value = "name", required = true) String name) {
        System.out.println("患者个人信息");
        
       return infoService.getInfo(name); 
    }
    
    @RequestMapping(value = "/doctor", method = RequestMethod.GET)
    public List<Doctor> getInfo_doctor(@RequestParam(value = "id", required = true) String id) {
        System.out.println("医生个人信息");
        
       return infoService.getInfo_doctor(id); 
    }

}
