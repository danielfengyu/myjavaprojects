package cn.fengyu.action.mediator;
/*
 * 用一个中介对象来封装一系列的对象交互。中介者使各对象不
 * 需要显式地相互引用，从而使其耦合松散，而且可以独立地改
 * 变它们之间的交互。
 * 
 * 调停者模式：调停者模式包装了一系列对象相互作用的方式，
 * 使得这些对象不必相互明显作用。从而使他们可以松散偶合。
 * 当某些对象之间的作用发生改变时，不会立即影响其他的一些
 * 对象之间的作用。保证这些作用可以彼此独立的变化。
 * 调停者模式将多对多的相互作用转化为一对多的相互作用。
 * 调停者模式将对象的行为和协作抽象化，把对象在小尺度的行
 * 为上与其他对象的相互作用分开处理。 
 */
public class Test {
	 public static void main(String[] args) {
	        Mediator med = new ConcreteMediator();
	        //老板来了
	        med.notice("boss");
	        
	        //客户来了
	        med.notice("client");
	    }
}
