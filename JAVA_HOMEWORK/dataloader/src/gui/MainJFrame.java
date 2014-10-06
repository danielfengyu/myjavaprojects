//������GUI��ʾ�������MainJFrame.java�ļ�
package gui;

import java.awt.*;
import java.util.*;
import base.*;
import javax.swing.*;
import javax.swing.table.*;

import org.jfree.chart.*;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.*;
import org.jfree.data.category.*;
import org.jfree.data.general.*;
import org.jfree.ui.RectangleEdge;

public class MainJFrame extends JFrame {
	JTabbedPane jTabbedPane = null; // ѡ����
	JScrollPane jscrollPane = null;
	JTable jTable = null; // Swing������

	public MainJFrame(ArrayList<Student> model) {
		jTable = new JTable(new MyTableModel(model)); // ����ģ�ʹ���UI
		jTable.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12)); // ��������

		jTable.setFillsViewportHeight(true); // �߶Ⱥ͹�������ĸ߶�һ��
		// �����п�
		jTable.getColumnModel().getColumn(0).setPreferredWidth(100);
		jTable.getColumnModel().getColumn(2).setPreferredWidth(60);
		jTable.getColumnModel().getColumn(3).setPreferredWidth(170);
		// �����и�
		jTable.setRowHeight(22);
		jscrollPane = new JScrollPane(jTable);
		// ���ù�������
		jscrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jscrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		// ����һ��ѡ����
		jTabbedPane = new JTabbedPane();
		// ���һ��ѡ�������ΪTable
		jTabbedPane.add("Table", jscrollPane);

		// ͳ�Ƴɼ��ֲ�����ͬ�������������
		int l1 = 0, l2 = 0, l3 = 0, l4 = 0, l5 = 0;
		int sum = 0;
		for (int i = 0; i < model.size(); i++) {
			Student s = model.get(i);
			sum += s.getJava();
			if (s.getJava() < 60) { // ͳ��0---59�������ѧ������
				l1++;
			} else if (s.getJava() < 70) { // ͳ��60---69�������ѧ������
				l2++;
			} else if (s.getJava() < 80) { // ͳ��70---79�������ѧ������
				l3++;
			} else if (s.getJava() < 90) { // ͳ��80---89�������ѧ������
				l4++;
			} else {
				l5++; // ͳ��90---100�������ѧ������
			}
		}
		int avg = sum / model.size(); // ����ƽ���ɼ�
		// �����Ǳ�״ͼ�����ɴ���
		DefaultPieDataset ds1 = new DefaultPieDataset(); // ʹ�ñ�״ͼ����ģ��
		ds1.setValue("0--59", new Integer(l1)); // ����ģ�����ݣ�section����Ӧֵ
		ds1.setValue("60--69", new Integer(l2));
		ds1.setValue("70--79", new Integer(l3));
		ds1.setValue("80--89", new Integer(l4));
		ds1.setValue("90--100", new Integer(l5));

		PiePlot pp = new PiePlot(ds1); // ����״ͼ
		pp.setIgnoreZeroValues(true);
		// ����secion��ǩ�����ݣ�
		// {0}��ʾsection����{1}��ʾsection��ֵ��{2}��ʾ�ٷֱȡ�
		pp.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({2})"));
		// ����ͼ�����ݼ���ʽ��
		// {0}��ʾsection����{1}��ʾsection��ֵ��{2}��ʾ�ٷֱȡ�
		pp.setLegendLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}:({1}��)"));
		pp.setLabelFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		// ���ڲ�����������֣�����Բ�����������õ�������ı�����С
		pp.setExplodePercent("0--59", 0.1);

		JFreeChart chart1 = new JFreeChart("�ɼ��ֲ�(ƽ���֣�" + avg + ")",
				JFreeChart.DEFAULT_TITLE_FONT, pp, true);
		// ����һ����壬��ͳ��ͼ
		ChartPanel panel1 = new ChartPanel(chart1);
		// ��ӵ�ѡ��У�����ΪPie Chart
		jTabbedPane.add("Pie Chart", panel1);

		// ��������״ͼ�����ɴ��룬�ȴ���ģ�����ݼ�
		DefaultCategoryDataset ds2 = new DefaultCategoryDataset();
		// ͳ����Ů���ڸ��������ε�����
		int f1 = 0, f2 = 0, f3 = 0, f4 = 0, f5 = 0; // Ů������ͳ�Ʊ���
		int m1 = 0, m2 = 0, m3 = 0, m4 = 0, m5 = 0; // ��������ͳ�Ʊ���
		for (int i = 0; i < model.size(); i++) {
			Student s = model.get(i);
			if (s.getJava() < 60) {
				if (s.getGender()) {
					m1++;
				} else {
					f1++;
				}
			} else if (s.getJava() < 70) {
				if (s.getGender()) {
					m2++;
				} else {
					f2++;
				}
			} else if (s.getJava() < 80) {
				if (s.getGender()) {
					m3++;
				} else {
					f3++;
				}
			} else if (s.getJava() < 90) {
				if (s.getGender()) {
					m4++;
				} else {
					f4++;
				}
			} else {
				if (s.getGender()) {
					m5++;
				} else {
					f5++;
				}
			}
		}
		ds2.addValue(f1, "Ů", "0--59");
		ds2.addValue(m1, "��", "0--59");
		ds2.addValue(f2, "Ů", "60--69");
		ds2.addValue(m2, "��", "60--69");
		ds2.addValue(f3, "Ů", "70--79");
		ds2.addValue(m3, "��", "70--79");
		ds2.addValue(f4, "Ů", "80--89");
		ds2.addValue(m4, "��", "80--89");
		ds2.addValue(f5, "Ů", "90--100");
		ds2.addValue(m5, "��", "90--100");
		// ֱ�Ӳ���3ά��״ͼ
		JFreeChart chart2 = ChartFactory.createBarChart3D("Java�ɼ�ͳ�Ʒ���ͼ��",
				"�ɼ��ֲ�", "����", ds2, PlotOrientation.VERTICAL, true, true, false);
		chart2.setBackgroundPaint(Color.white);

		// �õ���ͼ���󣬽�����������
		CategoryPlot cp = chart2.getCategoryPlot();
		cp.setBackgroundPaint(Color.lightGray); // ͼ��������ʾ���ֱ���ɫ
		cp.setDomainGridlinePaint(Color.white); // �����������߰�ɫ
		cp.setDomainGridlinesVisible(true); // ������ɼ�
		cp.setRangeGridlinePaint(Color.white); // �����������߰�ɫ
		cp.setRangeGridlinesVisible(true); // ������ɼ�
		// ���ñ�������
		chart2.getTitle().setFont(JFreeChart.DEFAULT_TITLE_FONT);

		Font font2 = new Font("΢���ź�", 10, 16); // �趨���塢���͡��ֺ�
		cp.getDomainAxis().setLabelFont(font2); // �൱�ں�������ΪX��
		cp.getRangeAxis().setLabelFont(font2); // �൱���������ΪY��

		// ����ͼ������
		Font font3 = new Font("΢���ź�", Font.BOLD, 16); // �趨���塢���͡��ֺ�
		chart2.getLegend().setItemFont(font3);
		chart2.getLegend().setPosition(RectangleEdge.TOP); // ͼ������״ͼ���Ϸ�

		// ������״ͼ����Ⱦ����
		BarRenderer3D renderer = (BarRenderer3D) cp.getRenderer();
		renderer.setItemMargin(0.1); // ������֮����
		renderer.setSeriesPaint(0, Color.red); // ����������ɫ
		renderer.setSeriesPaint(1, Color.green);
		// ������壬����ӵ�ѡ���
		ChartPanel panel2 = new ChartPanel(chart2);
		jTabbedPane.add("Bar Chart", panel2);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(jTabbedPane); // ���ѡ���������
		// ������ʾ���ھ�����Ļ����λ��
		Dimension sd = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((sd.width - 600) / 2, (sd.height - 400) / 2);
		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}
}
