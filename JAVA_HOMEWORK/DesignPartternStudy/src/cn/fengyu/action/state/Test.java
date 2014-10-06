package cn.fengyu.action.state;
/*
 * 状态模式：状态模式允许一个对象在其内部状态改变的时候改变行为。
 * 这个对象看上去象是改变了它的类一样。状态模式把所研究的对象的行为
 * 包装在不同的状态对象里，每一个状态对象都属于一个抽象状态类的一
 * 个子类。状态模式的意图是让一个对象在其内部状态改变的时候，
 * 其行为也随之改变。状态模式需要对每一个系统可能取得的状态创立一个
 * 状态类的子类。当系统的状态变化时，系统便改变所选的子类。 
 */
public class Test {
	public static void main(String[] args) {
        Context ctx1 = new Context();
        ctx1.setWeather(new Sunshine());
        System.out.println(ctx1.weatherMessage());

        System.out.println("===============");

        Context ctx2 = new Context();
        ctx2.setWeather(new Rain());
        System.out.println(ctx2.weatherMessage());
    }
}
