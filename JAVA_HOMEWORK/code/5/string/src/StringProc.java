public class StringProc implements EmailValidator {
	public boolean validate(String email) {
		int len = email.length();
		if (len < 3) {
			return false;
		}
		// ���ַ�������@�� ĩβ�ַ�Ҳ������@������һ��@Ҳû��
		// Ҳ���ܰ������@
		return email.charAt(0) != '@' && email.charAt(len - 1) != '@'
				&& email.indexOf('@') != -1
				&& email.indexOf('@') == email.lastIndexOf('@');
	}
}
