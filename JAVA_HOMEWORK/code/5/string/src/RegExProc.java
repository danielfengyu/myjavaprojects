import java.util.regex.*; //�ð����ṩ������ʽ�Ĵ�����

public class RegExProc implements EmailValidator {
	public boolean validate(String email) { // java.util.regex.Pattern�ṩģʽ�ж�
		return Pattern.matches("\\w+@\\w+", email); // ʹ��������ʽ���ж�
		// ��ͬ��String���match(regex)����
		// return email.matches("\\w+@\\w+");
	}
}
