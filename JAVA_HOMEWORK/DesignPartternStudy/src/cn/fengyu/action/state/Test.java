package cn.fengyu.action.state;
/*
 * ״̬ģʽ��״̬ģʽ����һ�����������ڲ�״̬�ı��ʱ��ı���Ϊ��
 * ���������ȥ���Ǹı���������һ����״̬ģʽ�����о��Ķ������Ϊ
 * ��װ�ڲ�ͬ��״̬�����ÿһ��״̬��������һ������״̬���һ
 * �����ࡣ״̬ģʽ����ͼ����һ�����������ڲ�״̬�ı��ʱ��
 * ����ΪҲ��֮�ı䡣״̬ģʽ��Ҫ��ÿһ��ϵͳ����ȡ�õ�״̬����һ��
 * ״̬������ࡣ��ϵͳ��״̬�仯ʱ��ϵͳ��ı���ѡ�����ࡣ 
 */
public class Test {
	public static void main(String[] args) {
        Context ctx1 = new Context();
        ctx1.setWeather(new Sunshine());
        System.out.println(ctx1.weatherMessage());

        System.out.println("===============");

        Context ctx2 = new Context();
        ctx2.setWeather(new Rain());
        System.out.println(ctx2.weatherMessage());
    }
}
