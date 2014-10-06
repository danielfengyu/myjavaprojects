package components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListDemo extends JPanel // DocumentListener���ĵ��¼������ڽӿ�
		implements ListSelectionListener, ActionListener, DocumentListener {

	private JList list;
	private DefaultListModel listModel;
	private static final String hireString = "Hire";
	private static final String fireString = "Fire";
	private JButton fireButton;
	private JButton hireButton;
	private JTextField employeeName; // �ı�������������Ӧ��ģ����Document

	// Document�����DocumentEvent�¼�
	public ListDemo() {
		super(new BorderLayout()); // ���ñ߽粼�ֹ�����

		listModel = new DefaultListModel(); // �����б�ģ�Ͷ���
		listModel.addElement("Jane Doe"); // ����б�������
		listModel.addElement("John Smith");
		listModel.addElement("Kathy Green");

		// ����JList���󣬲�����JScrollPane��
		list = new JList(listModel);
		// �����б������ѡ��ģʽ�ǵ�ѡģʽ��ֻ��ѡ��һ���б��Ĭ���Ƕ�ѡ
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0); // ѡ�е�һ���б���
		list.addListSelectionListener(this); // ���ѡ��仯�¼���Ӧ���¼�����
		list.setVisibleRowCount(5); // ����Ϊ��ʾ5���б���
		// ��ӵ�JScrollPane���ṩ����֧��
		JScrollPane listScrollPane = new JScrollPane(list);

		hireButton = new JButton(hireString);
		hireButton.setActionCommand(hireString); // ��û��ʹ��ActionCommand
		hireButton.addActionListener(this);
		hireButton.setEnabled(false); // ��ť�ҵ�

		fireButton = new JButton(fireString);
		fireButton.setActionCommand(fireString);
		fireButton.addActionListener(this);

		employeeName = new JTextField();
		employeeName.setPreferredSize(new Dimension(150, 25));
		employeeName.addActionListener(this);
		// Ϊ�ĵ�ģ�Ͷ���ע������
		employeeName.getDocument().addDocumentListener(this);

		// ����һ����壬���ð�ť���ı��������
		JPanel buttonPane = new JPanel();
		// ���аڷţ���ָ��ˮƽ����ʹ�ֱ����ķ�϶��С
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttonPane.add(fireButton);
		buttonPane.add(employeeName);
		buttonPane.add(hireButton);

		buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		add(listScrollPane, BorderLayout.CENTER);
		add(buttonPane, BorderLayout.PAGE_END);
	}

	/*
	 * ��ǰ��ʵ�����¼����ڣ���������ť�͵����ı�����Ĺ�ͬ���¼����ڣ� ���û������ť�������ڵ����ı�������м���س�ʱ�����ActionEvent
	 * �¼�����Ӧ�����ڽӿ�ΪActionListener���¼�������ΪactionPerform����
	 */
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource(); // �õ��¼�Դ����
		if (o == fireButton) {
			int index = list.getSelectedIndex(); // ����ѡ�е��б���
			listModel.remove(index); // ��ģ����ɾ������fire��������
			int size = listModel.getSize();
			if (size == 0) { // ����б�ģ���Ѿ�û�������ˣ���ô�ҵ�fireButton
				fireButton.setEnabled(false); // ����fireButtonΪ������״̬
			} else { // ���ģ�Ͳ�Ϊ�գ���ѡ����һ��
				if (index == listModel.getSize()) { // ��������һ������Ϊǰһ��
					index--;
				}
				list.setSelectedIndex(index);
				list.ensureIndexIsVisible(index); // ȷ��ѡ�е������������ʾ����
			}
		} else if (o == hireButton) {
			String name = employeeName.getText();
			name = name.trim();
			if (name.length() == 0 || listModel.contains(name)) {
				Toolkit.getDefaultToolkit().beep(); // ����Ϊ�ջ��߸����������б���
				employeeName.requestFocusInWindow(); // �õ����뽹��
				employeeName.selectAll(); // ѡ��ȫ������
				return;
			}

			int index = list.getSelectedIndex();
			if (index == -1) { // ���û��ѡ�е������������ڵ�һ����λ��
				index = 0;
			} else { // �����ѡ�е��б���֮���λ��
				index++;
			}

			listModel.insertElementAt(name, index); // ��ģ���в�������
			employeeName.requestFocusInWindow(); // �������뽹��
			employeeName.setText(""); // ����ı�������
			list.setSelectedIndex(index); // ����ѡ�е��б���
			list.ensureIndexIsVisible(index);

		} else if (o == employeeName) {
			hireButton.doClick(); // �ڵ����ı�������а��»س���
		} // ����hireButton��doClick�������ȼ���
	} // ����hireButton��ť��

	/* ������3������������DocumentListener�ӿ��� */
	public void insertUpdate(DocumentEvent e) { // �ĵ��в����ı�����
		hireButton.setEnabled(true);
	}

	public void removeUpdate(DocumentEvent e) { // �ĵ���ɾ���ı�����
		if (e.getDocument().getLength() <= 0) { // ����ı�����Ϊ�գ�
			hireButton.setEnabled(false); // �Ͱ�hireButton�ҵ�
		} // ���������֣�û�취�����á�
	}

	public void changedUpdate(DocumentEvent e) { // �ĵ����ݷ����仯
		removeUpdate(e); // �����ͬ������ķ���
	}

	// ListSelectionListener�ж�����¼�������
	// ���б�ģ����������ѡ�����仯ʱ������ListSelectionEvent�¼�
	// �����ǰ�б�����Ѿ���ѡ��ѡ�У���ôͨ�����������һ�ѡ�����
	// �仯�ˣ������ListSelectionEvent�¼�������ʹ�ü������б������ƶ�Ҳ�����
	// ����¼�������������������������¼��������ƶ������һ���¼�
	// ����������¼�����ǰ�����¼���getValueIsAdjusting����Ϊtrue��Ӧ��ȡ
	// ���һ�β����¼���״̬������getValueIsAdjusting����Ϊfalse��
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) { // ���¼��Ƿ���һ�������¼�
			if (list.getSelectedIndex() == -1) { // ���Ϊ�����¼������һ����false
				fireButton.setEnabled(false); // ���û��ѡ���κ��б���ҵ�
			} else {
				fireButton.setEnabled(true);
			}
		}
	}

	private static void createAndShowGUI() {
		// ����ǰ������һ�����������ڲ����á�
		JFrame frame = new JFrame("ListDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComponent newContentPane = new ListDemo();
		newContentPane.setOpaque(true); // ContentPane������͸���ġ�
		frame.setContentPane(newContentPane);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
