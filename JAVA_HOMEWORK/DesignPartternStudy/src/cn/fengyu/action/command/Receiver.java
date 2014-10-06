package cn.fengyu.action.command;
/*
 *  知道如何实施与执行一个请求相关的操作。任何类都可能作为一个接收者。
 *  接收者，真正执行命令的对象。任何类都可能成为一个接收者，
 *  只要它能够实现命令要求实现的相应功能
 */
public class Receiver {
	 public void receive() {
	        System.out.println("This is Receive class!");
	    }
}
