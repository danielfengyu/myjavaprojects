import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calc extends Remote { // �ͱ��ط�����ͬ��Զ�̷����׳�Զ���쳣
	
	public int add(int i, int j) throws RemoteException;

	public int sub(int i, int j) throws RemoteException;
}
