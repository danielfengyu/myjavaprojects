package cn.fengyu.constructor.proxy;
/*
 * 这是被代理的类，在客户端不直接调用，有代理类在客服端调用，客户端不可见。
 */
public class ObjectImpl implements Object{
	public void action(){
		System.out.println("=======");
		System.out.println("=======");
		System.out.println("这是被代理类");
		System.out.println("=======");
		System.out.println("=======");
	}
}
