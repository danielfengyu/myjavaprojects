/* ChoiceFrame.java��ѡ������ϰӦ�ö�Ӧ�Ĵ��ڣ���װ�˸���GUI�����
�Լ��¼���������Ҳ��װ��ѡ����ģ�Ͷ����䴦����  */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.dom4j.io.*;
import org.dom4j.*;

public class ChoiceFrame extends JFrame implements ActionListener {
	JComboBox subjects; // ��Ŀ�����б������Ա
	JComboBox categories; // ���������б������Ա
	JTextField amount; // �������������Ա
	JRadioButton rand; // �����ʽ��˳��ʽ��ѡ��ť�����Ա
	JRadioButton seq;
	JTextField begin; // ��Ϊ˳��ʽ�Ļ�����ʼ����ı�������Ա
	JButton start; // ��ʼ��ť
	JCheckBox showAnswer; // �Ƿ���ʾ��ѡ��
	JButton next; // ��һ����
	JButton prev; // ��һ����
	JButton submit; // ����

	JFileChooser fc; // �ļ�ѡ�����

	JPanel pm = new JPanel(); // ��������ɺ����ʼ�ѡ���������
	JPanel pa = new JPanel(); // ������ѡ������
	JEditorPane qcontent = new JEditorPane(); // ��ɺ����ʱ༭��ʾ���

	JMenuItem open = new JMenuItem("������ļ�(O)");
	JMenuItem exit = new JMenuItem("�˳�(E)");

	java.util.List<Subject> model; // �������������ݵ�ģ�Ͷ����Ա
	java.util.List<Question> select; // �����ϰ��Ķ����Ա
	int current = 0; // ��ǰ����ı�ţ���1��ʼ

	public ChoiceFrame() {
		super("ѡ������ϰ���"); // ���ڱ���

		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("�ļ�(F)");
		m1.setMnemonic(KeyEvent.VK_F); // ����˵���Ŀ�ݼ�ALT+F
		open.setMnemonic(KeyEvent.VK_O);
		exit.setMnemonic(KeyEvent.VK_E);
		m1.add(open);
		m1.add(exit);
		mb.add(m1);
		setJMenuBar(mb);

		JPanel p = showPractice();
		setContentPane(p);

		open.addActionListener(this);
		exit.addActionListener(this);

		setSize(760, 560); // ���ô��ڴ�С����ʾλ�ã���������Ļ����������ʾ
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((scr.width - 760) / 2, (scr.height - 560) / 2);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public JPanel showPractice() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());

		JLabel label1 = new JLabel("��Ŀ");
		subjects = new JComboBox();
		JLabel label2 = new JLabel("����");
		categories = new JComboBox();

		Dimension d1;
		d1 = subjects.getPreferredSize();
		subjects.setPreferredSize(new Dimension(120, d1.height));
		categories.setPreferredSize(new Dimension(120, d1.height));

		JLabel label3 = new JLabel("����");
		amount = new JTextField(4);

