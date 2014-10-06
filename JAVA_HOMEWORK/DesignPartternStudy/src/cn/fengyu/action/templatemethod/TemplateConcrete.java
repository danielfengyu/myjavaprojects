package cn.fengyu.action.templatemethod;
/*
 * 实现原语操作以完成算法中与特定子类相关的步骤。
 */
public class TemplateConcrete extends Template{
	public void print() {
        System.out.println("这是子类的实现");
    }

}
