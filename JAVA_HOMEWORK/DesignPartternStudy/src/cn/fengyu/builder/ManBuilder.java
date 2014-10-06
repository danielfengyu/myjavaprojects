package cn.fengyu.builder;
/**
 * 
 * @author 冯玉
 * 具体的建造者，实现了建造者接口。建造建造的是一个人，当然得给它一个人的模型，它才能按照该模型建造人
 * 有模型了，还得开始造人，否则人也是出不来的
 *
 */
public class ManBuilder implements PersonBuilder{
	Person person;//模型
	/**
	 * 早人的机器，开始造人，指明造一个什么样的人，本例造的是一个“男人”
	 */
	public ManBuilder(){
		this.person=new Man();
	}
	public void buildHead(){
		person.setHead("man的头");
	}
	public void buidHand(){
		person.setHand("man的手");
	}
	public void buidBody(){
		person.setBody("man的身体");
	}
	
	public void buildFoot(){
		person.setFoot("man 的脚");
	}
	//人造好后，还得向外发布，不然别人也不知道你会造人。
	public Person buildPerson() {
        return person;
    }

}
