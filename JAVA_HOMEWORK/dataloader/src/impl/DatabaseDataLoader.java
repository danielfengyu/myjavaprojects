package impl;

import java.util.ArrayList;
import base.*;
import java.sql.*;

public class DatabaseDataLoader implements DataLoader {
	public ArrayList<Student> load() {
		ArrayList<Student> r = new ArrayList<Student>();
		try {
			Class.forName("com.mysql.jdbc.Driver"); // ������������
			Connection con = DriverManager.getConnection(// �������ݿ�����
					"jdbc:mysql://localhost/student", "java", "java1234");
			Statement stmt = con.createStatement(); // ����������
			ResultSet rs = stmt.executeQuery("select * from student");
			while (rs.next()) { // ���������
				String id = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				boolean gender = rs.getBoolean("gender");
				int age = rs.getInt("age");
				int java = rs.getInt("java");
				Student s = new Student(id, name, email, java, age, gender);
				r.add(s);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	/*
	 * �������Ӧ�õ���ڷ�����ʵ�������ݿ���г�ʼ���ݵļ��ع��̣� ��Excel�ļ��а����ݶ��������뵽���ݱ���
	 */
	public static void main(String[] args) {
		try { // DataLoaderFactory.java�ں�����н���
			DataLoaderFactory factory = new DataLoaderFactory();
			DataLoader loader = factory.getDataLoader("impl.ExcelDataLoader");
			ArrayList<Student> r = loader.load(); // ���ص�������

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/student", "java", "java1234");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("truncate table student"); // ɾ��������
			stmt.close();

			PreparedStatement pstmt = con
					.prepareStatement("insert into student(id,name,email,gender,age,java) values(?,?,?,?,?,?)");
			for (int i = 0; i < r.size(); i++) { // �������ݼ���
				Student s = r.get(i);
				// ��������Ԥ���������6��ռλ������
				pstmt.setString(1, s.getId());
				pstmt.setString(2, s.getName());
				pstmt.setString(3, s.getEmail());
				pstmt.setBoolean(4, s.getGender());
				pstmt.setInt(5, s.getAge());
				pstmt.setInt(6, s.getJava());
				pstmt.executeUpdate();
			}
			pstmt.close();
			con.close();
			System.out.println("done.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
