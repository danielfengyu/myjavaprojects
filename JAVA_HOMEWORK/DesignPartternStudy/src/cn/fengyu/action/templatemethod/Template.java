package cn.fengyu.action.templatemethod;
/*
 * ��������ԭ�������primitiveoperation������������ཫ
 * �ض���������ʵ��һ���㷨�ĸ����衣
 * ʵ��һ��ģ�巽��,����һ���㷨�ĹǼܡ�   ��ģ�巽����������ԭ��
 * ������Ҳ���ö�����AbstractClass�����������еĲ�����
 */
public abstract class Template {
	 public abstract void print();
	    
	    public void update() {
	        System.out.println("��ʼ��ӡ");
	        for (int i = 0; i < 10; i++) {
	            print();
	        }
	    }
}
