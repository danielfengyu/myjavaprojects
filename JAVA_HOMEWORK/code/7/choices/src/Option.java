//Option.java��ѡ����ѡ��������
public class Option implements java.io.Serializable {
	private Question parent; // ��ѡ���������������
	private String id; // ѡ��ı�ţ�ֵΪA��B��C��D�ȵ�
	private String content; // ѡ�������

	public Question getParent() {
		return parent;
	}

	public void setParent(Question parent) {
		this.parent = parent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
