package cn.fengyu.action.obsever;
/*
 *  ���й�״̬�����ConcreteObserver���� ������״̬�����ı�ʱ,�����ĸ����۲��߷���֪ͨ��
 */
public class TianHeCitizen extends Citizen{
	public TianHeCitizen(Policeman pol) {
        setPolicemen();
        register(pol);
    }
    public void sendMessage(String help) {
        setHelp(help);
        for (int i = 0; i < pols.size(); i++) {
            Policeman pol = pols.get(i);
            //֪ͨ�����ж�
            pol.action(this);
        }
    }
}
