package com.hand;

import com.hand.dao.UserDao;
import com.hand.daoImpl.UserDaoImpl;
import com.hand.entity.City;
import com.hand.util.ConnectionFactory;

import java.sql.*;
import java.util.List;

public class MainOne {
    public static void main(String[] args) {

       ConnectionFactory factory=ConnectionFactory.getInstance();
       Connection conn=factory.getConnection();

       UserDao ud=new UserDaoImpl();

       List<City> list=ud.findAllByCountry_id(conn,args[0]);
       for (int i=0;i<list.size();i++){
           System.out.println(list.get(i).toString());
       }
    }
}
