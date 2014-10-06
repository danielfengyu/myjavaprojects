package cn.fengyu.singleton;

/**
 * 类中的静态成员变量或函数可以直接用类名访问。
 * getInstance()方法是获得单例对象的方法。
 * 一旦一个对象在内存中创建，就直到程序结束才消亡
 */
public class Singleton {

	private static Singleton single;
	private Singleton () {
		super();
	}
	public  static Singleton getInstance() {
		if(single==null){
			single=new Singleton();
		}
		return single;
	}

}
