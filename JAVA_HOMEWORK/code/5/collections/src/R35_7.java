import java.util.*;

public class R35_7 {
	public void a() {
		List list = new LinkedList();
		for (int i = 1; i <= 35; i++) {
			list.add(new Integer(i));
		}
		List select = new LinkedList();
		for (int i = 0; i < 7; i++) {
			Collections.shuffle(list); // Collections������Ϲ������ṩ���򷽷�
			select.add(list.remove(0));
		}
		Collections.sort(select); // Collections������Ϲ������ṩ���򷽷�
		for (int i = 0; i < 7; i++) {
			if (i < 6) {
				System.out.print(select.get(i) + ", "); // ������ݣ�����ӻس�����
			} else {
				System.out.println(select.get(i)); // ������ݲ���ӻس�����
			}
		}
	}

	public void b() {				// TreeSet�ṩ����ı���
		Set set = new TreeSet(); 	// ���ܻ���HashSet����Ϊ�䲻���ṩ�������
		while (set.size() < 7) { 	// ����7�����ظ���1~35֮����������
			set.add(new Integer((int) (Math.random() * 35 + 1)));
		}
		System.out.println(set); // toString��������Ԫ��˳�����һ���ĸ�ʽ���
	}

	public static void main(String[] args) {
		R35_7 r = new R35_7();
		r.a();
		r.b();
	}
}
