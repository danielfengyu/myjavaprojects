import java.sql.*;

public class TestJdbc {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // ����MySQL��������
			Connection con = DriverManager.getConnection( // �������ݿ�����
					"jdbc:mysql://localhost/test", "java", "java1234");
			Statement stmt = con.createStatement(); // ����������
			/* ִ��MySQL����ʱ�亯�������ؽ������ֻ��һ����¼ */
			ResultSet rs = stmt.executeQuery("select now() as systime");
			rs.next(); // �ƶ��α굽��һ����¼����������е�systime�е�ֵ
			System.out.println("now: " + rs.getTimestamp("systime"));
			
			rs.close(); // �رս����
			rs = stmt.executeQuery("select * from student");
			while (rs.next()) {
				/* ��������������ÿ����¼��name��gender�е�ֵ */
				System.out.println("name: " + rs.getString("name")
						+ "\t\t gender: "
						+ (rs.getBoolean("gender") ? "��" : "Ů"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
