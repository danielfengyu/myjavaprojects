package cn.fengyu.action.obsever;
/*
 *  维护一个指向ConcreteSubject对象的引用。
 *  存储有关状态，这些状态应与目标的状态保持一致。 
 *  实现Observer的更新接口*使自身状态与目标的状态保持一致
 */
public class TianHePoliceman implements Policeman{
	public void action(Citizen ci) {
        String help = ci.getHelp();
        if (help.equals("normal")) {
            System.out.println("一切正常, 不用出动");
        }
        if (help.equals("unnormal")) {
            System.out.println("有犯罪行为, 天河警察出动!");
        }
    }
}
