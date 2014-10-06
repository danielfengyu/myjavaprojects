//package com.accp.gz.th.zm.client.javabean;

import java.util.*;
//import com.accp.gz.th.zm.server.action.BusinessDelegate;

/**
 * 类名：PageBean
 * 描述：用于分页显示的 JavaBean
 */
public class PageBean implements java.io.Serializable{

    public PageBean() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int queryPageNo=1;       // 请求的页号
    public int rowsPerPage = 20;    // 每页的行数
    public String querySql ;   // 查询的Sql语句

    public int totalPage;      // 总页数
    public int totalRows;      // 总行数
    public int lastPageRows;   // 最后一页的行数
    public ArrayList resultDataVec;  // 显示在当前页面中的数据

    public int getQueryPageNo() {
        return queryPageNo;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public String getQuerySql() {
        return querySql;
    }

    public ArrayList getResultDataVec() {
        resultDataVec = BusinessDelegate.select(this);//,querySql);
        return resultDataVec;
    }

    public int getLastPageRows() {
        return lastPageRows;
    }

    public void setQueryPageNo(int queryPageNo) {
        this.queryPageNo = queryPageNo;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public void setQuerySql(String querySql) {
        this.querySql = querySql;
    }

    public void setResultDataVec(ArrayList resultDataVec) {
        this.resultDataVec = resultDataVec;
    }

    public void setLastPageRows(int lastPageRows) {
        this.lastPageRows = lastPageRows;
    }

    private void jbInit() throws Exception {
    }

}
