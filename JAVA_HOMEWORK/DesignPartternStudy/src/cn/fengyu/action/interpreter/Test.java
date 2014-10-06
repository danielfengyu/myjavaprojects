package cn.fengyu.action.interpreter;
/*
 * ������ģʽ������һ�����Ժ󣬽�����ģʽ���Զ�������ķ���һ�ֱ�ʾ��
 * ��ͬʱ�ṩһ�����������ͻ��˿���ʹ�������������������������еľ��ӡ�
 * ������ģʽ����������������һ���򵥵��ķ���ʹ��ģʽ��ƽ�����Щ��䡣
 * �ڽ�����ģʽ�����ᵽ��������ָ�κν����������ܹ����͵��κ���ϡ�
 * �ڽ�����ģʽ����Ҫ����һ�������ķ���������ĵȼ��ṹ��Ҳ����һϵ�е���Ϲ���
 * ÿһ�����������һ�����ͷ�����������������Ľ��͡�
 * �������ĵȼ��ṹ�еĶ�����κ�������϶���һ�����ԡ� 
 */
public class Test {
	 public static void main(String[] args) {
	        Context ctx = new Context();
	        ctx.add(new SimpleExpression());
	        ctx.add(new AdvanceExpression());
	        ctx.add(new SimpleExpression());
	        
	        for (Expression eps : ctx.getList()) {
	            eps.interpret(ctx);
	        }
	    }

}
