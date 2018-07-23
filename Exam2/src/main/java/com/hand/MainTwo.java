package com.hand;

import com.hand.dao.UserDao;
import com.hand.daoImpl.UserDaoImpl;
import com.hand.entity.Result;
import com.hand.util.ConnectionFactory;

import java.sql.Connection;
import java.util.List;

public class MainTwo {
    public static void main(String[] args) {
        ConnectionFactory factory=ConnectionFactory.getInstance();
        Connection conn=factory.getConnection();
        UserDao ud=new UserDaoImpl();

        int input=Integer.parseInt(args[0]);
        List<Result> result=ud.findListByCustomerid(conn,input);
        out(result,input);

    }
    public static void out(List<Result> l,int cid){
        System.out.println("顾客"+cid+"租用的film有：（依据时间倒叙排列）");
        for(int i=0;i<l.size();i++){
            Result ri=l.get(i);
            for(int j=i;j<l.size();j++){
                Result rj=l.get(j);
                if(rj.getRentalDate().after(ri.getRentalDate())){
                    l.remove(i);
                    l.add(i,rj);
                    l.remove(j);
                    l.add(j,ri);
                    ri=rj;
                }
            }
        }
        for(int i=0;i<l.size();i++){
            Result r=l.get(i);
            System.out.println("filmid:"+r.getFilmid()+"  |  "+"filmname: "+r.getFilmname()+"  |  date: "+r.getRentalDate());
        }
    }
}
