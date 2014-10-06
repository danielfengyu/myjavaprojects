package cn.fengyu.action.templatemethod;
/*
 * 模板方法模式：模板方法模式准备一个抽象类，将部分逻辑以具体方法
 * 以及具体构造子的形式实现，然后声明一些抽象方法来迫使子类实现剩
 * 余的逻辑。不同的子类可以以不同的方式实现这些抽象方法，
 * 从而对剩余的逻辑有不同的实现。先制定一个顶级逻辑框架，
 * 而将逻辑的细节留给具体的子类去实现。 
 */
public class Test {
	 public static void main(String[] args) {
	        Template temp = new TemplateConcrete();
	        temp.update();
	    }
}
