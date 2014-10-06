package cn.fengyu.builder;
/**
 * 
 * @author ����
 * ��������˵�����Ĺ���ֻ�������Ͷ�������������˼������ʱҪ��һ���ܿ��ö�ģ�͵�����ָ�ӹ���������������
 * ���˾���ָ���ߣ������������ˣ��������԰���ͼָֽ�ӽ��������ˡ�
 *
 */
public class PersonDirector {
	public Person constructPerson(PersonBuilder bp){
		bp.buidBody();
		bp.buidHand();
		bp.buildHead();
		bp.buildFoot();
		return bp.buildPerson();
	}
}
