//package com.accp.gz.th.zm.client.javabean;

import java.util.*;
//import com.accp.gz.th.zm.server.action.BusinessDelegate;

/**
 * ������PageBean
 * ���������ڷ�ҳ��ʾ�� JavaBean
 */
public class PageBean implements java.io.Serializable{

    public PageBean() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int queryPageNo=1;       // �����ҳ��
    public int rowsPerPage = 20;    // ÿҳ������
    public String querySql ;   // ��ѯ��Sql���

    public int totalPage;      // ��ҳ��
    public int totalRows;      // ������
    public int lastPageRows;   // ���һҳ������
    public ArrayList resultDataVec;  // ��ʾ�ڵ�ǰҳ���е�����

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
