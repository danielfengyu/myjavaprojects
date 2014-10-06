package cn.fengyu.buildermodel.abstractfactory;
/**
 * 
 * @author ����
 *ʵ�ֳ��󹤳��ӿ�IAnimalFactory�õ�����ĳ���Ʒ�Ĺ�����
 */

public class BlackAnimalFactory implements IAnimalFactory{

	public IDog createDog(){
		return new BlackDog();
	}
	public ICat createCat(){
		return new BlackCat();
	}
}
