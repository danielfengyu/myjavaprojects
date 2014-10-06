package cn.fengyu.apdater;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Target t=new Apdater(new Apdatee());
		t.apdateeMethod();
		t.apdaterMethod();
	}

}
