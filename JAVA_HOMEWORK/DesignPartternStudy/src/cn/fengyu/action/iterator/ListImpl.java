package cn.fengyu.action.iterator;
/*
 * 具体聚合实现创建相应迭代器的接口，该操作返回ConcreteIterator的一个适当的实例.
 */
public class ListImpl implements List{
	 private Object[] list;
	    
	    private int index;
	    
	    private int size;
	    
	    public ListImpl() {
	        index = 0;
	        size = 0;
	        list = new Object[100];
	    }
	    
	    public Iterator iterator() {
	        return new IteratorImpl(this);
	    }
	    
	    public Object get(int index) {
	        return list[index];
	    }
	    
	    public int getSize() {
	        return this.size;
	    }
	    
	    public void add(Object obj) {
	        list[index++] = obj;
	        size++;
	    }
}
