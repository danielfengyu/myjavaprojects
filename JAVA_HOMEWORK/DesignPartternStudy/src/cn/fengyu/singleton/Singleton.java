package cn.fengyu.singleton;

/**
 * ���еľ�̬��Ա������������ֱ�����������ʡ�
 * getInstance()�����ǻ�õ�������ķ�����
 * һ��һ���������ڴ��д�������ֱ���������������
 */
public class Singleton {

	private static Singleton single;
	private Singleton () {
		super();
	}
	public  static Singleton getInstance() {
		if(single==null){
			single=new Singleton();
		}
		return single;
	}

}
