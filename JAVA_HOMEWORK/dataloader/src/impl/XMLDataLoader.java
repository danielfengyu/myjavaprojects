package impl;

import base.*;
import java.util.*;
import java.io.*;

import org.jdom.*;
import org.jdom.input.*;

import javax.xml.parsers.*;
import org.xml.sax.helpers.*;
import org.xml.sax.*;

public class XMLDataLoader implements DataLoader {
	public enum TAG_FLAG { // Java5�ṩ��ö����������
		none, id, name, email, age, gender, java
	};

	public ArrayList<Student> load() {
		try {
			/* �����������ļ� */
			Properties p = new Properties();
			p.load(new FileInputStream("loader.properties"));
			String xml = p.getProperty("xmlprocess");
			/* ����xmlprocess����ֵ��ȷ��ʹ�ú��ֽ�����ʽ */
			if (xml.equalsIgnoreCase("sax")) {
				return load_sax();
			} else if (xml.equalsIgnoreCase("dom4j")) {
				return load_dom4j();
			} else if (xml.equalsIgnoreCase("jdom")) {
				return load_jdom();
			} else {
				return load_sax();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Student>();
		}
	}

	private ArrayList<Student> load_dom4j() {
		ArrayList<Student> r = new ArrayList<Student>();
		// ʹ��DOM4J���������������ռ��XML�ļ�
		try {
			Map map = new HashMap();
			org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
			reader.setValidation(false);
			org.dom4j.Document doc = reader.read(new FileInputStream(
					"student.xml"));
			org.dom4j.Element root = doc.getRootElement();

			String defaultNamespace = root.getNamespaceURI();
			map.put("default", defaultNamespace);
			reader.getDocumentFactory().setXPathNamespaceURIs(map);

			// ���������ռ�Ľ�����DOM4JҲ֧��Ĭ�������ռ�
			org.dom4j.XPath path = doc
					.createXPath("/default:students/default:student");
			path.setNamespaceURIs(map);
			List list = path.selectNodes(doc);

			for (Iterator it = list.iterator(); it.hasNext();) {
				org.dom4j.Node stu = (org.dom4j.Node) it.next();
				// XPATH·��������child::default:id
				org.dom4j.XPath pathc = stu.createXPath("child::*");
				pathc.setNamespaceURIs(map);
				List child = pathc.selectNodes(stu);

				String id = "", name = "", email = "";
				int age = 0, java = 0;
				boolean gender = false;
				// ����studentԪ�ص���Ԫ��
				for (int i = 0; i < child.size(); i++) {
					org.dom4j.Element e1 = (org.dom4j.Element) child.get(i);
					String tname = e1.getName();
					String tvalue = e1.getText();

					if (tname.equals("id")) {
						id = tvalue;
					} else if (tname.equals("name")) {
						name = tvalue;
					} else if (tname.equals("email")) {
						email = tvalue;
					} else if (tname.equals("gender")) {
						gender = tvalue.equals("��");
					} else if (tname.equals("age")) {
						age = Integer.parseInt(tvalue);
					} else if (tname.equals("java")) {
						java = Integer.parseInt(tvalue);
					}
				}
				Student s = new Student(id, name, email, java, age, gender);
				r.add(s);
			}
			/*
			 * //����һ�ֱ�̴������ org.dom4j.Element e = doc.getRootElement(); Iterator
			 * it = e.elementIterator("student"); while (it.hasNext()) {
			 * org.dom4j.Element s1 = (org.dom4j.Element) it.next(); String id =
			 * s1.element("id").getText(); String name =
			 * s1.element("name").getText(); String email =
			 * s1.element("email").getText(); boolean gender =
			 * s1.element("gender").getText().equals("��"); int age =
			 * Integer.parseInt(s1.element("age").getText()); int java =
			 * Integer.parseInt(s1.element("java").getText()); Student s = new
			 * Student(id, name, email, java, age, gender); r.add(s); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	private ArrayList<Student> load_jdom() {
		ArrayList<Student> r = new ArrayList<Student>();
		// ʹ��JDOM������Ҫ��һЩ�����������ռ�Ĵ������
		try {
			SAXBuilder builder = new SAXBuilder();
			Document d = builder.build(new FileInputStream("student.xml"));
			Element root = d.getRootElement();
			Namespace ns = root.getNamespace();
			List st = root.getChildren("student", ns);
			for (int i = 0; i < st.size(); i++) {
				Element stu = (Element) st.get(i);
				String id = stu.getChildText("id", ns);
				String name = stu.getChildText("name", ns);
				int age = Integer.parseInt(stu.getChildText("age", ns));
				boolean gender = stu.getChildText("gender", ns).equals("��");
				String email = stu.getChildText("email", ns);
				int java = Integer.parseInt(stu.getChildText("java", ns));
				Student s1 = new Student(id, name, email, java, age, gender);
				r.add(s1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	private ArrayList<Student> load_sax() {
		// ʹ��SAX��̣����������¼��Ĵ���ʽ������е��鷳����Ч�ʺܸ�
		final ArrayList<Student> r = new ArrayList<Student>();
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser p1 = factory.newSAXParser();
			p1.parse(new FileInputStream("student.xml"), new DefaultHandler() {
				// �����ඨ��
				private TAG_FLAG tag_flag = TAG_FLAG.none;
				private StringBuffer content = new StringBuffer();
				String id, name, email;
				int age, java;
				boolean gender;

				public void endElement(String uri, String localName,
						String qName) throws SAXException {
					content = new StringBuffer();
					tag_flag = TAG_FLAG.none;
					// ������studentԪ�صĽ������
					if (qName.equals("student")) {
						Student s = new Student(id, name, email, java, age,
								gender);
						r.add(s);
					}
				}

				// ������ĳԪ�ص���ʼ���
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					if (qName.equals("id")) { // TAG_FLAG��ö������
						tag_flag = TAG_FLAG.id;
					} else if (qName.equals("name")) {
						tag_flag = TAG_FLAG.name;
					} else if (qName.equals("email")) {
						tag_flag = TAG_FLAG.email;
					} else if (qName.equals("age")) {
						tag_flag = TAG_FLAG.age;
					} else if (qName.equals("java")) {
						tag_flag = TAG_FLAG.java;
					} else if (qName.equals("gender")) {
						tag_flag = TAG_FLAG.gender;
					} else {
						tag_flag = TAG_FLAG.none;
					}
				}

				// ����Ԫ������
				public void characters(char[] ch, int start, int length)
						throws SAXException {
					content.append(new String(ch, start, length));
					String s = content.toString();
					s = s.trim(); // trim whitespace
					switch (tag_flag) {
					case id:
						id = s;
						break;
					case name:
						name = s;
						break;
					case email:
						email = s;
						break;
					case age:
						age = Integer.parseInt(s);
						break;
					case java:
						java = Integer.parseInt(s);
						break;
					case gender:
						gender = s.equals("��");
						break;
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
}
