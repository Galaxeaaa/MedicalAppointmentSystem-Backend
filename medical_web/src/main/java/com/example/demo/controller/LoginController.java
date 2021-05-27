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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public boolean Login(@RequestParam(value = "name", required = true) String name,@RequestParam(value = "password", required = true) String password, Map<String,Object> map,HttpServletRequest request) {
        System.out.println("登录");
        
        boolean res=loginService.Login(name,password);
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
    
    @RequestMapping(value = "/register/checkname", method = RequestMethod.GET)
    public boolean Check_name(@RequestParam(value = "name", required = true) String name) {
        System.out.println("checkname");
        
       return loginService.Check_name(name);
           
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

