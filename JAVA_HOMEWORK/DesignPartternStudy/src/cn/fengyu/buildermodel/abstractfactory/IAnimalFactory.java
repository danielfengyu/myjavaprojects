package cn.fengyu.buildermodel.abstractfactory;
/**
 * 
 * @author 冯玉
 *定义“生产”动物的抽象工厂
 */
public interface IAnimalFactory {
	ICat createCat();
	IDog createDog();
}
