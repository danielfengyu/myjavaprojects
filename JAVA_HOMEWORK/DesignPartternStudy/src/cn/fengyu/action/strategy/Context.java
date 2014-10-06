package cn.fengyu.action.strategy;
/*
 *  用一个ConcreteStrateg*对象来配置。维护一个
 *  对Strategy对象的引用。可定义一个接口来让Stategy
 *  访问它的数据。
 *  
 *  调用具体策略类，
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
