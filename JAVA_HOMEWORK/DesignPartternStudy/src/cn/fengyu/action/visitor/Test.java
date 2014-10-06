package cn.fengyu.action.visitor;

import java.util.ArrayList;
import java.util.List;
/*
 * 访问者模式：访问者模式的目的是封装一些施加于某种数据结构元素
 * 之上的操作。一旦这些操作需要修改的话，接受这个操作的数据结构
 * 可以保持不变。访问者模式适用于数据结构相对未定的系统，它把数
 * 据结构和作用于结构上的操作之间的耦合解脱开，使得操作集合可以
 * 相对自由的演化。访问者模式使得增加新的操作变的很容易，就是增
 * 加一个新的访问者类。访问者模式将有关的行为集中到一个访问者对
 * 象中，而不是分散到一个个的节点类中。当使用访问者模式时，要将
 * 尽可能多的对象浏览逻辑放在访问者类中，而不是放到它的子类中。
 * 访问者模式可以跨过几个类的等级结构访问属于不同的等级结构的成
 * 员类。
 */
public class Test {
	 public static void main(String[] args) {
	        Visitor visitor = new ConcreteVisitor();
	        StringElement se = new StringElement("abc");
	        se.accept(visitor);
	        
	        FloatElement fe = new FloatElement(new Float(1.5));
	        fe.accept(visitor);
	        System.out.println("===========");
	        List result = new ArrayList();
	        result.add(new StringElement("abc"));
	        result.add(new StringElement("abc"));
	        result.add(new StringElement("abc"));
	        result.add(new FloatElement(new Float(1.5)));
	        result.add(new FloatElement(new Float(1.5)));
	        result.add(new FloatElement(new Float(1.5)));
	        visitor.visitCollection(result);
	    }
}
