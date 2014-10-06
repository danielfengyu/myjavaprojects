package cn.fengyu.buildermodel.abstractfactory;
/**
 * 
 * @author 冯玉
 *实现抽象工厂接口IAnimalFactory得到生产某类产品的工厂类
 */

public class BlackAnimalFactory implements IAnimalFactory{

	public IDog createDog(){
		return new BlackDog();
	}
	public ICat createCat(){
		return new BlackCat();
	}
}
