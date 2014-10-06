package cn.fengyu.apdater;

public class Apdater implements Target{
	private Apdatee apdatee;
	public Apdater(Apdatee apdatee){
		this.apdatee=apdatee;
	}
	public void apdateeMethod(){
		apdatee.apdateeMethod();
	}
	
	public void apdaterMethod(){
		System.out.println("这是apdater方法");
	}
}
