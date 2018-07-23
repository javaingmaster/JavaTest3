package com.hand.dao;

import com.hand.entity.Result;

import java.sql.Connection;
import java.util.List;

public interface UserDao {
    public List<Result> findListByCustomerid(Connection conn, int customerid);
}
