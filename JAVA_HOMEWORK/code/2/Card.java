public class Card {
	int rank;
	public static void swap1(Card c1, Card c2) {	//�������һ������Ҳû��
		Card temp = c1;								//�ڴ˷����Ĳ���������Ҳ��
		c1 = c2;									//�ֲ���������ֵ��Ȼ�����
		c2 = temp;									//���أ��ֲ����������ͷŵ�
	}
	public static void swap2(Card c1, Card c2) {
		int temp = c1.rank;							//�������Ƕ����ֵ��
		c1.rank = c2.rank;							//�����Ľ���.
		c2.rank = temp;
	}
	public static void main(String[] args) {
		Card c1 = new Card();
		c1.rank = 5;
		Card c2 = new Card();
		c2.rank = 6;
		swap1(c1,c2);
		System.out.println("c1 rank = " + c1.rank + "\t\tc2 rank = " + c2.rank);
		swap2(c1,c2);
		System.out.println("c1 rank = " + c1.rank + "\t\tc2 rank = " + c2.rank);
	}
}
