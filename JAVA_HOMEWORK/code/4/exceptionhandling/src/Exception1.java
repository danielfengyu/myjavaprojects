public class Exception1 {

	public static void main(String[] args) {
		int[] a = new int[10]; // ������׳�java.lang.ArrayIndexOutOfBoundsException
		a[10] = 5; // �����±������0��ʼ������aû�е�11��Ԫ��

		MyDate d1 = new MyDate();
		d1.year = 2011;
		d1 = null; // ���г�����׳�java.lang.NullPointerException
		d1.year = 2012; // ���ñ���d1��ָ���κζ��󣬺���year���ݣ�

		int i = 5, j = 0; // ���г�����׳�java.lang.ArithmeticException
		i = i / j; // ��������

		ProjectManager p1 = new ProjectManager(); // ProjectManager�̳�Employee
		Employee e1 = new Employee(); // ���г�����׳�java.lang.ClassCastException
		p1 = (ProjectManager) e1;

	}

}
