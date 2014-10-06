//Question.java��ѡ�����Ӧ��������
import java.util.*;

public class Question implements java.io.Serializable, Comparable {
	private String subject; // ��Ŀ
	private String category; // ����
	private int id; // ������
	private String type, answer; // �������ͺ���ȷ��
	private String choice = ""; // �û������ѡ��ѡ��
	private String stem, ask; // �������ɺ�����
	private List<Option> options = new ArrayList<Option>(); // ����ѡ��

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getStem() {
		return stem;
	}

	public void setStem(String stem) {
		this.stem = stem;
	}

	public String getAsk() {
		return ask;
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	/* Ϊ�������һ��ѡ�� */
	public void addOption(Option o) {
		options.add(o);
	}

	/* ������������ɢ��ֵ */
	public int hashCode() {
		return id;
	}

	/* �ж������Ƿ���� */
	public boolean equals(Object o) {
		if (o instanceof Question) {
			Question q = (Question) o;
			return id == q.getId();
		} else
			return false;
	}

	// ����ıȽϷ��������������Ž��д�С�Ƚ�
	public int compareTo(Object o) {
		Question q = (Question) o;
		return id - q.getId();
	}
}
