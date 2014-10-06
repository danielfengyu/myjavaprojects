package cn.fengyu.action.command;
/*
 *  要求该命令执行这个请求。要求命令对象执行请求，通常会持有命令对象，
 *  可以持有很多的命令对象。这个是客户端真正触发命令并要求命令执行相应操作的地方，
 *  也就是说相当于使用命令对象的入口
 */
public class Invoker {
	 private Command command;
	    
	    public void setCommand(Command command) {
	        this.command = command;
	    }
	    
	    public void execute() {
	        command.execute();
	    }
}
