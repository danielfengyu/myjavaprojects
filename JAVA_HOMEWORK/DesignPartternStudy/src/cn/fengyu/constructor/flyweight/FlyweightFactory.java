package cn.fengyu.constructor.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
	 private static Map<String,Flyweight> flyweights = new HashMap<String,Flyweight>();
	    
//	    public FlyweightFactory(String arg) {
//	        flyweights.put(arg, new FlyweightImpl());
//	    }
//	    
	    public static Flyweight getFlyweight(String key) {
	        Flyweight flyweight=flyweights.get(key);
	    	if (flyweights.get(key) == null) {
	    
	            flyweights.put(key, new FlyweightImpl());
	        }
	        return flyweights.get(key);
	    }
	    
	    public static int getSize() {
	        return flyweights.size();
	    }
}
