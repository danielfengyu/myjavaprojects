package cn.fengyu.buildermodel.abstractfactory;
/**
 * 
 * @author 冯玉
 * 定义”生产“白色动物的工厂类
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
