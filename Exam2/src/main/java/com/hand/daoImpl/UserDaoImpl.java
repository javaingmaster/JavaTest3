package com.hand.daoImpl;

import com.hand.dao.UserDao;
import com.hand.entity.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<Result> findListByCustomerid(Connection conn, int customerid) {
        List<Result> l=new ArrayList<>();
        String sql=" select distinct f.film_id,f.title,r.rental_date from film f inner join rental r inner join inventory i" +
                " on r.inventory_id=i.inventory_id and r.customer_id=? and i.film_id=f.film_id";
        try {
            conn.setAutoCommit(false);

            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,customerid);

            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                Result r=new Result(rs.getInt("film_id"),rs.getString("title"),rs.getDate("rental_date"));

                    l.add(r);
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
        return l;
    }
}
