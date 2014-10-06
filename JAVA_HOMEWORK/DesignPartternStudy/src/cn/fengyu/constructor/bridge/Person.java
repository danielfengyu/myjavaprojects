package cn.fengyu.constructor.bridge;

public abstract class Person {
	 private Clothing clothing;
	    
	    private String type;

	    public Clothing getClothing() {
	        return clothing;
	    }
//
//	    public void setClothing(Clothing clothing) {
//	        this.clothing = clothing.getClothing("");//”–Œ Ã‚£°
//	    }
	    
	    public void setType(String type) {
	        this.type = type;
	    }
	    
	    public String getType() {
	        return this.type;
	    }
	    
	    public abstract void dress();

}
