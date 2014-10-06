//Subject.java����Ŀ��Ӧ��������
import java.util.*;

public class Subject implements java.io.Serializable {
	private String name; // ��Ŀ����
	private List<Category> categories = new ArrayList<Category>(); // ��Ŀ�����ͼ���
	private String instruction; // ��Ŀ��Ӧ��������ʾ
	private List<Question> questions = new ArrayList<Question>(); // ��Ŀ�����⼯��

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	// �������
	public void addQuestion(Question q) {
		questions.add(q);
	}

	// �������
	public void addCategory(Category c) {
		categories.add(c);
	}

	public int hashCode() {
		return name.hashCode();
	}

	public boolean equals(Object o) {
		if (o instanceof Subject) {
			Subject s = (Subject) o;
			return name.equals(s.name);
		} else
			return false;
	}
}
