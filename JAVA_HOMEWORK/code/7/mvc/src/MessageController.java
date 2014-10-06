import java.awt.*;
import java.awt.event.*;

public class MessageController implements ActionListener { // ��������
	MessageModel mm; // ������Ҫ����ģ�ͺ���ͼ
	MessageView mv; // ������Ҫ������ģ�ͺ���ͼ�Ĺ�����ϵ

	public MessageController(MessageModel mm, MessageView mv) {
		this.mm = mm;
		this.mv = mv;
		mv.addController(this); // ��������ע�ᵽ��ͼ���䵱��ͼ���¼�����
	}

	public void actionPerformed(ActionEvent e) { // �¼��������
		mm.setMessage(mv.tf.getText()); // ���û��¼�ӳ�䵽ģ��ҵ�񷽷���ִ��
	}
}