		rand = new JRadioButton("���", true);
		seq = new JRadioButton("˳��", false);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rand);
		bg.add(seq);

		JLabel label4 = new JLabel("��ʼ���");
		begin = new JTextField(4);
		start = new JButton("��ʼ");

		showAnswer = new JCheckBox("��ʾ��", false);
		showAnswer.setForeground(Color.red);
		next = new JButton("��һ����");
		prev = new JButton("��һ����");
		submit = new JButton("����");

		begin.setEnabled(false);

		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEADING, 4, 4));

		p1.add(label1);
		p1.add(subjects);
		p1.add(label2);
		p1.add(categories);
		p1.add(label3);
		p1.add(amount);
		p1.add(rand);
		p1.add(seq);
		p1.add(label4);
		p1.add(begin);
		p1.add(start);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.TRAILING));
		p2.add(showAnswer);
		p2.add(prev);
		p2.add(next);
		p2.add(submit);

		pm.setLayout(new BorderLayout());
		pa.setLayout(new BoxLayout(pa, BoxLayout.Y_AXIS)); // ��������˳��ڷ�ѡ��

		JScrollPane jsp2 = new JScrollPane(qcontent); // ֧�ֹ�������
		pm.add(jsp2, BorderLayout.CENTER);
		qcontent.setEditable(false);

		pm.add(pa, BorderLayout.SOUTH);

		qcontent.setText("");
		qcontent.setEditable(false);

		p.add(p1, BorderLayout.NORTH);
		p.add(p2, BorderLayout.SOUTH);
		p.add(pm, BorderLayout.CENTER);

		p.setOpaque(true);
		/*
		 * Ϊ��Щ���ע�����ڣ�Ϊ�˱�̼򵥷��㣬���������б��ѡ�ť�ȣ�
		 * û��ʹ��ItemEvent�¼���Ӧ�������࣬��ͳһʹ��ActionEvent�¼��� ����һ�����ڣ�Ȼ�����¼��������и����¼�Դȥ���֡�
		 */
		rand.addActionListener(this);
		seq.addActionListener(this);
		showAnswer.addActionListener(this);
		subjects.addActionListener(this);
		categories.addActionListener(this);
		prev.addActionListener(this);
		next.addActionListener(this);
		submit.addActionListener(this);
		start.addActionListener(this);

		return p;
	}

	public int getAmount(String subject, String category) {
		if (model == null) {
			return 0;
		} // ���û��ģ�ͣ���������Ϊ0
		// ���û�п�Ŀ������������������ҲΪ0
		if (subject == null || subject.length() == 0) {
			return 0;
		}
		if (category == null || category.length() == 0) {// ֻ�п�Ŀ��û�����Ͳ��������
			int a1 = 0;
			for (int i = 0; i < model.size(); i++) {
				Subject s = model.get(i);
				if (subject.equals(s.getName())) {
					a1 += s.getQuestions().size(); // �ۼӲ��������͵���������
					// ���ۼӸÿ�Ŀ�����������µ���������
					java.util.List<Category> categories = s.getCategories();
					for (int j = 0; j < categories.size(); j++) {
						a1 += categories.get(j).getQuestions().size();
					}
				}
			}
			return a1;
		} else { // ���򣬷���ָ����Ŀ�������µ���������
			int a1 = 0;
			for (int i = 0; i < model.size(); i++) {
				Subject s = model.get(i);
				if (subject.equals(s.getName())) {
					java.util.List<Category> categories = s.getCategories();
					for (int j = 0; j < categories.size(); j++) {
						if (category.equals(categories.get(j).getName())) {
							a1 += categories.get(j).getQuestions().size();
						}
					}
				}
			}
			return a1;
		}
	}

	// ��ʾĳ�����⣬�����������ɣ����ʣ�ѡ��Լ��û���ѡ�������
	public void displayQuestion(Question q) {
		StringBuffer sb = new StringBuffer();
		// �������ʾ�������ʾ����Ŀ�������¿���������ָ�ϣ�instruction����
		String s1 = q.getSubject();
		Subject sub1 = getSubject(s1);
		String ins1 = sub1.getInstruction();
		if (ins1 != null && ins1.length() != 0) {
			sb.append(ins1);
			sb.append("\r\n\r\n");
		}

		String ca1 = q.getCategory();
		if (ca1 != null && ca1.length() > 0) {
			Category ca2 = getCategory(q.getSubject(), ca1);
			if (ca2 != null && ca2.getInstruction() != null
					&& ca2.getInstruction().length() != 0) {
				sb.append(ca2.getInstruction());
				sb.append("\r\n\r\n");
			}
		}
		/*
		 * �����ţ���������ʽ�£������ѡ�������˳���ţ����� ��ʾԭ���ţ���Ҫѡ�������֮ǰ���������������֮ǰ������
		 */
		int num = 0;
		if (rand.isSelected()) { // �����ʽ����ʾcurrent����ǰ��ŵ�ֵ
			num = current;
		} else {
			num = q.getId(); // ˳��ʽ����ʾ���Ȿ��ı��
		}

		String stem = q.getStem(); // ������������
		String ask = q.getAsk(); // �������������
		if (stem == null) {
			stem = "";
		}
		if (ask == null) {
			ask = "";
		}

		if (stem.length() != 0) { // ���������ݲ�Ϊ�գ��������ʾ�����֮ǰ
			sb.append(num + ". " + stem + "\r\n");
		}
		if (ask.length() != 0) {
			if (stem.length() == 0) { // ����������Ϊ�գ��������ʾ������֮ǰ
				sb.append(num + ". " + ask + "\r\n");
			} else {
				sb.append(ask + "\r\n");
			}
		}

		qcontent.setText(sb.toString()); // �����JEditorPane�����
		pa.removeAll(); // �����ѡ������������������

		/*
		 * ��ѡ������ŵ�ѡ�����pa�У����ݵ�ѡ��Ͷ�ѡ�����ɲ�ͬ��ѡ�� ��ť���ٸ����Ƿ���ʾ�𰸣�����ѡ�ť�Ĳ�ͬ��ǰ����ɫ��
		 * �ٸ��ݸ�ѡ���Ƿ����û��������У����ø�ѡ�ť�Ƿ�ѡ��
		 */
		java.util.List<Option> ops = q.getOptions();
		ButtonGroup bg = new ButtonGroup();
		for (int i = 0; i < ops.size(); i++) {
			JPanel p = new JPanel();
			p.setLayout(new FlowLayout(FlowLayout.LEFT));
			JToggleButton jtb = null;
			if (q.getType().equals("single")) { // ��ѡ��
				jtb = new JRadioButton(ops.get(i).getId() + ". "
						+ ops.get(i).getContent());
				bg.add(jtb);
			} else if (q.getType().equals("multiple")) { // ��ѡ��
				jtb = new JCheckBox(ops.get(i).getId() + ". "
						+ ops.get(i).getContent());
			}
			jtb.setActionCommand(ops.get(i).getId()); // Ϊ�����ֵ���ĸ�ѡ�ť
			jtb.addActionListener(this);
			if (q.getChoice().contains(ops.get(i).getId())) { // choice���û�������ѡ��
				jtb.setSelected(true);
			} else {
				jtb.setSelected(false);
			}
			/* ���а������ѡ������Ƿ���ʾ�𰸰�ť��ѡ��״̬ */
			if (q.getAnswer().contains(ops.get(i).getId())
					&& showAnswer.isSelected()) {
				jtb.setForeground(Color.red);
			}

			p.add(jtb);
			pa.add(p);
		}
		pm.validate(); // �ػ������壬��Ϊ��������Ѿ������仯
	}

	public void displayAmount() { // ���ݿ�Ŀ������������������������������
		String s1 = (String) subjects.getSelectedItem();
		String c1 = (String) categories.getSelectedItem();

		int a1 = getAmount(s1, c1);
		amount.setText("" + a1);
	}

	// ���ݿ�Ŀ�����͵��ַ����������ݵõ�ģ����Category����
	public Category getCategory(String subject, String category) {
		if (model == null) {
			return null;
		}
		if (subject == null || subject.length() == 0) {
			return null;
		}
		if (category == null || category.length() == 0) {
			return null;
		}
		for (int i = 0; i < model.size(); i++) {
			Subject s1 = model.get(i);
			if (s1.getName().equals(subject)) {
				java.util.List<Category> categories = s1.getCategories();
				for (int j = 0; j < categories.size(); j++) {
					if (categories.get(j).getName().equals(category)) {
						return categories.get(j);
					}
				}
			}
		}
		return null;
	}

	// ���ݿ�Ŀ���ַ����������ݵõ�ģ����Subject����
	public Subject getSubject(String subject) {
		if (subject == null || subject.length() == 0) {
			return null;
		}
		if (model == null) {
			return null;
		}
		for (int i = 0; i < model.size(); i++) {
			if (model.get(i).getName().equals(subject)) {
				return model.get(i);
			}
		}
		return null;
	}

	// ���ݿ�Ŀ���ַ����������ݵõ�ģ���иÿ�Ŀ�µ�������������
	public java.util.List<Category> getCategories(String subject) {
		java.util.List<Category> r = new java.util.ArrayList<Category>();
		if (model == null) {
			return r;
		}

		for (int i = 0; i < model.size(); i++) {
			Subject s = model.get(i);
			if (subject.equals(s.getName())) {
				r.addAll(s.getCategories());
			}
		}
		return r;
	}

	/*
	 * ���ݽ������û�����������������ϰ�⣬���ݿ�Ŀ�����͵����ݲ����� ���ָ���˿�Ŀ�����ͣ�����ݸ������µ����ݽ�������ػ���˳���
	 * ������ϰ�⣬����ָֻ���˿�Ŀ��û��ָ�����ͣ���ôֻȡ�ÿ�Ŀ�µ����⣬ ����ȡ�����ĳЩ�����µ����⣬������Щѡ������ⷶΧ������ػ���
	 * ˳���ѡȡָ����������ϰ�⡣
	 */
	public java.util.List<Question> createQuestions(String subject,
			String category, boolean mode, int index, int amount) {
		index--;
		current = 0;
		java.util.List<Question> s = null;
		java.util.List<Question> temp = new java.util.ArrayList<Question>();
		if (subject == null) {
			subject = "";
		}
		if (category == null) {
			category = "";
		}
		if (subject.length() != 0 && category.length() != 0) {
			Category c1 = getCategory(subject, category);
			temp.addAll(c1.getQuestions()); // ��Ӹÿ�Ŀ�������µ���������
		} else if (subject.length() != 0 && category.length() == 0) {
			Subject s1 = getSubject(subject); // ��Ӹÿ�Ŀ�µ�����
			temp.addAll(s1.getQuestions());
		}

		if (temp.size() == 0) { // ���û������ɹ���ϰ���򷵻�һ���յļ���
			return temp;
		}

		for (int i = 0; i < temp.size(); i++) {
			temp.get(i).setChoice(""); // ���û��������ѡ�����
		}

		if (mode) { // �����ʽ
			if (amount > temp.size()) {
				amount = temp.size();
			}
			Collections.shuffle(temp); // ���ù�����Collections�����򷽷�
			s = temp.subList(0, amount); // ����ط���ָ������������
		} else { // ˳��ʽ
			if (index + amount > temp.size()) { // ������������������
				amount = temp.size() - index; // ���µ������ص���������
			}
			s = temp.subList(index, index + amount); // ����˳������⼯
		}
		return s;
	}

	// ��XML�ļ��е�questionԪ�ؼ����������
	public Question processQuestion(Element qe, String subject, String category) {
		Question q = new Question();
		q.setSubject(subject);
		q.setCategory(category);
		q.setId(Integer.parseInt(qe.attributeValue("id"))); // ������
		q.setType(qe.attributeValue("type")); // ��������
		q.setAnswer(qe.attributeValue("answer")); // �����

		Element stem = qe.element("stem"); // ������������
		Element ask = qe.element("ask"); // �������������
		if (stem != null) {
			q.setStem(stem.getText());
		}
		if (ask != null) {
			q.setAsk(ask.getText());
		}
		/* ��������ѡ������ */
		java.util.List options = qe.elements("option");
		for (int i = 0; i < options.size(); i++) {
			Element oe = (Element) options.get(i);
			Option o = new Option();
			o.setId(oe.attributeValue("id"));
			o.setContent(oe.getText());
			o.setParent(q);
			q.addOption(o);
		}
		return q;
	}

	// ����XMLԪ��category��������Category����
	public Category processCategory(Element ce, String subject) {
		Category c1 = new Category();
		c1.setName(ce.attributeValue("name"));
		c1.setSubject(subject);
		java.util.List list = ce.elements();
		for (int i = 0; i < list.size(); i++) {
			Element e1 = (Element) list.get(i);
			String ename = e1.getName();
			if (ename.equals("instruction")) { // ������Ͷ�Ӧ����ʾ����
				c1.setInstruction(e1.getText());
			} else if (ename.equals("question")) { // ��������������
				c1.addQuestion(processQuestion(e1, subject, c1.getName()));
			}
		}
		return c1;
	}

	// ����XMLԪ��subject��������Subject����
	public Subject processSubject(Element se) {
		Subject s1 = new Subject();
		s1.setName(se.attributeValue("name"));
		java.util.List list = se.elements();
		for (int i = 0; i < list.size(); i++) {
			Element e1 = (Element) list.get(i);
			String ename = e1.getName();
			if (ename.equals("instruction")) { // ��Ŀ��Ӧ��������ʾ����
				s1.setInstruction(e1.getText());
			} else if (ename.equals("category")) { // ��Ŀ�µ���������
				s1.addCategory(processCategory(e1, s1.getName()));
			} else if (ename.equals("question")) { // ��Ŀ�µ��������ݣ�����Ϊ��
				s1.addQuestion(processQuestion(e1, s1.getName(), null));
			}
		}
		return s1;
	}

	// �����û����������ļ�������samples.xml��������ļ����ݼ��ص����⼯�ϡ�
	public java.util.List<Subject> loadQuestions(File file) {
		current = 0;
		java.util.List<Subject> model = new java.util.ArrayList<Subject>();// �����ģ��
		try { // ������������DOM4J��API����ȡXML����
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new FileInputStream(file));
			XPath path = doc.createXPath("/library/subject");
			java.util.List list = path.selectNodes(doc); // �������е�subjectԪ��
			for (int i = 0; i < list.size(); i++) {
				Element e1 = (Element) list.get(i);
				model.add(processSubject(e1)); // ��ģ�����������
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	/*
	 * ��ʼ�����棬��տ�Ŀ�����͵����ݣ����ݼ��ص�����ļ����ݣ� ��ӿ�Ŀ����������������ʾ������������ݵ�
	 */
	public void initSelection() { // after load library file.
		subjects.removeActionListener(this); // ���ù����з������¼����ݲ�����
		categories.removeActionListener(this); // �����Ȱ���Щ���ڶ���ȡ��ע��

		subjects.removeAllItems(); // ��տ�Ŀ������
		categories.removeAllItems();

		amount.setText(""); // �����������ԭ��ϰ��ʽ���Ƿ���ʾ��
		rand.setSelected(true);
		begin.setText("");
		showAnswer.setSelected(false);

		for (int i = 0; i < model.size(); i++) { // ���Ŀ����������ӿ�Ŀ������
			Subject s1 = model.get(i);
			subjects.addItem(s1.getName());
		}

		if (subjects.getItemCount() == 1) { // ���ֻ��һ����Ŀ����ͬʱѡ��ÿ�Ŀ
			subjects.setSelectedIndex(0);
			String s1 = (String) subjects.getSelectedItem();
			if (s1 != null) { // �����ѡ���Ŀ�Ŀ����ͬʱ��ʾ�ÿ�Ŀ�µ���������
				java.util.List<Category> list = getCategories(s1);
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						categories.addItem(list.get(i).getName());
					}
				}
			}
		} else {
			subjects.setSelectedIndex(-1); // �������в���һ����Ŀ����ѡ
		}

		displayAmount(); // �����������

		current = 0; // ��ϰ����Ҳ��ԭΪ0
		select = null; // ���ѡ�����ϰ�⼯��

		pa.removeAll(); // �����е�����ѡ�����ݶ����
		qcontent.setText(""); // ����ʵ�ֵ���ɣ����ʵȶ����
		pm.validate();

		subjects.addActionListener(this); // ����ע������
		categories.addActionListener(this);
	}

	public String addAnswer(String ch, String answer) { // ���û�ѡ�����ѡ��
		if (!ch.contains(answer)) { // ��������ڸ�ѡ�������
			char[] ca = ch.toCharArray(); // ת��Ϊ�ַ�����
			char[] cb = new char[ca.length + 1]; // �½�����
			System.arraycopy(ca, 0, cb, 0, ca.length); // ������ǰ��������
			cb[ca.length] = answer.charAt(0); // ����µ�ѡ��
			Arrays.sort(cb); // �������ѡ������
			return new String(cb); // ����Ϊ�ַ�����ʽ
		} else { // ������и��û�ѡ�������
			return ch;
		}
	}

	public String removeAnswer(String ch, String answer) { // ���û�ѡ����ɾ��ѡ��
		if (ch.contains(answer)) {
			int p1 = ch.indexOf(answer); // ȥ����ѡ��
			return ch.substring(0, p1) + ch.substring(p1 + 1);
		} else {
			return ch;
		}
	}

	/* ���´������¼�������� */
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource(); // ����¼�Դ����
		if (source == open) { // �û�������ǲ˵��������ļ�
			processOpenClick();
		} else if (source == exit) { // �û�������ǲ˵���˳�ϵͳ
			System.exit(0);
		} else if (source == subjects) { // �û������Ŀ������
			processSubjectsClick();
		} else if (source == categories) {// �û��������������
			displayAmount();
		} else if (source == rand) { // �û���������ʽ
			processRandClick();
		} else if (source == seq) { // �û����˳��ʽ
			processSeqClick();
		} else if (source == showAnswer) { // �û�����Ƿ���ʾ��
			processShowAnswer();
		} else if (source == start) { // �û������ʼ��ť����ʼ��ϰ
			processStartClick();
		} else if (source == next) { // �û������һ���ⰴť
			processNextClick();
		} else if (source == prev) { // �û������һ���ⰴť
			processPrevClick();
		} else if (source == submit) { // �û��������ť
			processSubmitClick();
		} else if (source instanceof JToggleButton) { // �û����ѡ�ť
			JToggleButton jtb = (JToggleButton) source;
			String actionCommand = jtb.getActionCommand();
			if (actionCommand != null && actionCommand.length() == 1) {
				if (jtb instanceof JRadioButton) {
					// ѡ�ť�ǵ�ѡ��ť����ֱ�������û�ѡ���
					select.get(current - 1).setChoice(actionCommand);
				} else if (jtb instanceof JCheckBox) {
					// �û�������Ǹ�ѡ��ť������Ҫ���ݸ�ѡ��ť��״̬
					// �����������ѡ��Ǵ��û�ѡ��������ɾ��ѡ��
					String ch = select.get(current - 1).getChoice();
					if (jtb.isSelected()) { // ����ѡ�������ѡ��
						ch = addAnswer(ch, actionCommand);
					} else { // �Ǵ�ѡ����ɾ��ѡ��
						ch = removeAnswer(ch, actionCommand);
					}
					select.get(current - 1).setChoice(ch);
				}
			}
		}
	}

	public void processOpenClick() { // �û�����˵���������ļ�
		new Thread() {
			public void run() {
				fc = new JFileChooser(); // ���ļ�ѡ��Ի���
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"����ļ�(XML)", "xml", "XML");
				fc.setFileFilter(filter); // �����ļ���׺ѡ��
				int returnVal = fc.showOpenDialog(ChoiceFrame.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					model = loadQuestions(f); // ��������ļ������ģ�Ͷ���

					initSelection(); // ��ʼ�����棬���û�����
					ChoiceFrame.this.setTitle("ѡ������ϰ���---" + f.getName());
					// ���ý����ڿ�Ŀ�����б�򣬹��û�ѡ���Ŀ����ʼ��ϰ
					subjects.requestFocusInWindow();
				}
			}
		}.start();
	}

	public void processSubjectsClick() {
		categories.removeActionListener(this); // ����ʱֹͣ������������¼���Ӧ

		String s1 = (String) subjects.getSelectedItem(); // ��ÿ�Ŀ�������ѡ��
		if (s1 != null) {
			java.util.List<Category> list = getCategories(s1); // �õ��ÿ�Ŀ��Ӧ������

			categories.removeAllItems(); // �������������

			if (list != null) { // ��Ӹÿ�Ŀ�µ��������͵�����������
				for (int i = 0; i < list.size(); i++) {
					categories.addItem(list.get(i).getName());
				}
				if (categories.getItemCount() == 1) { // ���ֻ��һ������
					categories.setSelectedIndex(0); // ��ֱ������ѡ�������
				} else {
					categories.setSelectedIndex(-1); // ���򣬲�ѡ
				}
				displayAmount(); // ������ʾ����
				categories.requestFocusInWindow(); // ���ý������������������
			}
		}
		categories.addActionListener(this); // ����Ϊ����������ע������
	}

	public void processRandClick() { // ������ѡ�ť����ֹ������ʼ���
		begin.setText("");
		begin.setEnabled(false);
	}

	public void processSeqClick() { // ���˳��ѡ�ť
		begin.setEditable(true);
		begin.setEnabled(true);
		begin.requestFocusInWindow(); // ��ʼ��ŵõ����뽹��
	}

	public void processShowAnswer() {
		// ����Ƿ���ʾ�𰸣��������ϰ�����У���Ҫˢ����ʾ��������ʾ����
		if (select != null && select.size() > 0 && current != 0) {
			displayQuestion(select.get(current - 1));
		}
	}

	public void processStartClick() { // �����ʼ��ť
		String ss = (String) subjects.getSelectedItem();
		String sc = (String) categories.getSelectedItem();

		if (ss == null || ss.length() == 0) { // ���ûѡ�п�Ŀ����ô������Ϣ��ʾ�򴰿�
			JOptionPane.showMessageDialog(ChoiceFrame.this, "��ѡ���Ŀ", "��Ŀ������ʾ",
					JOptionPane.WARNING_MESSAGE);
			subjects.requestFocusInWindow();
			return;
		}

		String s1 = amount.getText();
		String s2 = begin.getText();
		s1 = s1.trim();
		s2 = s2.trim();
		int a1 = 0, a2 = 0;
		int index = 0;

		if (s1.length() == 0) { // ��������Ϊ0������Ϊ�գ���ʾ�û�
			JOptionPane.showMessageDialog(ChoiceFrame.this, "����������", "����������ʾ",
					JOptionPane.WARNING_MESSAGE);
			amount.requestFocusInWindow();
			return;
		} else {
			a1 = getAmount(ss, sc);
			try {
				a2 = Integer.parseInt(s1); // �û��������������Ϊ�Ƿ�����
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(ChoiceFrame.this, "��������ȷ��������ֵ",
						"����������ʾ", JOptionPane.WARNING_MESSAGE);
				amount.requestFocusInWindow();
				return;
			}
			if (a2 > a1) { // �û��������ϰ������������е���������
				JOptionPane.showMessageDialog(ChoiceFrame.this,
						"�����������ֵ���ܳ�������е�������ֵ", "����������ʾ",
						JOptionPane.WARNING_MESSAGE);
				amount.requestFocusInWindow();
				return;
			}
		}
		if (rand.isSelected()) { // �����ʽ������ϰ��
			select = createQuestions(ss, sc, true, -1, a2);
		} else {
			if (s2.length() == 0) {
				JOptionPane.showMessageDialog(ChoiceFrame.this, "��������ʼ���",
						"��ʼ���������ʾ", JOptionPane.WARNING_MESSAGE);
				begin.requestFocusInWindow();
				return;
			}
			try {
				index = Integer.parseInt(s2);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(ChoiceFrame.this, "��������ȷ����ʼ���",
						"��ʼ���������ʾ", JOptionPane.WARNING_MESSAGE);
				begin.requestFocusInWindow();
				return;
			}
			if (index > a1) {
				JOptionPane.showMessageDialog(ChoiceFrame.this, "��ʼ��ų��������������",
						"��ʼ���������ʾ", JOptionPane.WARNING_MESSAGE);
				begin.requestFocusInWindow();
				return;
			}
			select = createQuestions(ss, sc, false, index, a2); // ˳��ʽ������ϰ��
		}
		/*
		 * ��������ϰ����select�����У������ϰ�⼯�ϲ�Ϊ�գ���ʼ��ϰ�� ���õ�ǰ��ϰ����Ϊ1�� ͬʱ��ʾ����ϰ�⡣�����ϰ�⼯��Ϊ�գ�
		 * �������Ļ�������ñ��Ϊ0
		 */
		if (select.size() > 0) {
			current = 1;
			displayQuestion(select.get(current - 1));
		} else {
			qcontent.setText("");
			pa.removeAll();
			pm.validate();
			current = 0;
		}
	}

	public void processNextClick() { // �û������һ���ⰴť
		if (select != null && select.size() >= current + 1) { // ���������һ���⣬����ʾ
			current++;
			displayQuestion(select.get(current - 1)); // �����Ŵ�1��ʼ������0
		}
	}

	public void processPrevClick() { // �û������һ���ⰴť
		if (select != null && current - 1 >= 1) {
			current--;
			displayQuestion(select.get(current - 1));
		}
	}

	public void processSubmitClick() { // �û��������ť
		if (select != null && current != 0) {
			int right = 0; // ���Ե���������
			for (int i = 0; i < select.size(); i++) {
				/*
				 * ����𰸺��û���ѡ����һ���ģ����ۼӼ����� ��Ҫע�����ѡ����Ĵ𰸵ı��˳���Ǵ�A��B����C��
				 * ����ĳ����Ĵ���AC�����������ļ���д��CA���Ǵ���ġ�
				 */
				if (select.get(i).getAnswer().equals(select.get(i).getChoice())) {
					right++;
				}
			}
			double d = 1.0 * right / select.size() * 100.0;
			d = d + 0.5; // ��������
			int d2 = (int) d;
			JOptionPane.showMessageDialog(this, "������" + right + "���⣬��ȷ����" + d2
					+ "%", "��ϰ���", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void main(String[] args) {
		new ChoiceFrame();
	}
}
