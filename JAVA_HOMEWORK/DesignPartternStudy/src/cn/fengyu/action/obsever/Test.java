package cn.fengyu.action.obsever;
/*
 * 观察者模式：观察者模式定义了一种一对多的依赖关系，
 * 让多个观察者对象同时监听某一个主题对象。这个主题对象在状态
 * 上发生变化时，会通知所有观察者对象，使他们能够自动更新自己。
 */
public class Test {
	public static void main(String[] args) {
        Policeman thPol = new TianHePoliceman();
        Policeman hpPol = new HuangPuPoliceman();
        
        Citizen citizen = new HuangPuCitizen(hpPol);
        citizen.sendMessage("unnormal");
        citizen.sendMessage("normal");
        
        System.out.println("===========");
        
        citizen = new TianHeCitizen(thPol);
        citizen.sendMessage("normal");
        citizen.sendMessage("unnormal");
    }
}
