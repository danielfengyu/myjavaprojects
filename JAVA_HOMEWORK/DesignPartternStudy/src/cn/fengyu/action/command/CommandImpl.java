package cn.fengyu.action.command;
/*
 *  ��һ�������߶������һ��������  ���ý�������Ӧ�Ĳ�������ʵ��Execute��
 *  ��������������ִ����������ӿ�ʵ�ֶ����ǡ��顱��ʵ�֣�
 *  ͨ������н����ߣ������ý����ߵĹ������������Ҫִ�еĲ�����
 */
public class CommandImpl extends Command{
	 public CommandImpl(Receiver receiver) {
	        super(receiver);
	    }
	    
	    public void execute() {
	        receiver.receive();
	    }
}
