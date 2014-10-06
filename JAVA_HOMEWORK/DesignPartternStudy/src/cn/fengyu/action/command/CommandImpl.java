package cn.fengyu.action.command;
/*
 *  将一个接收者对象绑定于一个动作。  调用接收者相应的操作，以实现Execute，
 *  负责调用命令对象执行请求。命令接口实现对象，是“虚”的实现；
 *  通常会持有接收者，并调用接收者的功能来完成命令要执行的操作。
 */
public class CommandImpl extends Command{
	 public CommandImpl(Receiver receiver) {
	        super(receiver);
	    }
	    
	    public void execute() {
	        receiver.receive();
	    }
}
