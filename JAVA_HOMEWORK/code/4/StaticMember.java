class StaticMember {
	int i;						//ʵ�����Գ�Ա��ʵ����Ա
	static int j;				//��̬���Գ�Ա�����Ա
	
	public void print() {			//ʵ����Ϊ��ʵ������
		System.out.println(i);
	}
	
	static public void print(int i) {	//��̬��Ϊ����̬���������η����û��˳��Ҫ��
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		//i = 5;  				//�������Ǵ���ģ�ʵ�����ݱ���ͨ������������
		j = 6;					//������StaticMember���ڲ�����������ʡ�Ե�
							//������������У�Ӧ��дStaticMember.j = 6;
		print(5);				//Ҳ����дStaticMember.print(5);
		
		//print();				//���Ҳ�Ǵ�������
		
		StaticMember s1 = new StaticMember();	//����������ʵ����
		StaticMember s2 = new StaticMember();	//������������˲�ͬ�Ĵ洢�ռ�
		
		s1.i = 5;   s2.i = 6;		//ͨ���������ֱ����������ͬ��������ݳ�Ա
		s1.print(); s2.print();	//����������ʵ������Ϊ	
}
}
