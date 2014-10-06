package components;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/* 
 * ButtonDemo.java ��Ҫ�����ļ�
 *   images/right.gif
 *   images/middle.gif
 *   images/left.gif
 */
public class ButtonDemo extends JPanel implements ActionListener {
	protected JButton b1, b2, b3;

	public ButtonDemo() {
		// ����3��ImageIcon
		ImageIcon leftButtonIcon = createImageIcon("images/right.gif");
		ImageIcon middleButtonIcon = createImageIcon("images/middle.gif");
		ImageIcon rightButtonIcon = createImageIcon("images/left.gif");

		b1 = new JButton("Disable middle button", leftButtonIcon);
		// ��ֱ�������־���
		b1.setVerticalTextPosition(AbstractButton.CENTER);
		// ���ֲ��ֿ����
		b1.setHorizontalTextPosition(AbstractButton.LEADING);
		b1.setMnemonic(KeyEvent.VK_D); // ��ݼ�����ΪAlt+D
		b1.setActionCommand("disable"); // ����actionCommand����

		b2 = new JButton("Middle button", middleButtonIcon);
		b2.setVerticalTextPosition(AbstractButton.BOTTOM);
		b2.setHorizontalTextPosition(AbstractButton.CENTER);
		b2.setMnemonic(KeyEvent.VK_M);

		b3 = new JButton("Enable middle button", rightButtonIcon);
		// ʹ��Ĭ�ϵ�״̬����ֱ���У�ˮƽ�����Ҳ�
		// b3.setHorizontalTextPosition(AbstractButton.TRAILING);
		b3.setMnemonic(KeyEvent.VK_E);
		// �ڶ����ť����һ���¼�����ʱ�����¼����������ж�
		// �ĸ���ť������ʱ��actionCommand���Խ���ʹ��
		b3.setActionCommand("enable");
		b3.setEnabled(false);

		// Listen for actions on buttons 1 and 3.
		b1.addActionListener(this);
		b3.addActionListener(this);
		// Ϊ��ť��ӹ�����ʾ���������ڰ�ť��һ���ʱ������ʾ�ı�
		b1.setToolTipText("Click this button to disable the middle button.");
		b2.setToolTipText("This middle button does nothing when you click it.");
		b3.setToolTipText("Click this button to enable the middle button.");

		// �����Щ��ť������У�������Ĭ�ϲ�����FlowLayout
		add(b1);
		add(b2);
		add(b3);
	}

	public void actionPerformed(ActionEvent e) {
		if ("disable".equals(e.getActionCommand())) {
			b2.setEnabled(false); // ���İ�ť״̬
			b1.setEnabled(false);
			b3.setEnabled(true);
		} else {
			b2.setEnabled(true);
			b1.setEnabled(true);
			b3.setEnabled(false);
		}
	}

	/** ����һ��ImageIcon�����·�����Ի�ͼ���ļ��������򷵻�null */
	protected static ImageIcon createImageIcon(String path) {
		// ʹ��ButtonDemo�����������������ļ�
		// ��Ҫ����Դ�ļ�������ͬһ������Ŀ¼
		java.net.URL imgURL = ButtonDemo.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	private static void createAndShowGUI() {
		// �������ڲ�����
		JFrame frame = new JFrame("ButtonDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		ButtonDemo newContentPane = new ButtonDemo();
		newContentPane.setOpaque(true); // ��͸��
		frame.setContentPane(newContentPane);
		frame.pack(); // �Զ��������ڴ�С
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// ��ͼ���ڵĽ�����GUI����Ĵ��������ö�Ӧ����GUI�¼��ɷ����������
		// ��ִ�У���ϵͳ��UI���ˢ�¸��кô�����ֱ�ӵ���createAndShowGUI��
		// ��ȫһЩ�������ֱ�ӵ���createAndShowGUI��������ô������Щ������
		// ��main���߳���ִ�еģ�����������д��������EventDispatcher
		// �߳���ִ�еģ���������е�AWT Event�¼���������ִ�С�
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
