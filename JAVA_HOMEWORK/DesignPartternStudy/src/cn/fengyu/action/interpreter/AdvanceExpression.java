package cn.fengyu.action.interpreter;
/*
 * 实现与文法中的终结符相关联的解释操作。 一个句子中的每个终结符需要该类的一个实例
 */
public class AdvanceExpression extends Expression{

	@Override
	void interpret(Context ctx) {
		// TODO Auto-generated method stub
		
		        System.out.println("这是高级解析器!");
	}

}
