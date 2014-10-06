package cn.fengyu.action.iterator;
/**
 * 迭代子模式：迭代子模式可以顺序访问一个聚集中的元素而不必暴露聚集的内部表象。
 * 多个对象聚在一起形成的总体称之为聚集，聚集对象是能够包容一组对象的容器对象。
 * 迭代子模式将迭代逻辑封装到一个独立的子对象中，从而与聚集本身隔开。
 * 迭代子模式简化了聚集的界面。每一个聚集对象都可以有一个或一个以上的迭代子对象，
 * 每一个迭代子的迭代状态可以是彼此独立的。迭代算法可以独立于聚集角色变化。 
 * @author LENOVO
 *
 */
public class Test {
	 public static void main(String[] args) {
	        List list = new ListImpl();
	        list.add("a");
	        list.add("b");
	        list.add("c");
	        //第一种迭代方式
	        Iterator it = list.iterator();
	        while (it.hasNext()) {
	            System.out.println(it.next());
	        }
	        
	        System.out.println("=====");
	        //第二种迭代方式
	        for (int i = 0; i < list.getSize(); i++) {
	            System.out.println(list.get(i));
	        }
	    }
}
