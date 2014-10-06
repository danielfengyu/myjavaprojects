package cn.fengyu.constructor.bridge;

public class Man extends Person{

	public Man(){
		setType("ÄÐÈË");
	}
	@Override
	public void dress() {
		// TODO Auto-generated method stub
		 Clothing clothing = getClothing();
	     clothing.personDressCloth(this);

	}

}
