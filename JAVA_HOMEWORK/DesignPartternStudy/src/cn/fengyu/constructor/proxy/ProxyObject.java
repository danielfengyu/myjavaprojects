package cn.fengyu.constructor.proxy;
/**
 * 这是代理类，实现了Object接口，与被代理类实现的接口相同
 * Java动态代理模式 
 *	1. 代理:一个角色代表别一个角色来完成某些特定的功能。 
 * 比如：生产商，中间商，客户这三者这间的关系 
 * 客户买产品并不直接与生产商打交道，也不用知道产品是如何产生的，
 * 客户只与中间商打交道，而中间商就可以对产品进行一些包装，提供一些售后的服务。 
 * 代理模式有三个角色: 1. 抽象主题角色 2. 代理主题角色 3. 实际被代理角色 
 * 其它类通过访问代理主题角色来访问实际被代理角色。 
 */
public class ProxyObject implements Object{
	Object obj;
	public ProxyObject(){
		System.out.println("这是代理类");
		obj=new ObjectImpl();
	}
	public void action(){
		System.out.println("代理开始");
		obj.action();
		System.out.println("代理结束");
	}
}
