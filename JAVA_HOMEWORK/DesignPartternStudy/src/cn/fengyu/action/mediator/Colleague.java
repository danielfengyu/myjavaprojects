package cn.fengyu.action.mediator;
/*
 *  每一个同事类都知道它的中介者对象。 每一个同事对象在需与其他的同事通信的时候*与它的中介者通信
 */
public abstract class Colleague {
	public abstract void action();
}
