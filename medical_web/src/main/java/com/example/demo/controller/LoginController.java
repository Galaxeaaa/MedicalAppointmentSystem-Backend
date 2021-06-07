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
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public boolean Register(@RequestParam(value = "name", required = true) String name,@RequestParam(value = "password", required = true) String password) {
        System.out.println("注册");
        if (this.Check_name(name)) {
        	return false;
        }  
        else 
        	return loginService.Register(name,password);
           
    }
    
    @RequestMapping(value = "/register_doc", method = RequestMethod.GET)
    public boolean Register_doc(@RequestParam(value = "name", required = true) String name,@RequestParam(value = "password", required = true) String password) {
        System.out.println("医生注册");
        if (this.Check_name_doc(name)) {
        	return false;
        }  
        else 
        	return loginService.Register(name,password);
           
    }
    
    @RequestMapping(value = "/register/checkname", method = RequestMethod.GET)
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

