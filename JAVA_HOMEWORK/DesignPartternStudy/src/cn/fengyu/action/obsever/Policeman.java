package cn.fengyu.action.obsever;
/*
 * 为那些在目标发生改变时需获得通知的对象定义一个更新接口
 */
public interface Policeman {
	void action(Citizen ci);
}
