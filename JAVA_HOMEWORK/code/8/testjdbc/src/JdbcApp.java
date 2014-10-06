import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*; //������ݼ����õ�TableModel��DefaultTableModel
import java.util.*;
import java.sql.*;
import java.io.*;

public class JdbcApp extends JFrame implements ActionListener {
	/*
	 * �����GUI�������ڣ������С�ӵ�С�JTextArea�������������SELECT
	 * ��䣬JTable��������������ʾ��ѯ�Ľ�������ݣ��������˵����� �˵�������������
	 */
	// �����ı������������������SQL SELECT���
	JTextArea ta = new JTextArea();
	JTable table = new JTable(); // Swing�����������������е�����
	JMenuBar mb1 = new JMenuBar(); // �˵���
	JMenu menu1 = new JMenu("Setup"); // �˵�
	JMenu menu2 = new JMenu("Database"); // �˵�
	JMenuItem mi1 = new JMenuItem("jdbc config"); // �˵���
	JMenuItem mi2 = new JMenuItem("connect"); // �˵���
	JMenuItem mi3 = new JMenuItem("disconnect"); // �˵���

	Connection con; // ���ݿ�����

	JTextField jtf1 = new JTextField(); // �����ı��������������driverClassName
	JTextField jtf2 = new JTextField(); // �����ı��������������jdbcUrl
	JTextField jtf3 = new JTextField(); // �����ı��������������username
	JTextField jtf4 = new JTextField(); // �����ı��������������password

	JButton btn1 = new JButton("����"); // ����������Ϣ
	JButton btn2 = new JButton("ȡ��"); // �رնԻ���
	JButton btn3 = new JButton("ִ��"); // ִ��SQL SELECT���

	String driverClassName, jdbcUrl, username, password; // JDBC������Ϣ
	Properties props = new Properties(); // ���Լ��ϣ��洢JDBC������Ϣ
	JDialog dialog; // JDBC ���öԻ���

