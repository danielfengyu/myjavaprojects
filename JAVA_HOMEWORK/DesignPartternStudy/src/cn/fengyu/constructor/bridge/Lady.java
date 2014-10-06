package cn.fengyu.constructor.bridge;

public class Lady extends Person {
	public Lady(){
		setType("≈Æ»À");
	}
	@Override
	public void dress() {
		// TODO Auto-generated method stub
		Clothing clothing = getClothing();
        clothing.personDressCloth(this);

	}
	
}
