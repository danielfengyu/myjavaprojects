//package com.accp.gz.th.zm.server.dao;

import java.util.ArrayList;
import java.sql.*;
//import com.accp.gz.th.zm.server.entity.Goods;
//import com.accp.gz.th.zm.client.javabean.PageBean;

/**
 * Goods表的处理类
 */
public class GoodsDAO {
    /**
     * 查找所有记录
     */
    public ArrayList select() {

        ArrayList list = new ArrayList();

        Connection conn = ConnectionManager.getConn();
        Statement stmt =null;
        ResultSet rs =null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from Goods");
            while(rs.next()){
                Goods g=new Goods();
                g.setId(rs.getInt(1));
                g.setName(rs.getString(2));
                g.setPrice(rs.getInt(3));
                g.setNumber(rs.getInt(4));
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

    /*** 方法 2 ： 根据SQL语句统计记录总数 ***/
    public static int getTotalRows(String selectSql) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int count = 0;

        conn = ConnectionManager.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(selectSql);
            while (rs.next()) {
                count++;
            }
        } catch (SQLException ex) {
        } finally {
            ConnectionManager.Close(conn);
            ConnectionManager.Close(stmt);
            ConnectionManager.Close(rs);
            return count;
        }
    }


    /*** 方法 3 ： 根据 请求的页面bean、查询语句 进行商品记录的分页查询 ***/
    public ArrayList select( PageBean pageBean ){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList vec = new ArrayList();

        int queryPageNo = pageBean.getQueryPageNo(); // 获得请求到达的页号
        int rowsPerPage = pageBean.getRowsPerPage(); // 获得每页的行数
        String selectSql = "select * from Goods"; // 设置默认的查询语句
        if( pageBean.getQuerySql()!= null )
             selectSql = pageBean.getQuerySql();  // 如果有查询语句，则用指定的查询语句

        // 统计总行数
        int totalRows = getTotalRows(selectSql);
        pageBean.setTotalRows(totalRows);
        // 统计总页数
        int totalPage = totalRows % rowsPerPage == 0 ? totalRows / rowsPerPage :
                        totalRows / rowsPerPage + 1;
        pageBean.setTotalPage(totalPage);
        // 统计最后一页的行数
        int lastPageRows = totalRows % rowsPerPage == 0 ? rowsPerPage :
                           totalRows % rowsPerPage;
        pageBean.setLastPageRows(lastPageRows);

        conn = ConnectionManager.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(selectSql);
            //rs = stmt.executeQuery("select * from Goods");

            // 跳过前面所有页的行
            int skipRows = (queryPageNo - 1) * rowsPerPage;
            for (int i = 0; i < skipRows; i++)
                rs.next();

            int count = rowsPerPage;
            while ( rs!=null && rs.next() && count>0) {
                Goods g = new Goods();
                g.setId(rs.getInt(1));
                g.setName(rs.getString(2));
                g.setPrice(rs.getInt(3));
                g.setNumber(rs.getInt(4));
                vec.add(g);
                count--;
            }
        } catch (SQLException ex) {
        }
        finally{
            ConnectionManager.Close(conn);
            ConnectionManager.Close(stmt);
            ConnectionManager.Close(rs);
        }

        return vec;
    }

}
