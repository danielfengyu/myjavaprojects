package cn.fengyu.action.obsever;
/*
 *  ά��һ��ָ��ConcreteSubject��������á�
 *  �洢�й�״̬����Щ״̬Ӧ��Ŀ���״̬����һ�¡� 
 *  ʵ��Observer�ĸ��½ӿ�*ʹ����״̬��Ŀ���״̬����һ��
 */
public class TianHePoliceman implements Policeman{
	public void action(Citizen ci) {
        String help = ci.getHelp();
        if (help.equals("normal")) {
            System.out.println("һ������, ���ó���");
        }
        if (help.equals("unnormal")) {
            System.out.println("�з�����Ϊ, ��Ӿ������!");
        }
    }
}
