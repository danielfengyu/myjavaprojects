package cn.fengyu.action.strategy;
/*
 * 策略模式：策略模式针对一组算法，将每一个算法封装到具有
 * 共同接口的独立的类中，从而使得它们可以相互替换。
 * 策略模式使得算法可以在不影响到客户端的情况下发生变化。
 * 策略模式把行为和环境分开。环境类负责维持和查询行为类，
 * 各种算法在具体的策略类中提供。由于算法和环境独立开来，
 * 算法的增减，修改都不会影响到环境和客户端。
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
