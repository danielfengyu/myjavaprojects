import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;

public class MDI extends JFrame // ����������Ȼ��JFrame
{ // ����һ��MDI�����ڳ�Ա
	JDesktopPane desktop;

	public MDI() {
		super("MDI Demo");
		try { // ������ۣ������Motif���
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			// ���������֮���޸�����ۣ���ô����Ҫ������������������ˢ�����
			// SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			System.out.println("Unsupported L&F");
		}
		// ����������
		desktop = new JDesktopPane();
		// ���������Ӵ��ڣ�ͬʱ���ô��ڱ��⡣
		JInternalFrame bottom = new MyInternalFrame("the bottom frame");
		JInternalFrame jif1 = new MyInternalFrame("the inter 1 frame");
		JInternalFrame jif2 = new MyInternalFrame("the inter 2 frame");
		JInternalFrame jif3 = new MyInternalFrame("the inter 3 frame");
		JInternalFrame up = new MyInternalFrame("the up frame");

		// JDesktopPane�̳���JLayeredPane��֧�ֲַ�
		desktop.add(bottom, JLayeredPane.DEFAULT_LAYER);
		desktop.add(jif1, new Integer(5));
		desktop.add(jif2, new Integer(6));
		desktop.add(jif3, new Integer(6));

		// �ϲ㴰�ڣ����������ڸǲ����������
		desktop.add(up, JLayeredPane.MODAL_LAYER);

		Container c = getContentPane();
		c.add(desktop); // ��JDesktopPane��ӵ�JFrame��

		int inset = 100;
		// ȡ����Ļ�ߴ��С
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// ����JFrame��С��λ�ã�ʹ֮������Ļ����
		setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height
				- inset * 2);
		// ��Ӳ˵���
		setJMenuBar(createMenuBar());
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	protected JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Document"); // ��Ӳ˵�
		menu.setMnemonic(KeyEvent.VK_D); // ���ÿ�ݼ�Alt+D
		JMenuItem menuItem = new JMenuItem("New");
		menuItem.setMnemonic(KeyEvent.VK_N);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// �����Ӵ���
				JInternalFrame jif = new MyInternalFrame(
						"dynamic internal frame");
				desktop.add(jif, 0);
			}
		});
		menu.add(menuItem);
		menuBar.add(menu);
		return menuBar;
	}

	public static void main(String[] args) {
		new MDI();
	}
}
