//�������¼��࣬AgeChangedEvent.java������������仯����¼�
//�����¼������¼�Դ�������������������java.util.EventObject����¼����
//�����У�Ҫ�������¼��඼Ҫ�Ӹ���̳С�

public class AgeChangedEvent extends java.util.EventObject {
	private int oAge, nAge; // �¼���Ӧ�ö����¼�����ʱ��һЩ�仯���ݵȵ�

	public AgeChangedEvent(Object source, int oAge, int nAge) {
		super(source); // ���ø���Ĺ��췽��������ͨ������getSource()����
		this.oAge = oAge; // ������¼�Դ
		this.nAge = nAge;
	}

	public int getOldAge() {
		return oAge;
	}

	public int getNewAge() {
		return nAge;
	}
}
