package cn.fengyu.action.memento;
/*
 * 备忘录存储原发器对象的内部状态。
 */
public class Memento {
	private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
