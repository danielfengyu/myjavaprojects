//�����ǵڶ��������࣬Classmate.java

public class Classmate implements AgeChangedListener {
	public void processAgeChanged(AgeChangedEvent ace) {
		// who? have a birthday party?
		// ���ô�EventObject��̳�������getSource()��������¼�Դ
		Student s = (Student) ace.getSource();
		System.out.println("let's have a birthday party.");
	}
}
