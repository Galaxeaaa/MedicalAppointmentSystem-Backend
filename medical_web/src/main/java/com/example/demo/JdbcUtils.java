package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {

    private static String driver;
    private static String url;
    private static String user;
    private static String pwd;

    static{
        
        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://rm-bp12kfycb566m73686o.mysql.rds.aliyuncs.com:3306/se?characterEcoding=utf-8&"    
		+ "useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
		
        user = "amax";
		
        pwd = "Amax1979!";
    }
    
    
    //获取一个链接mysql的Connection对象
    static public Connection getConnection(){
        
        try {
            Class.forName(driver);
             Connection connection = DriverManager.getConnection(url,user,pwd);
             return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
    /**
     * 释放Mysql资源(毕竟mysql连入个数是有限的)    
     * @param resultSet 结果集
     * @param statement 
     * @param connection 链接
     */
    public static void releaseResc(ResultSet resultSet, Statement statement, Connection connection) {
    
        try {
            if(resultSet!=null){
            resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        try {
            if(statement!=null){
            statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(connection!=null){
            connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
