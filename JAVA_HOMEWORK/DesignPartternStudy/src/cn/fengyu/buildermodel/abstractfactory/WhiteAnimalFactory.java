package cn.fengyu.buildermodel.abstractfactory;
/**
 * 
 * @author ����
 * ���塱��������ɫ����Ĺ�����
 *
 */
public class WhiteAnimalFactory implements  IAnimalFactory{

	public IDog createDog(){
		return new  WhiteDog();
	}
	
	public ICat createCat(){
		return new WhiteCat();
	}
}
