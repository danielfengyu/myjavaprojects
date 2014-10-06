import java.util.*;

public class MessageModel { // һ���򵥵�ģ�ͣ���װ��һ���ַ�����Ϣ
	private String message;

	public String getMessage() { // ��ͼ���󽫻����ģ�Ͷ����ҵ�����ݵĶ�����
		return message;
	}

	public void setMessage(String message) { // �����ݷ����仯ʱ��Ҫ֪ͨ��ͼ����
		this.message = message; // ������ͼ��������ͼ���²���
		for (Iterator<MessageView> it = views.iterator(); it.hasNext();) {
			it.next().refresh();
		}
	}

	List<MessageView> views = new LinkedList<MessageView>();

	public void addView(MessageView mv) { // Ϊģ��ע����ͼ
		views.add(mv);
	}
}
