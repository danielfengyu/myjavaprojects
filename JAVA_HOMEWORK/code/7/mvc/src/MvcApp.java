
//Ӧ����
public class MvcApp {
	public static void main(String[] args) {
		MessageModel mm = new MessageModel();		//������һ��ģ��
		MessageView mv1 = new MessageView(mm);	//������������ͼ
		MessageView mv2 = new MessageView(mm);
		MessageController mc1 = new MessageController(mm,mv1);//��������������
		MessageController mc2 = new MessageController(mm,mv2);
		mm.addView(mv1);	mm.addView(mv2);	//Ϊģ��ָ����ͼ
	}	//�����޸ĳ�����������ͼ����һ����������
}
