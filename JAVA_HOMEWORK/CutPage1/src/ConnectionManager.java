//package com.accp.gz.th.zm.server.dao;

import java.sql.*;

public class ConnectionManager {
    /**
     * 1、获得数据库连接
     */
    public static Connection getConn() {

        Connection conn = null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:odbc:GoodsSystem");
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
        return conn;
    }

    /**
     * 2、关闭数据库连接
     */
    public static void Close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    /**
     * 3、关闭语句对象
     */
    public static void Close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    /**
     * 4、关闭预处理语句对象
     */
    public static void Close(PreparedStatement pstmt) {
        try {
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }


    /**
     * 5、关闭结果集
     */
    public static void Close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}


