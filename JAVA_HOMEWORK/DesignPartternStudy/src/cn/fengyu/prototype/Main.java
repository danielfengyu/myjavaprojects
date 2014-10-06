package cn.fengyu.prototype;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prototype pro = new PrototypeConcrete("prototype");
        Prototype pro2 = (Prototype)pro.clone();
        System.out.println(pro.getName());
        System.out.println(pro2.getName());

	}

}
