package cn.fengyu.builder;
/**
 * 
 * @author 冯玉
 * 定义一个建造者的接口，该接口可以扩展出多个不同实际建造者
 *
 */
public interface PersonBuilder {
	void buildHead();
	void buildFoot();
	void buidBody();
	void buidHand();
	Person buildPerson();
}
