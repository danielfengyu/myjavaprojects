package com.fy.dao;

import java.sql.*;
import java.util.*;

import com.fy.bean.Product;
/**
 * 对商品信息进行相关操作的类
 * @author zy
 */
public class ProductDao {
	/**
	 * 查询所有商品对象
	 * @return
	 * @throws SQLException 
	 */
	public List<Product> getAllProduct() throws SQLException {
		List<Product> list = new ArrayList<Product>();
		Connection con = DriverManager.getConnection
     		   ("jdbc:mysql://localhost:3306/bookstore?user=root&password=dayingfengyu");
		String sql = "select * from product p where delsoft='0'  order by p.id ";
		Statement stmt = null ;
		ResultSet rs = null ;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Product pu = new Product();
				pu.setId(rs.getInt("id"));
				pu.setProductnumber(rs.getString("productnumber"));
				pu.setProductname(rs.getString("productname"));
				pu.setCategoryno(rs.getString("categoryno"));
				pu.setCategory(rs.getString("category"));
				pu.setImagepath(rs.getString("imagepath"));
				pu.setIsnewproduct(rs.getString("isnewproduct"));
				pu.setPrice1(rs.getFloat("price1"));
				pu.setPrice2(rs.getFloat("price2"));
				pu.setRealstock(rs.getString("realstock"));

				pu.setStock(rs.getString("stock"));
				pu.setCas(rs.getString("cas"));
				pu.setMdlint(rs.getString("mdlint"));
				pu.setFormula(rs.getString("formula"));
				pu.setWeight(rs.getString("weight"));
				pu.setDelsoft(rs.getString("delsoft"));
				pu.setNote(rs.getString("note"));
				list.add(pu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
}


