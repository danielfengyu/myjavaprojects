class MyDate {
	int year, month, day;
	public String toString() {
		return "year=" + year + ", month=" + month + ", day="+day;
	}
}
class PassParameter {
	public static void main(String[] args) {
		PassParameter p1 = new PassParameter();
		MyDate m = new MyDate();		//���ڴ���д�����һ��MyDate����
		m.year = 2012; m.month = 1; m.day = 1;
		p1.display(m);					//�������ñ���m��ֵ��display����
										//��������year=2012, month=1, day=1
		System.out.println(m.year);
	}
	
	public void display(MyDate m) {		//��������m��ֵָ���ĸ������أ�
										//m��ֵ�ǵ��÷�������ģ�ֵ���ݡ�
		System.out.println(m.toString());	
		m.year = m.year - 1;			//ͨ��m��������year���ݣ�
										//���Ǹ������year���ݼ�1
		m = new MyDate();				//display�����еı���m��ֵ����
										//ָ��һ���µĶ���
		m.year = 1997;					//����������mָ��Ķ����ͷ�
	}
}
