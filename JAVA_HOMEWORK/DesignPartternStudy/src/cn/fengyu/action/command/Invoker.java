package cn.fengyu.action.command;
/*
 *  Ҫ�������ִ���������Ҫ���������ִ������ͨ��������������
 *  ���Գ��кܶ�������������ǿͻ��������������Ҫ������ִ����Ӧ�����ĵط���
 *  Ҳ����˵�൱��ʹ�������������
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
