package cn.fengyu.action.strategy;
/*
 *  ��һ��ConcreteStrateg*���������á�ά��һ��
 *  ��Strategy��������á��ɶ���һ���ӿ�����Stategy
 *  �����������ݡ�
 *  
 *  ���þ�������࣬
 */
public class Context {
	 Strategy stra;
	    
	    public Context(Strategy stra) {
	        this.stra = stra;
	    }
	    
	    public void doMethod() {
	        stra.method();
	    }
}
