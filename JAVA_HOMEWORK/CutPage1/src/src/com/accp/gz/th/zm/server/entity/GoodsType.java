//package com.accp.gz.th.zm.server.entity;

/**
 * ������GoodsType
 * ���ܣ�ͬ�����ݱ��ʵ����
 */
public class GoodsType implements java.io.Serializable{

    private int id;   // ����id
    private String name;   // ���͵�����

    public GoodsType() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
