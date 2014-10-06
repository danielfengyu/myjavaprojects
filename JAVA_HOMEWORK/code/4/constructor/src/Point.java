public class Point {		//Point.java
	
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x) {		//���췽�����أ���������ں�����������˵��
		this(x, 0);			//���ñ���Ĺ��췽��
	}
	
	public Point() {			//���ñ���Ĺ��췽��
		this(0,0);
	}
	
	public static void main(String[] args) {
		Point p1 = new Point();		//����ʵ�������Ա����x,y��Ϊ0,0
		Point p2 = new Point(5); 	//����ʵ�������Ա����x,y��Ϊ5,0
		Point p3 = new Point(5,6); 	//����ʵ�������Ա����x,y��Ϊ5,6
	}
}	
