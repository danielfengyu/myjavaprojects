public class CharProc implements EmailValidator { // ��һ��ʵ��
	public boolean validate(String email) {
		boolean found = false; // �Ƿ�����@�ַ��ı�־
		int len = email.length();
		if (len < 3) { // ������a@b
			return false;
		}
		for (int i = 0; i < len; i++) {
			if (email.charAt(i) == '@') {
				if (found) { // ����Ѿ�������@�ַ������ٴη���@�ַ�
					return false;
				} else {
					if (i == 0) { // �����ַ���@
						return false;
					}
					if (i == len - 1) { // ��β�ַ���@
						return false;
					}
					found = true;
				}
			}

		}
		return found; // һ��@�ַ�Ҳû�з��֣�
		// ���߷���Ψһһ��@�����Ҳ��Ǵ��ף�Ҳ���Ǵ�β
	}
}
