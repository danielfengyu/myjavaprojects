package cn.fengyu.action.memento;
/*
 * ���𱣴�ñ���¼�����ܶԱ���¼����*���в������顣
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
