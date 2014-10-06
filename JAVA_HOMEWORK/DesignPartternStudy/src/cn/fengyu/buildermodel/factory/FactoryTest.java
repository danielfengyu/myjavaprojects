package cn.fengyu.buildermodel.factory;

public class FactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IWorkFactory studentWorkFactory= new StudentWorkFactory();
		studentWorkFactory.getWork().doWork();
		
		IWorkFactory teacherWorkFactory= new TeacherWorkFactory();
		teacherWorkFactory.getWork().doWork();
	}

}
