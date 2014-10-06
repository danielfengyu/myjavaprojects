package cn.fengyu.action.strategy;
/*
 *   定义所有支持的算法的公共接口。Context使用这个接口来调用某
 *   ConcreteStrategy定义的算法。
 *  
 *   
 *   策略类接口
 */
public abstract class Strategy {
	public abstract void method();
}
