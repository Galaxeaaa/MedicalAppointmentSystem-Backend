package com.example.demo.controller;

import com.example.demo.*;
import com.example.demo.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/do")
public class InfoController {
    @Autowired
    private InfoServiceImpl infoService;
    
    @RequestMapping(value = "/addinfo", method = RequestMethod.GET)
    public boolean addHistory(@RequestParam(value = "id", required = true) String id,@RequestParam(value = "name", required = true) String name,@RequestParam(value = "graph", required = false) String graph,@RequestParam(value = "birth_date", required = false) String birth_date,@RequestParam(value = "gender", required = false) String gender,@RequestParam(value = "tel", required = false) String tel,@RequestParam(value = "address", required = false) String address) {
        System.out.println("完善个人信息");
        return infoService.addInfo(id,name,graph,birth_date,gender,tel,address);
    }

    @RequestMapping(value = "/getinfo/usr", method = RequestMethod.GET)
    public List<User> getInfo(@RequestParam(value = "id", required = true) String id) {
        System.out.println("患者个人信息");
        
       return infoService.getInfo(id); 
    }
    
    @RequestMapping(value = "/getinfo/doctor", method = RequestMethod.GET)
    public List<Doctor> getInfo_doctor(@RequestParam(value = "id", required = true) String id) {
        System.out.println("医生个人信息");
        
       return infoService.getInfo_doctor(id); 
    }

}
