package cn.fengyu.builder;
/**
 * 
 * @author ����
 * ����һ�������ߵĽӿڣ��ýӿڿ�����չ�������ͬʵ�ʽ�����
 *
 */
public interface PersonBuilder {
	void buildHead();
	void buildFoot();
	void buidBody();
	void buidHand();
	Person buildPerson();
}
