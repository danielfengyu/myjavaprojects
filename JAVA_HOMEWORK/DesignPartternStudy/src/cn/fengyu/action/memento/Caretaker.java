package cn.fengyu.action.memento;
/*
 * 负责保存好备忘录。不能对备忘录的内*进行操作或检查。
 */
public class Caretaker {
	 private Memento memento;
	    
	    public Memento getMemento(){
	        return this.memento;
	    }
	    
	    public void setMemento(Memento memento){
	        this.memento = memento;
	    }
}
