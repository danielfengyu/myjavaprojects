import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MessageView extends Frame { // Ϊģ�Ͷ��Ƶ���ͼ��ʵ��ģ�������������
	Label label = new Label("Message is: "); // �ṩģ��ҵ�񷽷����õ�����
	TextField tf = new TextField() { // ��ǩ���ı��򣬰�ť
		public Dimension getPreferredSize() { // ʹ�������࣬��չTextField
			return new Dimension(80, 25); // ����getPreferredSize����
		}
	};
	Button b = new Button("submit"); // һ�����ť��ʵ�ֵ���ģ�͹���

	MessageModel mm; // ��ͼҪ����ģ�ͣ����������ϵ

	public MessageView(MessageModel mm) { // ������ͼ����ʱҪ�ṩģ�Ͷ���
		this.mm = mm;
		tf.setText(mm.getMessage());
		setLayout(new FlowLayout());
		add(label);
		add(tf);
		add(b);

		setSize(300, 200);
		Random r1 = new Random();
		setLocation(r1.nextInt(200), r1.nextInt(200)); // ��ͼλ�ã����ֵ��
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	public void refresh() { // ��ͼ������ˢ��
		tf.setText(mm.getMessage());
	}

	public void addController(MessageController mc) {// ��ͼ���¼�����������ȥ����
		b.addActionListener(mc); // ��������ֱ��ע�����ͼ�в����¼������ } //��û�н������ڽӿڵ�ת������
	}
}
