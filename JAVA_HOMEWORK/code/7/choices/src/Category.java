//Category.java�����Ͷ�Ӧ��������
import java.io.*;
import java.util.*;

public class Category implements Serializable {
	private String name; // ���͵�����
	private String instruction; // ����������ʾ
	private String subject; // ��Ŀ
	private List<Question> questions = new ArrayList<Question>(); // �����µ����⼯��

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	/* Ϊ���������һ������ */
	public void addQuestion(Question q) {
		questions.add(q);
	}

	public int hashCode() {
		return name.hashCode();
	}

	public boolean equals(Object o) {
		if (o instanceof Category) {
			Category c = (Category) o;
			return name.equals(c.name);
		} else
			return false;
	}
}
