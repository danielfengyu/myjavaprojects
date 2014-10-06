import java.io.*;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.*;

public class DOM4JDemo {
	public static void main(String[] args) throws Exception {
		// ʹ��SAX������DOM�������ϣ�ʹ��SAX��XML�����ȶ���
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("student.xml")); // �����ĵ�����doc
		// ʹ��XPATH��λ��Щ�������ѧ����������ǵ�����
		org.dom4j.XPath path = doc
				.createXPath("/students/student[java<60]/name");
		List list = path.selectNodes(doc);
		for (int i = 0; i < list.size(); i++) {
			Node node = (Node) list.get(i);
			System.out.println(node.getStringValue());
		}
	}
}
