import java.awt.*;
import java.awt.event.*;
public class GUI  {
	public static void main(String[] args) 
	{
		//����һ�����ڣ����ڱ���Ϊgui outlook under different platform
		Frame f = new Frame("gui outlook under different platform");
		//����������ť����
		Button ok = new Button(" OK ");
		Button exit = new Button(" Exit ");
		//��������
		ok.setFont(new Font("SansSerif",Font.PLAIN,16));
		exit.setFont(new Font("SansSerif",Font.PLAIN,16));
		//����һ���б�����
		List list = new List();
		//���3��������
		list.add("Zhang San");
		list.add("Li Si");
		list.add("Wang Wu");
		//Ϊexit��ťע��һ�����ڶ���ʹ����������
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {	//�¼�������
				System.exit(0); }});
		//���ô���f�Ĳ���Ϊ�����ֹ�����
		f.setLayout(new FlowLayout());
		//�򴰿�����Ӱ�ť���б��
		f.add(ok);  f.add(exit); f.add(list);
		//���ô��ڴ�С����ʾ����
		f.setSize(200,150);
		f.setVisible(true);
	}
}
