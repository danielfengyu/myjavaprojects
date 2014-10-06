package cn.fengyu.action.iterator;
/*
 *  具体迭代器实现迭代器接口。 对该聚合遍历时跟踪当前位置。
 */
public class IteratorImpl implements Iterator{

	  private List list;
	    
	    private int index;
	    
	    public IteratorImpl(List list) {
	        index = 0;
	        this.list = list;
	    }
	    
	    public void first() {
	        index = 0;
	    }

	    public void last() {
	        index = list.getSize();
	    }

	    public Object next() {
	        Object obj = list.get(index);
	        index++;
	        return obj;
	    }

	    public boolean hasNext() {
	        return index < list.getSize();
	    }
}
