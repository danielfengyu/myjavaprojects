package cn.fengyu.action.iterator;
/*
 *  �ۺ϶��崴����Ӧ����������Ľӿڡ�
 */
public interface List {
	 Iterator iterator();
	    
	    Object get(int index);
	    
	    int getSize();
	    
	    void add(Object obj);
}
