package com.jsp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.UTFDataFormatException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
public class Operate {
	private int size;
	private SAXReader reader;
	private Document document;
	private Element root;
	private Element currentNode;
	private int currentPage;
	private int totalPages;
	int maxRowNum = 10;
	
	public Operate(int curr)
	{
		reader = new SAXReader();
		try {
			document = reader.read(new File("E:\\J2EE��ҵ\\StudentInformation\\WebContent\\WEB-INF\\Students.xml"));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		root = document.getRootElement();
		setSize();
		setTotalPages();
		setCurrentPage(curr);
	}
	
	public int getMaxRowNum()
	{
		return maxRowNum;
	}
	public int getCurrentPage()
	{
		return currentPage;
	}
	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}
	public int getTotalPages()
	{
		return totalPages;
	}
	public void setTotalPages()
	{
		totalPages = (size % maxRowNum == 0)?(size / maxRowNum):(size / maxRowNum + 1);
	}
	public int getSize()
	{
		return size;
	}
	public void setSize()
	{
		for(Iterator it = root.elementIterator(); it.hasNext();it.next())
        	size++;
	}
	public Element getCurrentNode()
	{
		return currentNode;
	}
	public Element getRoot()
	{
		return root;
	}
	
	public synchronized void addElement(String id, String name, String age, String gender, String email, String java) throws IOException
	{
		//�½�ѧ���ڵ�
		Element childelement = root.addElement("student");
		
		//��������
		Element idElement = childelement.addElement("id");
		Element nameElement = childelement.addElement("name");
		Element ageElement = childelement.addElement("age");
		Element genderElement = childelement.addElement("gender");
		Element emailElement = childelement.addElement("email");
		Element javaElement = childelement.addElement("java");
		
		//��������ֵ
		idElement.setText(id);
		nameElement.setText(name);
		ageElement.setText(age);
		genderElement.setText(gender);
		emailElement.setText(email);
		javaElement.setText(java);
		
		//���xml�����ʽΪgb2312�Ļ�����ô�ַ���Ӧ�����ó�format.setEncoding("gb2312");  
		//Ҳ����xml���ַ�����ƥ�������õ��ַ�����һ��  
		//FileOutputStream�ı���Ҳ�ǰ���format���õ��ַ������б���  
		OutputFormat format = OutputFormat.createPrettyPrint();  
		format.setEncoding("utf-8");  
		
		//����д�ص�ԭxml�ļ�
		XMLWriter writer = new XMLWriter(   
				new FileOutputStream("E:\\J2EE��ҵ\\StudentInformation\\WebContent\\WEB-INF\\Students.xml" ), format );  
		writer.write( document);  
		writer.close();  
	}
	public synchronized boolean deleteElement(String nameOrid) throws IOException
	{
		boolean flag = false;
		//��ѯ��������ҵ���ѧ����Ϣ
		List list = new ArrayList();
		list = readElement(nameOrid);
		
		for(int i = 0; i < list.size(); i++)
		{
			List studentlist = document.getRootElement().elements("student");
			Element e = (Element)list.get(i);
			
			//�Ƴ�
			e.getParent().remove(e);
			
			OutputFormat format = OutputFormat.createPrettyPrint();  
	        format.setEncoding("utf-8");  
	        XMLWriter writer = new XMLWriter(   
	                new FileOutputStream( "E:\\J2EE��ҵ\\StudentInformation\\WebContent\\WEB-INF\\Students.xml" ), format );  
	        writer.write( document);  
	        writer.close();  
	        flag = true;
		}
		return flag;
	}
	public synchronized boolean updateElement(String id, String num2, String content) throws IOException
	{
		boolean flag = false;
		//��ѯ��������ҵ���ѧ����Ϣ
		int num = Integer.parseInt(num2);
		List list = new ArrayList();
		list = readElement(id); 
		
		for(int i = 0; i < list.size(); i++)
		{
			List studentlist = document.getRootElement().elements("student");
			
			Element e1 = (Element)list.get(i);
			List attributes = e1.elements();
			
			Element e2 = (Element) attributes.get(num);
			e2.setText(content); 
			
			OutputFormat format = OutputFormat.createPrettyPrint();  
	        format.setEncoding("utf-8");  
	          
	        XMLWriter writer = new XMLWriter(   
	        		new FileOutputStream( "E:\\J2EE��ҵ\\StudentInformation\\WebContent\\WEB-INF\\Students.xml"), format );  
	        writer.write( document);  
	        writer.close();
	        flag = true;
		}
		return flag;     
	}
	public synchronized List readElement(String nameOrid)
	{
		//���������� �����ҵ��Ľ������list��
		Iterator it = root.elementIterator();
		int i = 0;
		List list = new ArrayList();
	    while(it.hasNext())
	    {
	    	Element e1 = (Element)it.next();
	    	//Element e1 = (Element) root.elements("student").get(1);  
	    	String name="";
			try {
				name = new String(e1.element("name").getText().getBytes("gb2312"),"ISO-8859-1");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        String id=e1.element("id").getText();
	        //id = new String(id.getBytes("ISO-8859-1"), "gb2312");
	        if(nameOrid.equals(id)||nameOrid.equals(name) )
	        {
	        	list.add(e1);
	        	//����ѧ�������ظ��������ٴβ��ң�ֱ������
	    	    if(nameOrid.charAt(0) >= '0' && nameOrid.charAt(0) <= '9')
	    	    	break;
	        }
	           
	    }
		return list;
	}
	
}

