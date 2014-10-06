package impl;

import java.util.*;
import java.io.*;
import base.*;

import org.apache.poi.hssf.usermodel.*;

public class ExcelDataLoader implements DataLoader {
	public ArrayList<Student> load() {
		ArrayList<Student> r = new ArrayList<Student>();
		try {
			// ��student.xls�ļ�������һ������������
			HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(
					"student.xls"));
			// ��һ�����������ѧ���������ڵĹ�����
			HSSFSheet sheet = wb.getSheetAt(0);
			// �õ����ݼ�¼������
			int rows = sheet.getPhysicalNumberOfRows();
			// ��ͷ��Ϣ��ѧ�ţ������ȵ�
			HSSFRow row = sheet.getRow(0);
			int cols = row.getPhysicalNumberOfCells();
			// �ӵ�1�п�ʼ��ȡ���ݣ���Ϊ��0������������
			for (int i = 1; i < rows; i++) {
				row = sheet.getRow(i);
				HSSFCell cell = row.getCell(0);
				String id = cell.getStringCellValue();
				id = id.trim();
				cell = row.getCell(1);
				String name = cell.getStringCellValue();
				name = name.trim();
				cell = row.getCell(3);
				String email = cell.getStringCellValue();
				email = email.trim();
				cell = row.getCell(4);
				String gender = cell.getStringCellValue();
				gender = gender.trim();
				cell = row.getCell(5);
				// ��ȡ��ֵ����
				double age = cell.getNumericCellValue();
				cell = row.getCell(6);
				double java = cell.getNumericCellValue();
				// ��Excel������ת��ΪJava��������
				Student s = new Student(id, name, email, (int) java, (int) age,
						gender.equals("��"));
				r.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	public static void main(String[] args) {
		//���Գ���
		DataLoader loader = new ExcelDataLoader();
		ArrayList<Student> st = loader.load();
		for(Iterator<Student> it = st.iterator(); it.hasNext(); ) {
			Student s = it.next();
			System.out.println(s);
		}
	}
	
}
