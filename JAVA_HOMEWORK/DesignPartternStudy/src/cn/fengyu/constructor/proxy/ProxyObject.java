package cn.fengyu.constructor.proxy;
/**
 * ���Ǵ����࣬ʵ����Object�ӿڣ��뱻������ʵ�ֵĽӿ���ͬ
 * Java��̬����ģʽ 
 *	1. ����:һ����ɫ�����һ����ɫ�����ĳЩ�ض��Ĺ��ܡ� 
 * ���磺�����̣��м��̣��ͻ����������Ĺ�ϵ 
 * �ͻ����Ʒ����ֱ���������̴򽻵���Ҳ����֪����Ʒ����β����ģ�
 * �ͻ�ֻ���м��̴򽻵������м��̾Ϳ��ԶԲ�Ʒ����һЩ��װ���ṩһЩ�ۺ�ķ��� 
 * ����ģʽ��������ɫ: 1. ���������ɫ 2. ���������ɫ 3. ʵ�ʱ������ɫ 
 * ������ͨ�����ʴ��������ɫ������ʵ�ʱ������ɫ�� 
 */
public class ProxyObject implements Object{
	Object obj;
	public ProxyObject(){
		System.out.println("���Ǵ�����");
		obj=new ObjectImpl();
	}
	public void action(){
		System.out.println("����ʼ");
		obj.action();
		System.out.println("�������");
	}
}
