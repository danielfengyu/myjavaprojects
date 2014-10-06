package cn.fengyu.singleton;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton single1=Singleton.getInstance();
		Singleton single2=Singleton.getInstance();
		
		System.out.println(single1);
		System.out.println(single2);
	}

}
