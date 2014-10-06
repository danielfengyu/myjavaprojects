//NumberGuessBean.java
package num;

import java.util.Random;

public class NumberGuessBean implements java.io.Serializable {
	private int answer; // ����������������Ҳ�����û�Ҫ�µ���
	private String hint; // ���û�����ʾ
	private int numGuesses; // �û��µĴ���
	private boolean success; // ��Ϸ�����״̬

	private Random random = new Random();

	public NumberGuessBean() { // ���췽����Ҫ������Ϸ��ʼ������
		reset();
	}

	public int getAnswer() { // �������ݶ�������getter��
		return answer;
	}

	public String getHint() { // �������ݶ�������getter��
		return "" + hint;
	}

	public int getNumGuesses() { // �������ݶ�������getter��
		return numGuesses;
	}

	public boolean getSuccess() { // �������ݶ�������getter��
		return success;
	}

	/* ��������д�������û��ڽ������������ݣ����ô˷����������ж� */
	public void setGuess(String guess) {
		numGuesses++; // �µĴ�����1

		int g;
		try {
			g = Integer.parseInt(guess); // ���ַ���ת��Ϊ����
		} catch (NumberFormatException e) {
			g = -1; // �û�������������������ֵ����
		}

		if (g == answer) { // �¶���
			success = true;
		} else if (g == -1) { // ����Ƿ���ֵ����
			hint = "a number next time";
		} else if (g < answer) { // �µ���
			hint = "higher"; // �´���¸ߵ��
		} else if (g > answer) { // �¸���
			hint = "lower"; // �´���µ͵��
		}
	}

	public void reset() { // ��λ��Ϸ״̬
		answer = Math.abs(random.nextInt() % 100) + 1;
		success = false; // û�ɹ�
		numGuesses = 0; // ������ԭΪ0
	}
}
