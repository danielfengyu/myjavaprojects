package gui;

import base.*;
import java.util.*;

import org.dom4j.*;
import org.dom4j.io.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		/* �������ݣ������������������̨ */
		DataLoaderFactory factory = new DataLoaderFactory();
		DataLoader loader = factory.getDataLoader();
		ArrayList<Student> s = loader.load();
		for (Iterator<Student> it = s.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
		/* �����ص����ݼ��������student2.xml�ļ��� */
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		Element root = document.addElement("students");
		root.addNamespace("", "http://www.abc.com/ns/test"); // ��������ռ�
		root.addNamespace("t", "http://www.abc.com/ns/test");
		root.addNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		root.addAttribute("xsi:schemaLocation",
				"http://www.abc.com/ns/test student.xsd");

		for (int i = 0; i < s.size(); i++) {
			Student stu = s.get(i);
			Element e1 = root.addElement("student",
					"http://www.abc.com/ns/test");
			// e1.addNamespace("", "http://www.abc.com/ns/test");

			e1.addElement("id").addText(stu.getId());
			e1.addElement("name").addText(stu.getName());
			e1.addElement("email").addText(stu.getEmail());
			e1.addElement("gender").addText(stu.getGender() ? "��" : "Ů");
			e1.addElement("age").addText("" + stu.getAge());
			e1.addElement("java").addText("" + stu.getJava());

		}
		FileOutputStream fos = new FileOutputStream("student2.xml");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
		OutputFormat of = new OutputFormat();
		of.setEncoding("GBK"); // ���ñ���
		of.setIndent(true); // ����XMLԪ��������ʽ
		of.setIndent("    "); // ���������հ��ַ���Ϊ4���հ׷�
		of.setNewlines(true); // ���д洢
		XMLWriter writer = new XMLWriter(osw, of);
		writer.write(document);
		writer.close();

		MainJFrame mj = new MainJFrame(s); // ��ʾGUI����
	}
}
