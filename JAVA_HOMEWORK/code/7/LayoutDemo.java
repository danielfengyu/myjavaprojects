import java.awt.*;
import java.awt.event.*;
public class LayoutDemo extends Frame {		//�̳д�����
	Button b1 = new Button("FlowLayout");	//�а�ť�����Ա
	List list = new List();					//���б������Ա
	CheckboxGroup g = new CheckboxGroup();  //��ѡ��ť�����롱��CheckboxGroup
	Checkbox[] cb = new Checkbox[4];		//�;��е�ѡ��ť��Ч���ˡ�

	FlowLayout fl = new FlowLayout();		
	BorderLayout bl = new BorderLayout();	
	GridLayout gl = new GridLayout(2, 2);		//���񲼾֣�2��2��
	CardLayout cl = new CardLayout();

	Panel p = new Panel() {					//ѡ���������Ϊ�м�����
		public Dimension getPreferredSize() {	//����4����ѡ��ť
			return new Dimension(90, 90);	//Ϊ����������ȳߴ�
		}
	};
	public LayoutDemo() {
		setLayout(bl);						//��ѡ��BorderLayout
		cb[0] = new Checkbox("FlowLayout", false, g);
		cb[1] = new Checkbox("BorderLayout", true, g);
		cb[2] = new Checkbox("GridLayout", false, g);
		cb[3] = new Checkbox("CardLayout", false, g);
		list.add("FlowLayout");
		list.add("BorderLayout");
		list.add("GridLayout");
		list.add("CardLayout");
		list.select(1);			//Ĭ�ϲ���BorderLayout
		p.add(cb[0]);
		p.add(cb[1]);
		p.add(cb[2]);
		p.add(cb[3]);
		p.setLayout(new GridLayout(4, 1));	//���Ĳ���Ϊ4��1��
		ItemListener il = new ItemListener() {	//ItemEvent�¼���Ӧ�����ڽӿ�
			public void itemStateChanged(ItemEvent ie) {
				Object source = ie.getSource();
				if (source instanceof List) {	//����¼�Դ��List
					int index = ((Integer) ie.getItem()).intValue();
					cb[index].setState(true);	//ʵ��List��Checkbox����Ч��
					changeLayout(list.getItem(index));
				} else if (source instanceof Checkbox) { //����¼�Դ��Checkbox
					for(int i=0;i<cb.length;i++) { //ʵ��List��Checkbox����Ч��
						if(source == cb[i]) { list.select(i); break; }
					}
					changeLayout((String) ie.getItem()); //������������	
				}
			}
		};
		list.addItemListener(il);		//ΪList����ע�����ڶ���
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				changeLayout("FlowLayout");	//���°�ť���л�����FlowLayout
				cb[0].setState(true);
				list.select(0);
			}
		});
		add(b1, BorderLayout.NORTH);	//����������������������BorderLayout
		add(list, BorderLayout.CENTER);	 //���Ե������add����������ָ����ӵ�
		add(p, BorderLayout.SOUTH);	//�����ͬʱ��ָ������Ĳ�����Ϣ
		cb[0].addItemListener(il);		//Ϊ��4����ѡ��ťע������
		cb[1].addItemListener(il);
		cb[2].addItemListener(il);
		cb[3].addItemListener(il);
		/* Frame��������WindowEvent�¼�����Ӧ�����¼�����ΪΪ�رմ��ڣ�
	 	 ���ڹرգ���С������󻯣��򿪵ȵȣ���Ӧ�����ڽӿ�ΪWindowListener��
   		 ����WindowListener�ӿ��е��¼��������ܶ࣬�����ṩ������������
		 ʵ������ӿڣ���Ȼʵ�ַ������ǿյģ�ֻ�Ǽ̳к󸲸�ĳ����Ҫʵ�ֵ�
		 �����Ϳ����ˡ������˱�̣��������ѡ��ʵ��WindowListener�ӿڵĻ���
		 ��Ҫʵ�ֽӿ��е�7��������*/
		addWindowListener(new WindowAdapter() {	//������ṩ�����䣬��
			public void windowClosing(WindowEvent we) { //������ڵĹرհ�ťҲ
				System.exit(0);					//�����˳���
			}
		});
		setSize(350, 250);			//���ô��ڵĴ�С
		setVisible(true);			//���ô��ڵ���ʾ״̬
	}
	public void changeLayout(final String layout) {
		new Thread() {		//��������һ���߳���ִ�в��ֵ��л���
			public void run() {
				if (layout.equals("FlowLayout")) {
					setLayout(fl);
				} else if (layout.equals("CardLayout")) {
					setLayout(cl);
				} else if (layout.equals("BorderLayout")) {
					setLayout(bl);
				} else if (layout.equals("GridLayout")) {
					setLayout(gl);
				}
				doLayout();		//�����˲��֣�������Ҫ���²��������ڵ����
			}
		}.start();
	}
	public static void main(String[] args) {
		new LayoutDemo();		
	}
}
