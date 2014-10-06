package com.abc.or;

import java.lang.reflect.*; //Java�����

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import java.io.*;

import org.apache.ibatis.io.Resources; //MyBatis��
import org.apache.ibatis.session.*; //MyBatis��
import org.apache.log4j.Logger; //Log4j
import org.apache.log4j.PropertyConfigurator;

import org.hibernate.Query; //Hibernate��
import org.hibernate.Session;

import org.dom4j.*; //Dom4j��
import org.dom4j.io.*;

public class Test {
	// ����ȫ����־������󣬻��dom4j��rootLogger
	public static Logger log = Logger.getRootLogger();

	public static void main(String[] args) throws Exception {
		PropertyConfigurator.configure( "log4j.properties" );  //����log4j
		
		Student s1 = new Student("002", "�ذ�", "tb@sina.com", 60, 75, true);
		Class clazz = s1.getClass(); // ���Student��Ӧ��Ԫ��Classʵ��

		Field[] fields = clazz.getDeclaredFields(); // ���÷�����ƣ����������ݳ�Ա
		for (int i = 0; i < fields.length; i++) { // Ϊ����ʾ������һ��һ���ı���
			if (fields[i].getName().equals("java")) { // �ж��Ƿ���java�������Գ�Ա
				fields[i].setAccessible(true); // ������ʣ���Ϊjava��Ա��˽�е�
				fields[i].set(s1, new Integer(80)); // �޸ĸ����ݳ�Ա��ֵ
			}// ʵ����û�б�Ҫ����������ֱ�ӵ���Field getDeclaredField(String name)
		}
		log.info(s1); // ��־����޸���java�ɼ���ѧ������
		Method[] methods = clazz.getDeclaredMethods(); // ������ƣ�������ķ�����Ա
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().equals("study")) { // �������ƿ������ַ�������ʾ
				methods[i].invoke(s1, new Integer(10)); // ִ�и÷�������̬�ķ������
			} // ʵ�ֶ�̬�������á�
		}
		log.info(s1);

		Test t = new Test();
		s1 = new Student("111", "demo", "demo@abc.com", 18, 66, true);
		t.saveOrUpdate(s1); // ���ö��󱣴浽���ݿ���

		t.hibernate(); // ʹ��Hibernate�������ݿ⣬���������档

		t.mybatis(); // ʹ��MyBatis�������ݿ⣬���������档
	}

	public void saveOrUpdate(Object o) {
		try {
			// ���ʵ���ൽ���ݿ���ӳ��
			Map<String, String> map1 = new HashMap<String, String>();
			// ���ʵ���ൽ���ݿ����Ե�ӳ�䣬���Դ����һ��List������
			Map<String, List<Property>> map2 = new HashMap<String, List<Property>>();
			// ���ʵ���ൽ�������Ե�ӳ��
			Map<String, Property> map3 = new HashMap<String, Property>();
			// ʹ��dom4j��demo.xml�����ļ�
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("demo.xml"));
			org.dom4j.XPath path = doc.createXPath("/demo/mapping");
			// ����ÿ��mappingӳ����Ϣ����������ֻ��һ��mapping��Ԫ��
			List list = path.selectNodes(doc);
			for (int i = 0; i < list.size(); i++) {
				Element node = (Element) list.get(i);
				Element c = node.element("class"); // �õ�class��Ԫ��
				Element t = node.element("table"); // �õ�table��Ԫ��
				map1.put(c.getText(), t.getText());
				List<Property> al = new ArrayList<Property>();// ������е�property
				List list2 = node.elements("property"); // �õ�ȫ����property��Ԫ��
				for (int j = 0; j < list2.size(); j++) {
					Property p1 = new Property();
					Element p = (Element) list2.get(j);
					p1.setName(p.getText());
					p1.setType(p.attributeValue("type"));
					p1.setColumn(p.attributeValue("column"));
					String id = p.attributeValue("id");
					// �жϸ������Ƿ�������
					p1.setId((id == null) ? false : id.equals("true"));
					if (p1.getId()) {
						map3.put(c.getText(), p1); // ��ӵ�ʵ���ൽ������ӳ����
					}
					al.add(p1);
				}
				map2.put(c.getText(), al);
			}
			/*
			 * ����ĳ��������ļ�demo.xml����󣬽�ȫ��ӳ����Ϣ�ŵ����� Map�����У�����Ĵ��뽫�жϴ����ʵ������ͣ�����ӳ���ļ�
			 * ����SQL��䣬ͬʱ�жϸ�����ʵ���Ƿ��Ѿ������ݿ����ˣ�Ȼ�� ѡ��ִ��INSERT������UPDATE��䡣
			 */
			Class clazz = o.getClass();
			String className = clazz.getName(); // �õ���ʵ���������

			/*
			 * ����ĳ������ʹ��dom4j��ȡdemo.xml�ļ���������Ϣ�� Ϊ�������ݿ�������׼����
			 */
			String driver = ((Element) doc
					.selectSingleNode("/demo/jdbc/driver")).getText();
			String url = ((Element) doc.selectSingleNode("/demo/jdbc/url"))
					.getText();
			String user = ((Element) doc.selectSingleNode("/demo/jdbc/user"))
					.getText();
			String password = ((Element) doc
					.selectSingleNode("/demo/jdbc/password")).getText();

			Class.forName(driver); // ���ظ��������򣬻�����ݿ����ӡ�
			Connection con = DriverManager.getConnection(url, user, password);

			String sqlSelect = "";
			Property id = map3.get(className); // ��ø�ʵ�������������
			/*
			 * count(*), count(1), count(id)����д��ִ��Ч���в�� ����������������������countʱ���
			 */
			sqlSelect = "SELECT count(" + id.getColumn() + ") FROM "
					+ map1.get(className) + " WHERE " + id.getColumn() + " = ?";

			PreparedStatement pstmt = con.prepareStatement(sqlSelect);
			/*
			 * ��־���������Ϣ������뿴���õ�����Ϣ����������log4j.properties ��log4j.rootLogger=INFO,
			 * Console, LogFile�޸�Ϊ log4j.rootLogger=DEBUG, Console, LogFile
			 */
			log.debug(sqlSelect); // ���������Ϣ
			Field f = clazz.getDeclaredField(id.getName()); // ����id��ֵ
			f.setAccessible(true);

			if (id.getType().equals("int")) { // �����֧��������������Ϊint��String
				pstmt.setInt(1, f.getInt(o));
			} else if (id.getType().equals("java.lang.String")
					|| id.getType().equals("String")) {
				pstmt.setString(1, f.get(o).toString());
			}
			// ��Ԥ������������������ִ�и����
			ResultSet rs1 = pstmt.executeQuery();
			rs1.next();
			int rows = rs1.getInt(1);
			if (rows == 0) { // �����ݼ�¼�����ڣ�ִ��INSERT
				// �ϳ�INSERT���
				String sqlInsert = "INSERT INTO " + map1.get(className) + "(";
				// �������Լ���
				List<Property> list3 = map2.get(className);
				String params = "";
				for (int k = 0; k < list3.size(); k++) {
					// ͬʱ���������������б��ռλ�������б�
					sqlInsert = sqlInsert + list3.get(k).getColumn() + ",";
					params = params + "?,";
				}
				params = params.substring(0, params.length() - 1); // ȥ�����Ķ���
				sqlInsert = sqlInsert.substring(0, sqlInsert.length() - 1)
						+ ") VALUES(" + params + ")";

				pstmt.close();
				pstmt = con.prepareStatement(sqlInsert);
				log.debug(sqlInsert);

				// Ԥ��������Ѿ����ɣ����濪ʼ���ò�������
				for (int k = 0; k < list3.size(); k++) {
					Property p2 = list3.get(k);
					Field f1 = clazz.getDeclaredField(p2.getName());
					f1.setAccessible(true);
					/*
					 * ����ĳ���ʵ������ӳ�䣬����ӳ�䵽setXXX������ ��δ�����Ҫ�ع�����߸����ԡ�
					 */
					if (p2.getType().equals("int")) {
						pstmt.setInt(k + 1, f1.getInt(o));
					}
					if (p2.getType().equals("long")) {
						pstmt.setLong(k + 1, f1.getLong(o));
					}
					if (p2.getType().equals("short")) {
						pstmt.setShort(k + 1, f1.getShort(o));
					}
					if (p2.getType().equals("byte")) {
						pstmt.setByte(k + 1, f1.getByte(o));
					} else if (p2.getType().equals("java.lang.String")
							|| p2.getType().equals("String")) {
						pstmt.setString(k + 1, f1.get(o).toString());
					} else if (p2.getType().equals("float")) {
						pstmt.setFloat(k + 1, f1.getFloat(o));
					} else if (p2.getType().equals("double")) {
						pstmt.setDouble(k + 1, f1.getDouble(o));
					} else if (p2.getType().equals("java.math.BigDecimal")) {
						pstmt.setBigDecimal(k + 1,
								new BigDecimal(f1.getDouble(o)));
					} else if (p2.getType().equals("boolean")) {
						pstmt.setBoolean(k + 1, f1.getBoolean(o));
					}
				}
				// ����ȫ��������Ϻ�ִ�и�Ԥ������䡣
				pstmt.executeUpdate();
				pstmt.close();

			} else { // ��������ݼ�¼�Ѿ����ڣ���ôִ��UPDATE���
				String sqlUpdate = "UPDATE " + map1.get(className) + " SET ";
				List<Property> list3 = map2.get(className);

				for (int k = 0; k < list3.size(); k++) {
					if (!list3.get(k).equals(id)) { // ����������ΪWHERE��������
						sqlUpdate = sqlUpdate + list3.get(k).getColumn()
								+ " = ?,";
					}
				}

				sqlUpdate = sqlUpdate.substring(0, sqlUpdate.length() - 1)
						+ " WHERE " + id.getColumn() + " = ?";
				pstmt.close();
				pstmt = con.prepareStatement(sqlUpdate);
				log.debug(sqlUpdate);
				int col = 0; // ռλ����λ��
				for (int k = 0; k < list3.size(); k++) {
					Property p2 = list3.get(k);
					// �����������Է���UPDATE�������
					// ������Ҫ����ռλ����λ��
					if (!p2.equals(id)) {
						col++;
						Field f1 = clazz.getDeclaredField(p2.getName());
						f1.setAccessible(true);
						if (p2.getType().equals("int")) {
							pstmt.setInt(col, f1.getInt(o));
						}
						if (p2.getType().equals("long")) {
							pstmt.setLong(col, f1.getLong(o));
						}
						if (p2.getType().equals("short")) {
							pstmt.setShort(col, f1.getShort(o));
						}
						if (p2.getType().equals("byte")) {
							pstmt.setByte(col, f1.getByte(o));
						} else if (p2.getType().equals("java.lang.String")
								|| p2.getType().equals("String")) {
							pstmt.setString(col, f1.get(o).toString());
						} else if (p2.getType().equals("float")) {
							pstmt.setFloat(col, f1.getFloat(o));
						} else if (p2.getType().equals("double")) {
							pstmt.setDouble(col, f1.getDouble(o));
						} else if (p2.getType().equals("java.math.BigDecimal")) {
							pstmt.setBigDecimal(col,
									new BigDecimal(f1.getDouble(o)));
						} else if (p2.getType().equals("boolean")) {
							pstmt.setBoolean(col, f1.getBoolean(o));
						}
					}
				}

				// �����������Բ�������
				col++;
				if (id.getType().equals("int")) {
					pstmt.setInt(col, f.getInt(o));
				} else if (id.getType().equals("java.lang.String")
						|| id.getType().equals("String")) {
					pstmt.setString(col, f.get(o).toString());
				}

				pstmt.executeUpdate();
				pstmt.close();

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} // saveOrUpdate(Object o)�������������Ա����������͵Ķ���ֻҪ��
	} // ���͵�ӳ���ļ����ڲ�����ȷ���������м���ӳ���ļ���д��ȷ��

	public void hibernate() { // ʹ��Hibernate��ʵ��ORM�����������ķ����������
		try {
			
			Student s1 = new Student("007", "���", "james@abc.com", 60, 100,
					true);
			Student s2 = new Student("008", "������", "zxx@abc.com", 40, 100, true);
			Student s3 = new Student("009", "������", "zrl@abc.com", 20, 80, false);
		
			// ��ʼ���ݿ�������õ�һ�����ݿ�Session
			Session session = HibernateSessionFactory.getSession();
			
			
			// ��ʼ���ݿ�����
			session.beginTransaction();
			// ����Hibernate�ṩ�ķ������������������ݶ���
			session.saveOrUpdate(s1);
			session.saveOrUpdate(s2);
			session.saveOrUpdate(s3);
			
			session.getTransaction().commit(); // �ύ���ݿ�����
			// ִ�����ݿ��ѯ
			Query q = session
					.createQuery("from Student where java between :f1 and :f2");
			q.setInteger("f1", 60);
			q.setInteger("f2", 80);

			List<Student> l = q.list();
			session.getTransaction().begin();
			for (Iterator<Student> it = l.iterator(); it.hasNext();) {
				Student s = it.next();
				log.info(s);
				s.setJava(s.getJava() + 5); // ��Java�ɼ���60�ֺ�80��֮��ģ�
											// session.update(s); //����5�֡�
			}

			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ����������MyBatis��ʵ��ORM����Hibernate�Ƚ����ơ�
	public void mybatis() {
		try {
			/*
			 * ��Hibernateһ����Ҳ�ǹ���ģʽ��������ݿ������װ��session �У�
			 * session����Ĵ���Ҳ��ͨ��session�������������������������
			 */
			String resource = "Configuration.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			SqlSession session = sqlSessionFactory.openSession();
			/*
			 * ����һ����¼��ע��com.abc.or.selectStudent��ӳ���ļ���
			 * һ��select����Ӧ��id����ȻҪ����namespace
			 */
			Student s = (Student) session.selectOne("com.abc.or.selectStudent",
					"008");
			log.info(s);

			s.setJava(95); // �޸ĳɼ���ִ�ж�Ӧ��update��䣬
			session.update("com.abc.or.updateStudent", s); // �������s
			session.commit();

			HashMap map = new HashMap(); // ����Ҳ������Map����
			map.put("value1", 60); // ����ֵ�Ե���ʽ��������
			map.put("value2", 100);

			List<Student> list = session.selectList(
					"com.abc.or.selectStudentBetween", map);
			for (Iterator<Student> it = list.iterator(); it.hasNext();) {
				s = it.next();
				log.info(s);
			}
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // MyBatisʵ�ֽ���������ϲ��SQL�Ŀ�����Ա��˵��MyBatis����
} // Ч�ʱ�Hibernate��һЩ��
