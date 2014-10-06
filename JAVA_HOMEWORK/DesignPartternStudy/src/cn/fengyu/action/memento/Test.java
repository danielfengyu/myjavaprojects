package cn.fengyu.action.memento;
/*
 * 备忘录模式：备忘录对象是一个用来存储另外一个对象内部状态的快照的对象。
 * 备忘录模式的用意是在不破坏封装的条件下，将一个对象的状态捉住，
 * 并外部化，存储起来，从而可以在将来合适的时候把这个对象还原到存储起
 * 来的状态。 
 */
public class Test {
	public static void main(String[] args) {
        Originator org = new Originator();
        org.setState("开会中");
        
        Caretaker ctk = new Caretaker();
        //源发器创建一个备忘录，保存原发器的当前状态，ctk对象持有该备忘录
        ctk.setMemento(org.createMemento());//将数据封装在Caretaker
        
        org.setState("睡觉中");
        org.showState();//显示
        //原发器用备忘录打开存储的状态。
        org.setMemento(ctk.getMemento());//将数据重新导入
        org.showState();
    }
}
