import java.awt.*;
import java.awt.event.*;

public class ButtonExample {
	public static void main(String[] args) {
		Frame f = new Frame("button example");	//����һ������
		//Ӧ�ý���������Ϊfinal����
//		final Button b1 = new Button("OK");			//�ٴ���3����ť
//		final Button b2 = new Button("Cancel");
//		final Button b3 = new Button("Exit");
		
		Button b1 = new Button("OK");			//�ٴ���3����ť
		Button b2 = new Button("Cancel");
		Button b3 = new Button("Exit");
		ActionListener al = new ActionListener() {	//ActionListener��һ���ӿڣ�
//�����������������
			public void actionPerformed(ActionEvent ae) {
				Button b = (Button)ae.getSource();	//�õ��¼�Դ����
				if(b==b1) {					//�����OK��ť
					System.out.println("nihao");	//����̨���nihao 
				}esle if(b==b2) {				//�����Cancel��ť��ʲôҲ����
					
				} else if(b==b3) {				//�����Exit��ť��������˳�
					System.exit(0);
				}
			}
		};		
		f.add(b1); f.add(b2); f.add(b3);		//��3����ť��ӵ�������
		f.setSize(300,200);					//���ô��ڵĴ�С
		f.setVisible(true);					//�Ѵ�����ʾ����
	}
}
