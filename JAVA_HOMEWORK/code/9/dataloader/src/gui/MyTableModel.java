//���������Զ���ı������ģ�ͣ�ʵ����TableModel�ӿڣ�MyTableModel.java
package gui;

import javax.swing.event.TableModelListener;
import javax.swing.table.*;
import java.util.*;
import base.*;

public class MyTableModel implements TableModel {
	private ArrayList<Student> al; // ���ݼ��ص����ݼ�������һ�����ģ��
	private int rowCount = 0; // �����������

	public MyTableModel(ArrayList<Student> al) {
		this.al = al;
		rowCount = al.size();
	}

	public int getRowCount() { // ���ر��ģ�͵ļ�¼����
		return rowCount;
	}

	public int getColumnCount() { // ���ر��ģ�͵�����
		return 6;
	}

	public String getColumnName(int columnIndex) { // ���ر��ģ�͵�����
		switch (columnIndex) {
		case 0:
			return "ѧ��";
		case 1:
			return "����";
		case 2:
			return "�Ա�";
		case 3:
			return "�ʼ���ַ";
		case 4:
			return "����";
		case 5:
			return "Java";
		}
		return null;
	}

	public Class<?> getColumnClass(int columnIndex) { // ��������ݵ�����
		switch (columnIndex) {
		case 0: // ѧ�ţ��������Ա��ʼ�����ʾΪ�ַ�������
		case 1:
		case 2:
		case 3:
			return String.class;
		case 4: // Java�ɼ���������ʾΪ��������
		case 5:
			return Integer.class;
		}
		return null;
	}

	// ����е������ܷ�༭������Ϊfalse�����ɱ༭��
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Object getValueAt(int rowIndex, int columnIndex) { // ���ر���е�����
		Student s = al.get(rowIndex); // �õ�ĳ������
		switch (columnIndex) { // ���������ظ������ݵ�ĳ���е�ֵ
		case 0:
			return s.getId();
		case 1:
			return s.getName();
		case 2:
			return s.getGender() ? "��" : "Ů";
		case 3:
			return s.getEmail();
		case 4:
			return new Integer(s.getAge());
		case 5:
			return new Integer(s.getJava());
		}
		return null;
	}

	// �����޸ı��ģ���е����ݣ��������У���������ʾ������û��ʵ�֡�
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		return;
	}

	// ����ģ�͵��¼����ڵķ���������Ҳû�б�Ҫʵ�֡�
	public void addTableModelListener(TableModelListener l) {
		return;
	}

	public void removeTableModelListener(TableModelListener l) {
		return;
	}
}
