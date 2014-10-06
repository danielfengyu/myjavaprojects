package cn.fengyu.action.memento;
/*
 * 原发器创建一个备忘录,用以记录当前时刻*的内部状态。
 * 使用备忘录恢复内部状态.
 */
public class Originator {
	 private String state;

	    public String getState() {
	        return state;
	    }

	    public void setState(String state) {
	        this.state = state;
	    }
	    
	    public Memento createMemento() {
	        return new Memento(state);
	    }
	    
	    public void setMemento(Memento memento) {
	        state = memento.getState();
	    }
	    
	    public void showState(){
	        System.out.println(state);
	    }
}
