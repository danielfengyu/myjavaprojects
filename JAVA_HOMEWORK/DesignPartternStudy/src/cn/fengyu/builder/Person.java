package cn.fengyu.builder;
/**
 * 
 * @author 冯玉
 * 人具备什么只有人自己知道。所以得定义一个人，这个人是工厂造人时的参考图纸
 *
 */
public class Person {

	private String head;
	private String body;
	private String foot;
	private String hand;
	
	public  String getHead(){
		return head;
	}
	public void setHead(String head){
		this.head=head;
	}
	
	public String getBody(){
		return body;
	}
	public void setBody(String body){
		this.body=body;
	}
	
	public String getFoot(){
		return foot;
	}
	public void setFoot(String foot){
		
		this.foot=foot;
	}
	public String getHand(){
		return hand;
	}
	public void setHand(String hand){
		this.hand=hand;
	}

}
