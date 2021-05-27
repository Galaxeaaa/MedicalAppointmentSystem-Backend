package com.example.demo;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 
 * @Package: com.*.*.interceptor 
 * @ClassName: AdminInterceptor 
 * @Description:拦截器
 * @author: zk
 * @date: 2019年9月19日 下午2:20:57
 */
public class LoginInterceptor implements  HandlerInterceptor {

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("执行了TestInterceptor的preHandle方法");
/*        try {
            //统一拦截（查询当前session是否存在user）(这里user会在每次登陆成功后，写入session)
            Object user=request.getSession().getAttribute("uname");
            if(user!=null){
                return true;
            }
            response.sendRedirect(request.getContextPath() + "/homepage.html");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        return false;
     
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
         System.out.println("执行了TestInterceptor的postHandle方法");
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("执行了TestInterceptor的afterCompletion方法");
    }
    
}