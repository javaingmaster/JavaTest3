package com.hand.dao;

import com.hand.entity.City;

import java.sql.Connection;
import java.util.List;

public interface UserDao {
    public List<City> findAllByCountry_id(Connection conn, String cid);
}