	/*
	 * ActionListener���ڽӿڣ�����ť����¼����˵������¼������˫��
	 * �б���е�ĳһ��Ȼ����ActionEvent�¼�����Ӧ���¼�������Ϊ
	 * actionPerformed������������ActionListener�ӿ���
	 */
	public void actionPerformed(ActionEvent ae) { // �˵��Ͱ�ť�Ĺ������¼���������
		final Object s = ae.getSource(); // �õ��¼�Դ����
		new Thread() { // ����һ���߳�ȥ�����¼�
			public void run() {
				if (s == mi1) { // �������JDBC������Ϣ
					dialog = new JDialog(JdbcApp.this, /* ����ģ̬�Ի��� */
					"JDBC Configuration Dialog", true);
					Container c = dialog.getContentPane();
					JPanel p1 = new JPanel();
					p1.setLayout(new GridLayout(4, 2)); // �������񲼾�Ϊ4��2��
					p1.add(new JLabel("JDBC Driver"));
					p1.add(jtf1);
					p1.add(new JLabel("JDBC URL"));
					p1.add(jtf2);
					p1.add(new JLabel("USERNAME"));
					p1.add(jtf3);
					p1.add(new JLabel("PASSWORD"));
					p1.add(jtf4);
					jtf1.setText(driverClassName); // ���ó�ʼֵ
					jtf2.setText(jdbcUrl);
					jtf3.setText(username);
					jtf4.setText(password);

					JPanel p2 = new JPanel();
					p2.setLayout(new FlowLayout()); // ����������
					p2.add(btn2);
					p2.add(btn1);

					btn2.addActionListener(JdbcApp.this); // ����дthis, this��ָ���
					btn1.addActionListener(JdbcApp.this); // ������ʵ��

					c.setLayout(new BorderLayout());
					c.add(p1, BorderLayout.CENTER);
					c.add(p2, BorderLayout.SOUTH);

					dialog.setSize(new Dimension(350, 200));
					dialog.setVisible(true); // ��ʾ�Ի���
				} else if (s == mi2) {
					try {
						if (con != null && !con.isClosed()) {// ����Ѿ��������ݿ�
							con.close(); // ���ȶϿ����ݿ�
						}
						Class.forName(driverClassName); // ��ʼ�������ݿ�
						con = DriverManager.getConnection(jdbcUrl, username,
								password);
					} catch (Exception e) { // �������������������������Ӵ���
						JOptionPane.showMessageDialog(JdbcApp.this,
								e.getMessage(), "�����쳣",
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (s == mi3) { // ִ�йر����ݿ����ӣ��Ͽ����ݿ�����
					try {
						if (con != null && !con.isClosed()) {
							con.close();
							con = null;
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(JdbcApp.this,
								e.getMessage(), "�����쳣",
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (s == btn1) { // ����JDBC������Ϣ���˳��Ի���
					try {
						/* �ӵ����ı���������ж�ȡ�û������������Ϣ */
						driverClassName = jtf1.getText().trim();
						jdbcUrl = jtf2.getText().trim();
						username = jtf3.getText().trim();
						password = jtf4.getText().trim();
						/* �ȱ��浽���Լ����� */
						props.setProperty("driverClassName", driverClassName);
						props.setProperty("jdbcUrl", jdbcUrl);
						props.setProperty("username", username);
						props.setProperty("password", password);
						/* �ٱ��浽�����ļ��� */
						props.store(new FileOutputStream("jdbc.properties"),
								"JDBC Configuration");
						dialog.dispose();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(JdbcApp.this,
								e.getMessage(), "�����쳣",
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (s == btn2) { // ȡ����ť��ֱ�ӹرնԻ���
					dialog.dispose();
				} else if (s == btn3) { // ִ��SQL SELECT���
					try {
						if (con == null || con.isClosed()) { // ������ݿ�û����
							JOptionPane.showMessageDialog(JdbcApp.this,
									"���ݿ�û������", "��ʾ",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							String sql = ta.getText();
							Statement stmt = con.createStatement();
							ResultSet rs = stmt.executeQuery(sql);
							// ���ݲ�ѯ�������һ����ģ�Ͷ���
							table.setModel(new MyTableModel(rs));
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(JdbcApp.this,
								e.getMessage(), "�����쳣",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}.start(); // ������һ����������󣬴�Thread�̳������������Ե��Գ�
	}

	/* �Զ����ģ�ͣ���DefaultTableModel�̳У�ʵ����TableModel�ӿ� */
	class MyTableModel extends DefaultTableModel {
		int rows, cols; // ����������
		ResultSet rs; // ���������
		ResultSetMetaData rsmd; // �����Ԫ���ݣ�����������Ľṹ����

		public MyTableModel(ResultSet rs) {
			this.rs = rs;
			try {
				if (rs != null) {
					rsmd = rs.getMetaData(); // �õ������Ԫ����
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(JdbcApp.this, e.getMessage(),
						"�����쳣", JOptionPane.ERROR_MESSAGE);
			}
		}

		public int getRowCount() { // ���ر�ģ�͵�����
			try {
				if (rs.last()) { // ����������������һ����¼
					rows = rs.getRow(); // �õ���ǰ�α�ļ�¼λ��
				} else { // ��������Ϊ��
					rows = 0;
				}
				return rows;
			} catch (Exception e) {
				rows = 0;
			}
			return rows;
		}

		public int getColumnCount() { // ���ر�ģ�͵�����
			try {
				if (rsmd != null) {
					cols = rsmd.getColumnCount(); // �ӽ����Ԫ���ݶ����ж�����
					return cols;
				}
			} catch (Exception e) {
				cols = 0;
			}
			cols = 0;
			return cols;
		}

		public String getColumnName(int columnIndex) { // �õ�����
			try {
				if (rsmd != null) {// �����������źͱ�ģ�͵��������ʼֵ��ͬ
					return rsmd.getColumnName(columnIndex + 1);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(JdbcApp.this, e.getMessage(),
						"�����쳣", JOptionPane.ERROR_MESSAGE);
			}
			return null;
		}

		/* �õ���ģ�͵��ж�Ӧ�������ͣ�ʹ����SQL TYPE MAPPING������8-1 */
		public Class<?> getColumnClass(int columnIndex) {
			try {
				int type = rsmd.getColumnType(columnIndex + 1);
				switch (type) {
				case Types.REAL:
					return Float.class;
				case Types.FLOAT:
				case Types.DOUBLE:
					return Double.class;
				case Types.INTEGER:
					return Integer.class;
				case Types.BOOLEAN:
				case Types.BIT:
					return Boolean.class;
				case Types.CHAR:
				case Types.VARCHAR:
					return String.class;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(JdbcApp.this, e.getMessage(),
						"�����쳣", JOptionPane.ERROR_MESSAGE);
			}
			return String.class;
		}

		/* ��������ʾ������е����ݣ����Ա�ģ�������ǲ��ɱ༭�� */
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		/*
		 * ��ģ���е����ݣ�����������ֵ�����Ǵ�0��ʼ�����ģ� ���ص���Object���ͣ���Ϊǰ���getColumnClass�Ѿ��������е�����
		 * ���Է��ص����ݶ���getObject���������������û���ٸ����е����� ���������ò�ͬ��ResultSet.getXXX(int
		 * colIndex)����ʵ�����ݶ���
		 */
		public Object getValueAt(int rowIndex, int columnIndex) {
			try {
				if (rs != null) {
					rs.absolute(rowIndex + 1);
					return rs.getObject(columnIndex + 1);
				}
				return null;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(JdbcApp.this, e.getMessage(),
						"�����쳣", JOptionPane.ERROR_MESSAGE);
				return null;
			}
		}
	}

	/* �����ǹ���һ��JFrame�ĳ�ʼ������ */
	public JdbcApp() {
		super("Jdbc Application Demo");
		try { // ���������ļ�����һ���ļ����н������������ݼ���
			props.load(new FileInputStream("jdbc.properties"));
			driverClassName = props.getProperty("driverClassName");
			jdbcUrl = props.getProperty("jdbcUrl");
			username = props.getProperty("username");
			password = props.getProperty("password");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "�����쳣",
					JOptionPane.ERROR_MESSAGE);
		}
		/* �����ǹ����˵�����Ϊ�˵���ע���¼����� */
		menu1.add(mi1);
		menu2.add(mi2);
		menu2.add(mi3);
		mb1.add(menu1);
		mb1.add(menu2);
		setJMenuBar(mb1);
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		// ���ò���
		ta.setPreferredSize(new Dimension(500, 100));
		ta.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel label = new JLabel("������SQL SELECT���");
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());

		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(1, 2));
		panel4.add(label);
		JPanel panel5 = new JPanel();
		panel5.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btn3.setPreferredSize(new Dimension(80, 25));
		panel5.add(btn3);
		panel4.add(panel5);
		btn3.addActionListener(this);

		panel1.add(panel4, BorderLayout.NORTH);
		panel1.add(ta, BorderLayout.CENTER);

		table.setPreferredSize(new Dimension(500, 300));
		Container panel2 = getContentPane();
		panel2.setLayout(new BorderLayout());
		// table���뵽���������У������ڴ����ı��������ʾ���ṩ������֧��
		panel2.add(panel1, BorderLayout.NORTH);
		panel2.add(new JScrollPane(table), BorderLayout.CENTER);

		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JdbcApp();
	}
}
