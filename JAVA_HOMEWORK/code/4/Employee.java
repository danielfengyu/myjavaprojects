class Employee {				//û�м̳�������
	String id, name;			//Ĭ���Ǵ�java.lang.Object�̳�������
	float salary;
}
class ProjectManager extends Employee {	//ProjectManager�̳���Employee
	//additional feature					//ProjectManager����չ��Employee
	String project;						//�����˶��������
}
class Test {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.id = "008";
		e1.name = "zxc";
		e1.salary = 8888.88f;
		//e1.project = ��comedy��;	�������Ǵ���ģ���Employeeû��project��Ա����
		
		ProjectManager p1 = new ProjectManager();
		p1.id = "007"; 			//id,name,salary���Ǽ̳�����������
		p1.name = "james";
		p1.salary = 1.0f;
		p1.project = "spy";			//�������ӵ�����
	}
}
