package server;

import java.util.*;
import java.io.*;
import javax.sql.DataSource;
import java.sql.*;
import org.apache.commons.dbcp.*; //���Ե�www.apache.org����commons-dbcp
/* Student.java�࣬����ƪ���Ͳ��ṩԴ���ˣ�����ʵ����java.io.Serializable�ӿڣ�
 �ṩ���л�֧�֣���ΪҪͨ������������Student���ݶ��� */
import bean.Student;

public class CrudService {
	DataSource ds; // javax.sql���е�����Դ�ӿڣ����̹߳���һ�����ӳ�

	public CrudService() {
		ds = setupDataSource(); // ����һ�����ӳز���װΪ����Դ
	}

	public List<Student> find(String sql) { // ִ�в�ѯ���
		List<Student> list = new ArrayList<Student>();
		try {
			Connection con = ds.getConnection(); // �����ӳ��л��һ�����ݿ�����
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getString("id")); // ѧ������id����
				s.setName(rs.getString("name")); // ѧ������name����
				s.setEmail(rs.getString("email")); // ѧ������email����
				s.setAge(rs.getInt("age")); // ѧ������age����
				s.setJava(rs.getInt("java")); // ѧ������java����
				s.setGender(rs.getBoolean("gender")); // ѧ������gender����
				list.add(s);
			}
			rs.close();
			stmt.close();
			/*
			 * ʹ����Ϻ󣬾�������ӹرգ�ע�����������ӳ��е�ʵ�� Connection�ӿڵĶ����close�������÷�������дΪ�ͷ�����
			 * �ͻص����ӳأ����ӵ�״̬Ϊ���У����������İ����ݿ����ӹرյ���
			 */
			con.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Student> findFailed() { // ��ѯ�������ѧ������
		return find("select * from student where java<60");
	}

	public List<Student> findExcellent() { // ��ѯ�����ѧ������
		return find("select * from student where java>=90");
	}

	public void insertOrUpdate(Student s) { // ����Student�������ݿ�
		try {
			Connection con = ds.getConnection();
			/*
			 * Ԥ����PreparedStatement��䣬��������SQL��䣬 ����ʹ��ռλ��?����ʾ
			 */
			PreparedStatement pstmt = con
					.prepareStatement("select id from student where id=?");
			pstmt.setString(1, s.getId()); // ���ã��滻������ֵ��ռλ����1��ʼ����
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) { // ����ü�¼�Ѿ������ݿ⣬��ôȥupdate
				pstmt = con
						.prepareStatement("update student set name=?, email=?, java=?, age=?,gender=? where id = ?");
				pstmt.setString(1, s.getName()); // ��һ��������name
				pstmt.setString(2, s.getEmail()); // �ڶ���������email
				pstmt.setInt(3, s.getJava());
				pstmt.setInt(4, s.getAge());
				pstmt.setBoolean(5, s.isGender());
				pstmt.setString(6, s.getId());
				pstmt.executeUpdate();
			} else { // ����ü�¼�����ڣ���ִ��insert���
				pstmt = con
						.prepareStatement("insert into student(id,name,email,java,age,gender) values(?,?,?,?,?,?)");
				pstmt.setString(1, s.getId());
				pstmt.setString(2, s.getName());
				pstmt.setString(3, s.getEmail());
				pstmt.setInt(4, s.getJava());
				pstmt.setInt(5, s.getAge());
				pstmt.setBoolean(6, s.isGender());
				pstmt.executeUpdate();
			}
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String id) {
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("delete from student where id=?");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DataSource setupDataSource() {
		try {
			Properties p = new Properties(); // ��������Ϣ
			p.load(new FileInputStream("jdbc.properties"));
			// ����DBCP�ṩ������Դ������ʵ����DataSource�ӿ�
			BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName(p.getProperty("driverClassName"));
			ds.setUsername(p.getProperty("username"));
			ds.setPassword(p.getProperty("password"));
			ds.setUrl(p.getProperty("jdbcUrl"));
			ds.setMaxActive(100); // �������ӳ������������
			ds.setMaxIdle(20); // �������ӳ�����������
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}

	public static void printDataSourceStats(DataSource ds) { // �������Դ��״̬��Ϣ
		BasicDataSource bds = (BasicDataSource) ds;
		System.out.println("NumActive: " + bds.getNumActive());
		System.out.println("NumIdle: " + bds.getNumIdle());
	}
}
