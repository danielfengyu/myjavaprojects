import javax.xml.parsers.*; //JDK�ṩ��XML��������
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.*;

public class SaxDemo {
	public enum TAG_FLAG { // ����һ��ö�����ͣ���ʾ���ڽ����ĸ�Ԫ��.
		none, id, name, email, age, gender, java
	};

	public static void main(String[] args) {
		try { // ��������ģʽ
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser p1 = factory.newSAXParser(); // ����һ��SAX������
			// ��ʼ����student.xml�����ݣ��ṩ���¼�ͨ��ContentHandler��֪ͨ
			// ���������������̳�DefaultHandler�������ʵ�֣�DefaultHandler��
			// ʵ����ContentHandler�ӿڣ��ڸ��������и����¼��������
			p1.parse(new FileInputStream("student.xml"), new DefaultHandler() {
				private TAG_FLAG tag_flag = TAG_FLAG.none; // ö�����ͱ���
				private StringBuffer content = new StringBuffer();
				String id, name, email;
				int age, java;
				boolean gender;

				// ��������ĳ��Ԫ�ص���ʼ���ʱ�������������������
				// �������������Ҫ�жϵ�ǰ������Ԫ�ر�ǵ����ֵ���Ϣ
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					if (qName.equals("id")) {
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

				// ����Ԫ������ʱ�������������
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

				// ������������ڽ�����Ԫ�صĽ������ʱ����ִ��
				public void endElement(String uri, String localName,
						String qName) throws SAXException {
					content = new StringBuffer(); // �½�һ�����ݻ�����
					tag_flag = TAG_FLAG.none;
					if (qName.equals("student")) { // �������student�������
						// ��studentԪ��ת��Ϊһ��student���������Student��Ļ�
						// Student s = new Student(id, name, email, java, age,
						// gender);
						if (java < 60) { // ����������ѧ������
							System.out.println(name);
						}
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
