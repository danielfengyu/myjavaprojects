package cn.fengyu.buildermodel.abstractfactory;

public class AbstractFactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IAnimalFactory af1=new BlackAnimalFactory();
		IAnimalFactory af2=new WhiteAnimalFactory();
		IDog dog1=af1.createDog();
		IDog dog2=af2.createDog();
		ICat cat1=af1.createCat();
		ICat cat2=af2.createCat();
		dog1.eat();
		dog2.eat();
		cat1.eat();
		cat2.eat();

	}

}
