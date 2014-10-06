package com.abc.bean;

import java.io.*;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.*;
import java.beans.*;

public class BeanFactory {
	private Properties props = new Properties(); // Properties���Լ��ϣ���ֵ�����ݼ���
	private Map beans = new TreeMap();

	public BeanFactory() {
		try {
			props.load(new FileInputStream("app.properties")); // �������������ļ�
			String xmlFile = props.getProperty("configFile"); // ������
			SAXReader reader = new SAXReader(); // DOM4J���
			Document doc = reader.read(new File(xmlFile));
			org.dom4j.XPath path = doc.createXPath("/beans/bean");// ����beanԪ��
			List list = path.selectNodes(doc);
			ClassLoader cl1 = getClass().getClassLoader(); // ����������
			for (int i = 0; i < list.size(); i++) {
				Element node = (Element) list.get(i);
				String name = node.attributeValue("name");
				String clazz = node.attributeValue("class");
				// ����java.beans.Beans������ɶ�̬�Ĵ���ĳ�����ʵ��
				// ���ԱȽ��������г���
				// Object a = new A();
				// Object b = Beans.instantiate(cl1, "A");
				beans.put(name, Beans.instantiate(cl1, clazz));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object getBean(String name) {
		return beans.get(name);
	}

	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		StringBuffer str = (StringBuffer) factory.getBean("b2");
		str.append("hello world!");
		System.out.println(str.toString());
	}
}
