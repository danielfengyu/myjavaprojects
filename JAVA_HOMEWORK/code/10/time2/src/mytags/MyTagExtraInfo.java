package mytags;

import javax.servlet.jsp.tagext.*;

public class MyTagExtraInfo extends TagExtraInfo {
	public VariableInfo[] getVariableInfo(TagData td) {
		return new VariableInfo[] {
		// ��û���ڴ˴�ֱ�Ӹ������������֣����Ƕ�ȡ��ǵ�����var��ֵ��������
		// �ű����������֣�һ���ĵ���ͨ���������type��ֵ��ȷ����������
		// TagData��װ�˱�ǵ���������
		new VariableInfo(td.getAttributeString("var"),
				td.getAttributeString("type"), true, VariableInfo.AT_END) };
	}
}
