package cn.fengyu.action.interpreter;
/*
 *   ����һ������Ľ��Ͳ���������ӿ�Ϊ�����﷨�������еĽڵ�������
 */
public abstract class Expression {
	abstract void interpret(Context ctx);
}
