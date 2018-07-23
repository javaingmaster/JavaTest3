package com.hand.daoImpl;

import com.hand.dao.UserDao;
import com.hand.entity.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<City> findAllByCountry_id(Connection conn, String cid) {
        List<City> list=new ArrayList<>();
        try {
            conn.setAutoCommit(false);
            String sql=" select city_id,city from city where country_id="+cid;
            //PreparedStatement ps=conn.prepareStatement(sql);
            // ps.setInt(1,cid);
            // ResultSet rs=ps.executeQuery(sql);
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(sql);

            while (rs.next()){
                City u=new City(rs.getInt("city_id"),rs.getString("city"));
                System.out.println(u.toString());
                list.add(u);
            }

            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }



}
