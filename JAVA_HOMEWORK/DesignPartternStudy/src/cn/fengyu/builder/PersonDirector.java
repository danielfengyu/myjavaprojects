package cn.fengyu.builder;
/**
 * 
 * @author 冯玉
 * 按道理来说工厂的工人只会用手劳动，但不会用脑思考，此时要有一个能看得懂模型的人来指挥工厂的人们制造人
 * 该人就是指挥者，它本身不会造人，但它可以按照图纸指挥建造者造人。
 *
 */
public class PersonDirector {
	public Person constructPerson(PersonBuilder bp){
		bp.buidBody();
		bp.buidHand();
		bp.buildHead();
		bp.buildFoot();
		return bp.buildPerson();
	}
}
