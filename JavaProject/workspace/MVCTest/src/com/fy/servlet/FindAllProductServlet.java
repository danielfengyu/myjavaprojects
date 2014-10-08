package com.fy.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fy.bean.Product;
import com.fy.dao.*;;
/**
 * ��Ŀ���� ��ѯ������Ʒ��������
 */
public class FindAllProductServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���Ʋ�ʵ�ֲ���
		//1.����ҵ�񷽷���ѯ������Ʒ
		List<Product> list = null;
		try {
			list = new ProductDao().getAllProduct ();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.��Ʒ���ϱ��浽����Χ
		request.setAttribute("allProduct", list);
		//3.����ת������ʾ��jsp

		request.getRequestDispatcher("/showProduct.jsp").forward(request, response);
	}
}
