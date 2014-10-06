package cn.fengyu.prototype;

public class Prototype implements Cloneable{

	String name;
	public void setName(String name){
		this. name=name;
	}
	public String getName(){
		return name;
	}
	public Object clone(){
		   try {
	            return super.clone();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	}
}
