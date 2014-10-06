public class IfAndSwitch {

	public int max(int a, int b) { // �����������еĴ����
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}

	public int abs(int a) { // ���ؾ���ֵ
		if (a >= 0) {
			return a;
		} else {
			return -a;
		}
	}

	public String grade(int score) {
		if (score >= 90) {
			return "A";
		} else if (score >= 80) {
			return "B";
		} else if (score >= 70) {
			return "C";
		} else if (score >= 60) {
			return "D";
		} else {
			return "E";
		}
	}

	public void printColor(int color) {
		switch (color) {
		case 0:
			System.out.println("red");
			break;
		case 1:
			System.out.println("green");
			break;
		case 2:
			System.out.println("blue");
			break;
		default:
			System.out.println("black");
		}
	}

	public int getQuarter(int month) {
		// switch��䲻̫�ʺ��������жϣ�������ʹ��if-else�ṹ���������Կ�һЩ��
		// ��Ȼ��������ӻ�����ֱ��ʹ�ó�����return (month -1)/ 3 + 1;
		int result = 1;
		switch (month) {
		case 1:
		case 2:
		case 3:
			result = 1;
			break;
		case 4:
		case 5:
		case 6:
			result = 2;
			break;
		case 7:
		case 8:
		case 9:
			result = 3;
			break;
		case 10:
		case 11:
		case 12:
			result = 4;
			break;
		}
		return result;
	}

	// ����һ������
	public String getSeason(int month) {
		String result = "";
		switch (month) {
		case 3:
		case 4:
		case 5:
			result = "Spring";
			break;
		case 6:
		case 7:
		case 8:
			result = "Summer";
			break;
		case 9:
		case 10:
		case 11:
			result = "Autumn";
			break;
		case 12:
		case 1:
		case 2:
			result = "Winter";
			break;
		}
		return result;
	}

	public static void main(String[] args) {
		IfAndSwitch ias = new IfAndSwitch();
		System.out.println(ias.max(8, 9));
		System.out.println(ias.abs(-10));
		System.out.println(ias.grade(100));
		ias.printColor(2);
		System.out.println(ias.getSeason(1));

	}

}
