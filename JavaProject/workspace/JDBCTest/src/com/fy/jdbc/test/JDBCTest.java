package com.fy.jdbc.test;

import java.sql.*;   
public class JDBCTest{  
public static void main(String[] args){  
	String driver = "com.mysql.jdbc.Driver";
	
	// URLָ��Ҫ���ʵ����ݿ���scutcs
	/*String url = "jdbc:mysql://127.0.0.1:3306/bookstore";
	// MySQL����ʱ���û���
	String user = "root";
	// Java����MySQL����ʱ������
	String password = "dayingfengyu";*/
		
	try {
			// ������������
			Class.forName(driver);
			// �������ݿ�
			//Connection conn = DriverManager.getConnection(url, user, password);
			Connection conn = DriverManager.getConnection
         		   ("jdbc:mysql://localhost:3306/bookstore?user=root&password=dayingfengyu");//DataAccess.getConnection();
			if(!conn.isClosed())
			System.out.println("Succeeded connecting to the Database!");
			// statement����ִ��SQL���
			Statement statement = conn.createStatement();
			// Ҫִ�е�SQL���
			String sql = "select * from bs_customer";
			ResultSet rs = statement.executeQuery(sql);  
			System.out.println("-----------------");  
			System.out.println("ִ�н��������ʾ:");  
			System.out.println("-----------------");  
			System.out.println(" ѧ��" + "\t" + " ����");  
			System.out.println("-----------------");  
			String name = null;  
			while(rs.next()) {  
				name = rs.getString("username");
			
				// ����ʹ��ISO-8859-1�ַ�����name����Ϊ�ֽ����в�������洢�µ��ֽ������С�
			
				// Ȼ��ʹ��GB2312�ַ�������ָ�����ֽ�����
			
				name = new String(name.getBytes("ISO-8859-1"),"GB2312");
			
				// ������
			
				System.out.println(rs.getString("custID") + "\t" + name);  
			}  
			rs.close();  
			conn.close();   
		} catch(ClassNotFoundException e) {   
			System.out.println("Sorry,can`t find the Driver!");   
			e.printStackTrace();   
		} catch(SQLException e) {   
			e.printStackTrace();   
		} catch(Exception e) {   
			e.printStackTrace();   
		}   
	}   
}
