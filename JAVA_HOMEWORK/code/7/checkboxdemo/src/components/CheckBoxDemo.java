package components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxDemo extends JPanel implements ItemListener {
	JCheckBox chinButton; // ��Ӧ4����ѡ��
	JCheckBox glassesButton;
	JCheckBox hairButton;
	JCheckBox teethButton;

	StringBuffer choices; // ��ѡ���е��������ַ�������ʽ�洢
	JLabel pictureLabel; // �ñ�ǩ������ʾͼƬ��JLabel����������ʾ

	// �ı�����������ʾIconͼ��
	public CheckBoxDemo() {
		super(new BorderLayout()); // ѡ��߽粼��
		chinButton = new JCheckBox("Chin");
		chinButton.setMnemonic(KeyEvent.VK_C);
		chinButton.setSelected(true);

		glassesButton = new JCheckBox("Glasses");
		glassesButton.setMnemonic(KeyEvent.VK_G);
		glassesButton.setSelected(true);

		hairButton = new JCheckBox("Hair");
		hairButton.setMnemonic(KeyEvent.VK_H);
		hairButton.setSelected(true);

		teethButton = new JCheckBox("Teeth");
		teethButton.setMnemonic(KeyEvent.VK_T);
		teethButton.setSelected(true);

		chinButton.addItemListener(this); // ע�Ṳͬ������
		glassesButton.addItemListener(this);
		hairButton.addItemListener(this);
		teethButton.addItemListener(this);

		// ��ʾ�����ˣ��Ա�ĵ�ǰ״̬
		choices = new StringBuffer("cght");

		// ����ͼ���ǩ
		pictureLabel = new JLabel();
		// pictureLabel.setFont(pictureLabel.getFont().deriveFont(Font.ITALIC));
		updatePicture(); // ��ʾͼ��

		// Put the check boxes in a column in a panel
		JPanel checkPanel = new JPanel(new GridLayout(0, 1));// X��1��
		checkPanel.add(chinButton); // ��������Ϊ4��1��
		checkPanel.add(glassesButton); // ��ָ����Ҳ����
		checkPanel.add(hairButton);
		checkPanel.add(teethButton);

		add(checkPanel, BorderLayout.LINE_START);
		add(pictureLabel, BorderLayout.CENTER);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	/** ����JCheckBox�ĵ���¼�. */
	public void itemStateChanged(ItemEvent e) { // ItemEvent��Ӧ���¼�������
		int index = 0;
		char c = '-';
		Object source = e.getItemSelectable(); // ����¼�Դ
		if (source == chinButton) { // �ж��¼�Դ
			index = 0; // �����ַ�λ��
			c = 'c';
		} else if (source == glassesButton) {
			index = 1;
			c = 'g';
		} else if (source == hairButton) {
			index = 2;
			c = 'h';
		} else if (source == teethButton) {
			index = 3;
			c = 't';
		}

		// ���״̬��δѡ�����ַ�Ϊ-
		if (e.getStateChange() == ItemEvent.DESELECTED) {
			c = '-';
		}
		// ������ʾ�����ַ���.
		choices.setCharAt(index, c);
		updatePicture(); // ����ͼ��
	}

	protected void updatePicture() {
		// �õ���Ӧ��Iconͼ���ļ�����choices�����ݾ���
		ImageIcon icon = createImageIcon("images/geek/geek-"
				+ choices.toString() + ".gif");
		pictureLabel.setIcon(icon);
		pictureLabel.setToolTipText(choices.toString());
		if (icon == null) {
			pictureLabel.setText("Missing Image");
		} else {
			pictureLabel.setText(null);
		}
	}

	/* ����ͼ�񣬷���һ��ImageIcon */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = CheckBoxDemo.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("CheckBoxDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComponent newContentPane = new CheckBoxDemo();
		newContentPane.setOpaque(true); // conentPane����Ϊ��͸��
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
