/*package com.accp.gz.th.zm.server.action;*/


import java.util.ArrayList;

import com.accp.gz.th.zm.server.dao.GoodsDAO;
//import com.accp.gz.th.zm.server.entity.Goods;
//import com.accp.gz.th.zm.server.dao.*;
//import com.accp.gz.th.zm.client.javabean.PageBean;
import com.accp.gz.th.zm.server.dao.GoodsTypeDAO;


public class BusinessDelegate {

        /**
         * ����������Ʒ��¼
         */
        public static ArrayList select() {
           return new GoodsDAO().select();
        }

        /**
         * ���ݷ�ҳ���Ҽ�¼
         */
        public static ArrayList select(PageBean bean) {
            return new GoodsDAO().select(bean);
        }

        /**
         * �����������ͼ�¼
         */
        public static ArrayList selectType() {
           return new GoodsTypeDAO().select();
        }

}
