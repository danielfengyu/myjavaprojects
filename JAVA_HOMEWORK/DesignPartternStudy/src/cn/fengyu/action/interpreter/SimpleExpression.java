package cn.fengyu.action.interpreter;
/*
 * 为文法中的非终结符实现解释(Interpret)操作
 */
public class SimpleExpression extends Expression{

	@Override
	void interpret(Context ctx) {
		// TODO Auto-generated method stub
		 System.out.println("这是普通解析器!");
	}

}
