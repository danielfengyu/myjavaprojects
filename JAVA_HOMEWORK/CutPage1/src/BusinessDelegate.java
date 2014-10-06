//package com.accp.gz.th.zm.server.action;


import java.util.ArrayList;
//import com.accp.gz.th.zm.server.entity.Goods;
//import com.accp.gz.th.zm.server.dao.*;
//import com.accp.gz.th.zm.client.javabean.PageBean;


public class BusinessDelegate {

        /**
         * 查找所有商品记录
         */
        public static ArrayList select() {
           return new GoodsDAO().select();
        }

        /**
         * 根据分页查找记录
         */
        public static ArrayList select(PageBean bean) {
            return new GoodsDAO().select(bean);
        }

        /**
         * 查找所有类型记录
         */
        public static ArrayList selectType() {
           return new GoodsTypeDAO().select();
        }

}
