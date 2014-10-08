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
 * 项目案例 查询所有商品控制器类
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
		//控制层实现步骤
		//1.调用业务方法查询所有商品
		List<Product> list = null;
		try {
			list = new ProductDao().getAllProduct ();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.商品集合保存到请求范围
		request.setAttribute("allProduct", list);
		//3.请求转发至显示层jsp

		request.getRequestDispatcher("/showProduct.jsp").forward(request, response);
	}
}
