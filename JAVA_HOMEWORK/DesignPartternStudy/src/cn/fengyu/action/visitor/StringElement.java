package cn.fengyu.action.visitor;

public class StringElement {
	 private String se;
	    
	    public StringElement(String se) {
	        this.se = se;
	    }
	    
	    public String getSe() {
	        return this.se;
	    }
	    
	    public void accept(Visitor visitor) {
	        visitor.visitString(this);
	    }
}
