package com.example.demo.controller;

import com.example.demo.*;
import com.example.demo.service.*;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    @RequestMapping(value = "/getq_usr", method = RequestMethod.GET)
    public List<Question> getQuestions_usr(@RequestParam(value = "id", required = true) String id) {
        System.out.println("usr获得安全问题");

        return loginService.getQuestions_usr(id);
    }

    @RequestMapping(value = "/chpswd_usr", method = RequestMethod.GET)
    public Boolean chPswd_usr(@RequestParam(value = "id", required = true) String id, @RequestParam(value = "newpswd", required = true) String pswd) {
        System.out.println("usr更改密码");

        return loginService.chPswd_usr(id, pswd);
    }
    
    @RequestMapping(value = "/chpswd_doc", method = RequestMethod.GET)
    public Boolean chPswd_doc(@RequestParam(value = "id", required = true) String id, @RequestParam(value = "newpswd", required = true) String pswd) {
        System.out.println("doc更改密码");

        return loginService.chPswd_doc(id, pswd);
    }

    @RequestMapping(value = "/login_usr", method = RequestMethod.GET)
    public boolean Login_usr(@RequestParam(value = "id", required = true) String name,@RequestParam(value = "password", required = true) String password, Map<String,Object> map,HttpServletRequest request) {
        System.out.println("usr登录");
        
        boolean res=loginService.Login_usr(name,password);
        if(res==true) {
        	request.getSession().setAttribute("uname",name);
        	map.put("uname",name);
      
            return true;
        }
        else {
        	request.getSession().invalidate();
        	map.put("msg", "用户名或密码错误");
        	return false;
        }      
    }

    @RequestMapping(value = "/login_doc", method = RequestMethod.GET)
    public boolean Login_doc(@RequestParam(value = "id", required = true) String name,@RequestParam(value = "password", required = true) String password, Map<String,Object> map,HttpServletRequest request) {
        System.out.println("doc登录");

        boolean res=loginService.Login_doc(name,password);
        if(res==true) {
            request.getSession().setAttribute("uname",name);
            map.put("uname",name);

            return true;
        }
        else {
            request.getSession().invalidate();
            map.put("msg", "用户名或密码错误");
            return false;
        }
    }
    
    @RequestMapping(value = "/register_usr", method = RequestMethod.GET)
    public boolean Register(@RequestParam(value = "name", required = true) String name,
                            @RequestParam(value = "password", required = true) String password,
                            @RequestParam(value = "tel", required = true) String tel,
                            @RequestParam(value = "question1", required = true) String question1,
                            @RequestParam(value = "answer1", required = true) String answer1,
                            @RequestParam(value = "question2", required = true) String question2,
                            @RequestParam(value = "answer2", required = true) String answer2,
                            @RequestParam(value = "question3", required = true) String question3,
                            @RequestParam(value = "answer3", required = true) String answer3)
    {
        System.out.println("用户注册");
        if (this.Check_name(name)) {
        	return false;
        }  
        else 
        	return loginService.Register(name,password, tel, question1, answer1, question2, answer2, question3, answer3);
           
    }
    
    @RequestMapping(value = "/register_doc", method = RequestMethod.GET)
    public boolean Register_doc(@RequestParam(value = "name", required = true) String name,@RequestParam(value = "password", required = true) String password,
                                @RequestParam(value = "tel", required = true) String tel,
                                @RequestParam(value = "title", required = true) String title,
                                @RequestParam(value = "department", required = true) String department,
                                @RequestParam(value = "hospital", required = true) String hospital) {
        System.out.println("医生注册");
        if (this.Check_name_doc(name)) {
        	return false;
        }  
        else 
        	return loginService.Register_doc(name,password, tel, title, department, hospital);
           
    }
    
    @RequestMapping(value = "/register_usr/checkname", method = RequestMethod.GET)
    public boolean Check_name(@RequestParam(value = "name", required = true) String name) {
        System.out.println("checkname");
        
       return loginService.Check_name(name);
           
    }
    
    @RequestMapping(value = "/register_doc/checkname", method = RequestMethod.GET)
    public boolean Check_name_doc(@RequestParam(value = "name", required = true) String name) {
        System.out.println("checkname");
        
       return loginService.Check_name_doc(name);
           
    }
    
    @GetMapping(value = "/loginout")
    public boolean loginout(HttpServletRequest request) {

        HttpSession session = request.getSession();

        // 将用户信息从session中删除
        session.removeAttribute("uname");

        Object userInfo = session.getAttribute("uname");
        if (userInfo == null) {
            return true;
        } else {
            return false;
        }
    }
    
    

}

