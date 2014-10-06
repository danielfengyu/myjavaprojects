//package com.accp.gz.th.zm.server.entity;

/**
 * 类名：GoodsType
 * 功能：同名数据表的实体类
 */
public class GoodsType implements java.io.Serializable{

    private int id;   // 类型id
    private String name;   // 类型的名称

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
