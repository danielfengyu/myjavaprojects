package cn.fengyu.action.strategy;
/*
 * ����ģʽ������ģʽ���һ���㷨����ÿһ���㷨��װ������
 * ��ͬ�ӿڵĶ��������У��Ӷ�ʹ�����ǿ����໥�滻��
 * ����ģʽʹ���㷨�����ڲ�Ӱ�쵽�ͻ��˵�����·����仯��
 * ����ģʽ����Ϊ�ͻ����ֿ��������ฺ��ά�ֺͲ�ѯ��Ϊ�࣬
 * �����㷨�ھ���Ĳ��������ṩ�������㷨�ͻ�������������
 * �㷨���������޸Ķ�����Ӱ�쵽�����Ϳͻ��ˡ�
 */
public class Test {
	 public static void main(String[] args) {
	        Context ctx = new Context(new StrategyImplA());
	        ctx.doMethod();
	        
	        ctx = new Context(new StrategyImplB());
	        ctx.doMethod();
	        
	        ctx = new Context(new StrategyImplC());
	        ctx.doMethod();
	    }
}
