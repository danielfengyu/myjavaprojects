package cn.fengyu.action.visitor;

public interface Visitable {
	public void accept(Visitor visitor);
}
