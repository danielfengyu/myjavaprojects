package cn.fengyu.action.command;
/*
 * ����ģʽ��������������κ�ִ����������ηֿ�������ģʽ��һ������
 * ���߲�����װ��һ�������С�����ģʽ�ѷ�����������κ�ִ����������ηָ��
 * ί�ɸ���ͬ�Ķ�������ģʽ���������һ���ͷ��͵�һ������������
 * ʹ�������һ������֪�����������һ���Ľӿڣ�������֪����������ô�����գ�
 * �Լ������Ƿ�ִ�У���ʱ��ִ���Լ�����ô��ִ�еġ�ϵͳ֧������ĳ�����
 */
public abstract class Command {
protected Receiver receiver;
    
    public Command(Receiver receiver) {
        this.receiver = receiver;
    }
    
    public abstract void execute();

}
