import java.awt.*; //Swing�����һЩjava.awt���е��������
import java.awt.event.*; //�������һЩAWT�¼����е�һЩ��
import javax.swing.*; //Swing��
import java.util.*;

public class ShareModel extends JFrame { // ShareModel.java�������������һ��ģ��
	MyModel model = new MyModel(); // ����һ��ģ�ͣ�����������
	JSlider s1 = new JSlider(); // ��������ؼ�����
	JScrollBar s2 = new JScrollBar(JScrollBar.HORIZONTAL); // �����������ؼ�
	JButton btn = new JButton("random range!"); // ����һ����ť����

	public ShareModel() {
		super("JSlider and JScrollBar share model");
		Container c = getContentPane(); // �õ����ݴ��񣬲���ֱ����JFrame����ӣ�
		c.setLayout(null); // Ӧ�üӵ�JFrame��ĳ��������
		s1.setModel(model); // ����ģ��
		s2.setModel(model);
		s1.setBounds(100, 30, 120, 25); // setBounds(int x, int y, int width,
										// int height)
		s2.setBounds(100, 100, 120, 25);
		btn.setBounds(100, 180, 120, 25);

		btn.addActionListener(new ActionListener() { // ʹ����������
			public void actionPerformed(ActionEvent ae) {
				new Thread() { // �ٴ�ʹ��������
					public void run() {
						Random r = new Random();
						for (int i = 0; i < 10; i++) {
							try {
								Thread.sleep(300);
							} catch (Exception e) {
							} // �����ť��
							model.setValue(r.nextInt(100)); // ����޸�ģ�͵�����
						}
					}
				}.start();
			}
		});

		c.add(s1); // �����ݴ�����������
		c.add(s2);
		c.add(btn);

		setSize(350, 300);
		setVisible(true);
		/* ���JFrame�Ĺرհ�ť��ִ�е���Ϊ���ر����˳� */
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ShareModel();
	}
}
