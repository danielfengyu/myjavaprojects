//������Զ�̽ӿڵ�ʵ���࣬ͨ���̳и���RMI��ܵĶ��̼߳��������ӹ���ȹ���

public class CalcImpl extends java.rmi.server.UnicastRemoteObject implements Calc {
	
	public CalcImpl() throws Exception {
		super();  //UnicastRemoteObject���췽�����׳��쳣
	}

	public int add(int i, int j) {
		return i + j;
	}

	public int sub(int i, int j) {
		return i - j;
	}
}
