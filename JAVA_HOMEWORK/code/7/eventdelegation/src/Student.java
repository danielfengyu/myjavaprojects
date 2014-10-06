//��һ������Student.java����Ϊ�¼�Դ
import java.util.*;

public class Student {
	private int age;

	// ���ڼ��ϣ�������������ڶ���Ĺ�����ϵ��
	List<AgeChangedListener> listeners = new LinkedList<AgeChangedListener>();

	// ����ע�᷽����������ĳ�����ڶ����ظ�ע��
	public void addAgeChangedListener(AgeChangedListener acl) {
		if (!listeners.contains(acl)) {
			listeners.add(acl);
		}
	}

	// �����޸ķ����У��������ݷ����仯��������һ���¼�
	public void setAge(int age) {
		// ����¼���װ���¼�Դ���¼�����ʱ���¾���������
		AgeChangedEvent ace = new AgeChangedEvent(this, this.age, age);
		this.age = age;
		process(ace); // ���ô�������¼��ķ���
	}

	// �ڲ��࣬ʹ�ö��̻߳�����������ڶ���Ĺ㲥������һ��ĳ�����ڵ�
	// �¼��������ִ�л�����Ӱ���������ڶ�����¼���������ִ�С�
	class DispatchThread extends Thread {
		private AgeChangedListener acl; // ����һ�����ڶ���
		private AgeChangedEvent ace; // ��������¼�

		public DispatchThread(AgeChangedListener acl, AgeChangedEvent ace) {
			this.acl = acl;
			this.ace = ace;
		}

		public void run() { // �߳���������¼�ί�й���
			acl.processAgeChanged(ace); // ִ�����ڶ�����¼��������
		}
	}

	public void process(AgeChangedEvent ace) {
		// source internal processing
		// �¼�Դ�ڲ����¼�������̣����û�У�����Ҫ�ṩʲô����
		// internal processing end.

		// ��ʼ���ڵ��¼��㲥����
		for (int i = 0; i < listeners.size(); i++) { // �������ڼ��ϣ�ʹ�ö��߳̽��й㲥
			new DispatchThread(listeners.get(i), ace).start();
		}
	}
}
