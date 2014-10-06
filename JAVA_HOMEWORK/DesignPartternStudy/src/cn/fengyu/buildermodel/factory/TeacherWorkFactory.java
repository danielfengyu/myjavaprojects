package cn.fengyu.buildermodel.factory;

public class TeacherWorkFactory implements IWorkFactory{
	public Work getWork(){
		return   new TeacherWork();
	}
}
