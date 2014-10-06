//package com.accp.gz.th.zm.server.dao;

import java.util.*;
//import com.accp.gz.th.zm.server.entity.Goods;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
//import com.accp.gz.th.zm.server.entity.GoodsType;

/**
 * 类名：GoodsTypeDAO
 * 功能：GoodsType 表的操作类
 */
public class GoodsTypeDAO {

    /**
     * 方法1：查询所有的类型
     */
    public ArrayList select() {

        ArrayList list = new ArrayList();
        Connection conn = ConnectionManager.getConn();

        Statement stmt=null;
        ResultSet rs=null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from GoodsType");
            while(rs.next()){
                GoodsType g=new GoodsType();
                g.setId(rs.getInt(1));
                g.setName(rs.getString(2));
                list.add(g);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }finally{
            ConnectionManager.Close(rs);
            ConnectionManager.Close(stmt);
            ConnectionManager.Close(conn);
        }

        return list;
    }
}
