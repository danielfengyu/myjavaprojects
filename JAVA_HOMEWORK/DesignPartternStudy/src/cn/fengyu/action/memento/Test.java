package cn.fengyu.action.memento;
/*
 * ����¼ģʽ������¼������һ�������洢����һ�������ڲ�״̬�Ŀ��յĶ���
 * ����¼ģʽ���������ڲ��ƻ���װ�������£���һ�������״̬׽ס��
 * ���ⲿ�����洢�������Ӷ������ڽ������ʵ�ʱ����������ԭ���洢��
 * ����״̬�� 
 */
public class Test {
	public static void main(String[] args) {
        Originator org = new Originator();
        org.setState("������");
        
        Caretaker ctk = new Caretaker();
        //Դ��������һ������¼������ԭ�����ĵ�ǰ״̬��ctk������иñ���¼
        ctk.setMemento(org.createMemento());//�����ݷ�װ��Caretaker
        
        org.setState("˯����");
        org.showState();//��ʾ
        //ԭ�����ñ���¼�򿪴洢��״̬��
        org.setMemento(ctk.getMemento());//���������µ���
        org.showState();
    }
}
