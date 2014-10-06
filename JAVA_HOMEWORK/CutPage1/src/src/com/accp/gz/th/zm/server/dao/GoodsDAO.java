//package com.accp.gz.th.zm.server.dao;

import java.util.ArrayList;
import java.sql.*;
//import com.accp.gz.th.zm.server.entity.Goods;
//import com.accp.gz.th.zm.client.javabean.PageBean;

/**
 * Goods��Ĵ�����
 */
public class GoodsDAO {
    /**
     * �������м�¼
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

    /*** ���� 2 �� ����SQL���ͳ�Ƽ�¼���� ***/
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


    /*** ���� 3 �� ���� �����ҳ��bean����ѯ��� ������Ʒ��¼�ķ�ҳ��ѯ ***/
    public ArrayList select( PageBean pageBean ){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList vec = new ArrayList();

        int queryPageNo = pageBean.getQueryPageNo(); // ������󵽴��ҳ��
        int rowsPerPage = pageBean.getRowsPerPage(); // ���ÿҳ������
        String selectSql = "select * from Goods"; // ����Ĭ�ϵĲ�ѯ���
        if( pageBean.getQuerySql()!= null )
             selectSql = pageBean.getQuerySql();  // ����в�ѯ��䣬����ָ���Ĳ�ѯ���

        // ͳ��������
        int totalRows = getTotalRows(selectSql);
        pageBean.setTotalRows(totalRows);
        // ͳ����ҳ��
        int totalPage = totalRows % rowsPerPage == 0 ? totalRows / rowsPerPage :
                        totalRows / rowsPerPage + 1;
        pageBean.setTotalPage(totalPage);
        // ͳ�����һҳ������
        int lastPageRows = totalRows % rowsPerPage == 0 ? rowsPerPage :
                           totalRows % rowsPerPage;
        pageBean.setLastPageRows(lastPageRows);

        conn = ConnectionManager.getConn();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(selectSql);
            //rs = stmt.executeQuery("select * from Goods");

            // ����ǰ������ҳ����
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
