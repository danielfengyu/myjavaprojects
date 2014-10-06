package cn.fengyu.action.visitor;

import java.util.ArrayList;
import java.util.List;
/*
 * ������ģʽ��������ģʽ��Ŀ���Ƿ�װһЩʩ����ĳ�����ݽṹԪ��
 * ֮�ϵĲ�����һ����Щ������Ҫ�޸ĵĻ�������������������ݽṹ
 * ���Ա��ֲ��䡣������ģʽ���������ݽṹ���δ����ϵͳ��������
 * �ݽṹ�������ڽṹ�ϵĲ���֮�����Ͻ��ѿ���ʹ�ò������Ͽ���
 * ������ɵ��ݻ���������ģʽʹ�������µĲ�����ĺ����ף�������
 * ��һ���µķ������ࡣ������ģʽ���йص���Ϊ���е�һ�������߶�
 * ���У������Ƿ�ɢ��һ�����Ľڵ����С���ʹ�÷�����ģʽʱ��Ҫ��
 * �����ܶ�Ķ�������߼����ڷ��������У������Ƿŵ����������С�
 * ������ģʽ���Կ��������ĵȼ��ṹ�������ڲ�ͬ�ĵȼ��ṹ�ĳ�
 * Ա�ࡣ
 */
public class Test {
	 public static void main(String[] args) {
	        Visitor visitor = new ConcreteVisitor();
	        StringElement se = new StringElement("abc");
	        se.accept(visitor);
	        
	        FloatElement fe = new FloatElement(new Float(1.5));
	        fe.accept(visitor);
	        System.out.println("===========");
	        List result = new ArrayList();
	        result.add(new StringElement("abc"));
	        result.add(new StringElement("abc"));
	        result.add(new StringElement("abc"));
	        result.add(new FloatElement(new Float(1.5)));
	        result.add(new FloatElement(new Float(1.5)));
	        result.add(new FloatElement(new Float(1.5)));
	        visitor.visitCollection(result);
	    }
}
