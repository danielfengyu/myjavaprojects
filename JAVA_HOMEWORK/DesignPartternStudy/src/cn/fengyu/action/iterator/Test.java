package cn.fengyu.action.iterator;
/**
 * ������ģʽ��������ģʽ����˳�����һ���ۼ��е�Ԫ�ض����ر�¶�ۼ����ڲ�����
 * ����������һ���γɵ������֮Ϊ�ۼ����ۼ��������ܹ�����һ��������������
 * ������ģʽ�������߼���װ��һ���������Ӷ����У��Ӷ���ۼ����������
 * ������ģʽ���˾ۼ��Ľ��档ÿһ���ۼ����󶼿�����һ����һ�����ϵĵ����Ӷ���
 * ÿһ�������ӵĵ���״̬�����Ǳ˴˶����ġ������㷨���Զ����ھۼ���ɫ�仯�� 
 * @author LENOVO
 *
 */
public class Test {
	 public static void main(String[] args) {
	        List list = new ListImpl();
	        list.add("a");
	        list.add("b");
	        list.add("c");
	        //��һ�ֵ�����ʽ
	        Iterator it = list.iterator();
	        while (it.hasNext()) {
	            System.out.println(it.next());
	        }
	        
	        System.out.println("=====");
	        //�ڶ��ֵ�����ʽ
	        for (int i = 0; i < list.getSize(); i++) {
	            System.out.println(list.get(i));
	        }
	    }
}
