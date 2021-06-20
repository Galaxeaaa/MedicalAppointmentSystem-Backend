package com.example.demo.controller;
import  java.sql.Date;
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
    
    @RequestMapping(value = "/addinfo/usr", method = RequestMethod.GET)
    public boolean addHistory_usr(@RequestParam(value = "id", required = true) String id,@RequestParam(value = "name", required = true) String name,@RequestParam(value = "graph", required = false) String graph,@RequestParam(value = "birth_date", required = false) String birth_date,@RequestParam(value = "gender", required = false) String gender,@RequestParam(value = "tel", required = false) String tel,@RequestParam(value = "address", required = false) String address) {
        System.out.println("usr完善个人信息");
        return infoService.addInfo_usr(id,name,graph,birth_date,gender,tel,address);
    }

    @RequestMapping(value = "/addinfo/doctor", method = RequestMethod.GET)
    public boolean addHistory_doc(
            @RequestParam(value="id", required = true) String id,
            @RequestParam(value="name", required = true) String name,
            @RequestParam(value="title", required = true) String title,
            @RequestParam(value="department", required = true) String department,
            @RequestParam(value="hospital", required = true) String hospital,
            @RequestParam(value="medicine", required = true) String medicine,
            @RequestParam(value="introduction", required = true) String introduction,
            @RequestParam(value="project", required = true) String project,
            @RequestParam(value="registerID", required = true) String registerID,
            @RequestParam(value="registerSum", required = true) int registerSum,
            @RequestParam(value="score", required = true) int score,
            @RequestParam(value="evaluate", required = true) String evaluate,
            @RequestParam(value="tel", required = true) String email,
            @RequestParam(value="vx", required = true) String tel,
            @RequestParam(value="email", required = true) String vx,
            @RequestParam(value="registerTime", required = true) Date registerTime
    ){
        System.out.println("doc完善个人信息");
        return infoService.addInfo_doc(id, name, title, department, hospital, medicine, introduction, project, registerID, registerSum, score, evaluate, tel, vx, email, registerTime);
    }

    @RequestMapping(value = "/addinfo/setregister", method = RequestMethod.GET)
    public boolean setregister_doc(
            @RequestParam(value="id", required = true) String id

    ){
        System.out.println("doc完善个人信息");
        return infoService.setregister_doc(id);
    }

    @RequestMapping(value = "/getinfo/usr", method = RequestMethod.GET)
    public List<User> getInfo(@RequestParam(value = "id", required = true) String id) {
        System.out.println("患者个人信息");
        
       return infoService.getInfo(id); 
    }
    
    @RequestMapping(value = "/getinfo/doctor", method = RequestMethod.GET)
    public List<Doctor> getInfo_doctor(@RequestParam(value = "name", required = true) String name,@RequestParam(value = "department", required = true) String department) {
        System.out.println("医生个人信息");
        
       return infoService.getInfo_doctor(name,department);
    }

    @RequestMapping(value = "/getinfo/doctorall", method = RequestMethod.GET)
    public List<Doctor> getInfo_doctorall() {
        System.out.println("所有医生个人信息");

        return infoService.getInfo_doctorall();
    }

    @RequestMapping(value = "/getinfo/doctorname", method = RequestMethod.GET)
    public List<Doctor> getInfo_doctorname(@RequestParam(value = "name", required = true) String name) {
        System.out.println("医生个人信息");

        return infoService.getInfo_doctorname(name);
    }



    @RequestMapping(value = "/getinfo/isregister", method = RequestMethod.GET)
    public int getInfo_isregister(@RequestParam(value = "id", required = true) String id) {
        System.out.println("医生个人信息");

        return infoService.getInfo_isregister(id);
    }
}
