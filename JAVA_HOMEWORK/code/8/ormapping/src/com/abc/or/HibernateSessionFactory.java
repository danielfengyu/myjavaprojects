package com.abc.or;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
	/*
	 * ThreadLocalΪ������̳߳���Ĳ��������ṩ��һ���µ�˼·��ʹ�������������Ժܼ��ر�д�������Ķ��̳߳���
	 * ThreadLocal������һ��Thread������Thread�ľֲ����������ṩ��ǰ�߳��оֲ����ݶ���Ĵ�ȡ������
	 */
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static Configuration configuration = new Configuration();
	private static org.hibernate.SessionFactory sessionFactory;
	private static String configFile = CONFIG_FILE_LOCATION;

	/*
	 * ��̬��ʼ�����룬�������ִ����ľ�̬����֮ǰ�����ߴ����������Ȳ��� ��������̬��ʼ�������ִ�С�
	 */
	static {
		try {
			configuration.configure(configFile); // �������ļ�������SessionFactory����
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			/* �����־��Ϣ */
			Test.log.error("Error Creating SessionFactory.");
			Test.log.error(e.getMessage());
		}
	}

	private HibernateSessionFactory() { // �������ֹʵ������Ҳ����ͨ����
	} // ���췽������Ϊ˽�е�����ֹʵ������
		// �������ڲ�����ʵ���������ⲻ���ԡ�

	public static Session getSession() throws HibernateException {
		/*
		 * �ȴӵ�ǰ�߳���ȡ�������û�����½�һ���������󣬽�������Session
		 * �����ٷŵ�ThreadLocal�����У����ڲ�ͬ���̴߳���ͬ������ͻ���
		 * ��ͬ�Ŀͻ�Ӧ�÷��ʲ�ͬ�����ݿ�Ự������ͨ�����threadLocal�������
		 * ʵ���ֲ߳̾�����Ĺ���ThreadLocal����ֲ߳̾����ݵ�֧�ַǳ����㡣
		 */
		Session session = (Session) threadLocal.get();

		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession()
					: null;
			threadLocal.set(session); // ���뵽ThreadLocal�����к��Ժ�����߳�
		} // ��ȡ���session����ͷǳ������ˡ�
			// ��֤ÿ���̶߳���ռ��һ��session��
		return session;
	}

	public static void rebuildSessionFactory() {
		try {
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}

	public static void closeSession() throws HibernateException {
		Session session = (Session) threadLocal.get();
		threadLocal.set(null); // �ͷŵ�session

		if (session != null) {
			session.close();
		}
	}

	public static org.hibernate.SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setConfigFile(String configFile) {
		HibernateSessionFactory.configFile = configFile;
		sessionFactory = null;
	}

	public static Configuration getConfiguration() {
		return configuration;
	}

}
