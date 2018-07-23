package com.hand.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
    private static String driver;
    private static  String url;
    private static  String user;
    private static String password;

    private static ConnectionFactory factory=new ConnectionFactory();

    static {
        Properties config=new Properties();
        try{
            InputStream in=new FileInputStream(new File("Exam1/JdbcConfig.properties"));
            config.load(in);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver=config.getProperty("driver");
        url=config.getProperty("url");
        user=config.getProperty("user");
        password=config.getProperty("password");
    }

    public Connection getConnection(){
        Connection conn=null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,password);
            if(conn!=null){
                return conn;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ConnectionFactory getInstance(){
        return  factory;
    }
}
