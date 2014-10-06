package cn.fengyu.wordbook.gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import cn.fengyu.wordbook.bean.JdbcBean;
import cn.fengyu.wordbook.controller.DialogAction;
import cn.fengyu.wordbook.controller.DialogActionApdater;
import cn.fengyu.wordbook.controller.DialogActionEnsure;
import cn.fengyu.wordbook.jdbc.JdbcHelper;
import cn.fengyu.wordbook.windows.ConcreteFirstPageWindowFactory;
import cn.fengyu.wordbook.windows.IWindowFactory;

@SuppressWarnings("serial")
public class WordListIELTS extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblImag;
	private JPanel panelImage;
	private JdbcHelper jh=new JdbcHelper();
	private IWindowFactory firstPageWindowFactory=new ConcreteFirstPageWindowFactory();

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "static-access"})
	public WordListIELTS() {
		JdbcBean jdbcBean=JdbcBean.getInstance();
		 Connection con=null;
		setTitle("IELTS���ʱ�");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 463);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u64CD\u4F5C");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u8FD4\u56DE");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aet) {
				setVisible(false);
            	EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					firstPageWindowFactory.getFrame().setVisible(true);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		});
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogActionEnsure dae = new DialogActionEnsure();
				DialogAction da=new DialogActionApdater(dae);
				da.exitSystem();
			}
		});
		menu.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 395, 378);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 395, 374);
		panel.add(scrollPane);
		panelImage = new JPanel();
        panelImage.setBounds(405, 0, 385, 367);
        contentPane.add(panelImage);
        panelImage.setBorder(new TitledBorder(null, "ͼƬ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelImage.setLayout(null);       
       try   { 
    	   Class.forName(jdbcBean.JDriver);
	        con=DriverManager.getConnection(jdbcBean.connectDB,jdbcBean.username,jdbcBean.password);
           Statement   stmt   =   con.createStatement(); 
           String   sqlCode   =   "select * from Word where property='IELTS'";//ֻ��ȡ�����ֶ� 
           ResultSet   rs   =   stmt.executeQuery(sqlCode); 
           @SuppressWarnings("rawtypes")
		Vector   vect   =   new   Vector();//���ڴ�����ݼ�¼ 
           vect.removeAllElements();//��ʼ���������� 
           while(rs.next())   {//���ζ�ȡ���ݽ���� 
               @SuppressWarnings("rawtypes")
			Vector   rec_vector=new   Vector();//�ӽ������ȡ���ݷ�������rec_vector�� 
               rec_vector.addElement(rs.getString(1)); 
               rec_vector.addElement(rs.getString(2)); 
               rec_vector.addElement(rs.getString(6));
               vect.addElement(rec_vector);//����rec_vector��������vect�� 
           } 
           //���б��� 
           String[]   titleStr   =   { "����", "����", "����"};//���б����趨 
           @SuppressWarnings("rawtypes")
           Vector   title   =   new   Vector();//���ڴ�ű��б��� 
           title.removeAllElements(); 
           for(int   i=0;i <titleStr.length;i++)   { 
               title.addElement(titleStr[i]); 
           } 
           //���ɱ� 
           table   =   new   JTable(vect,title);
           scrollPane.setViewportView(table);
           table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
           
           
           table.addMouseListener(new MouseAdapter() {
           	@Override
           	public void mouseClicked(MouseEvent e) {
           			//if(e.getClickCount()==2){
		           			int row =((JTable)e.getSource()).rowAtPoint(e.getPoint()); //�����λ�� 
		                    int  col=((JTable)e.getSource()).columnAtPoint(e.getPoint()); //�����λ��
		                    String cellVal=(String)(table.getValueAt(row,col)); //��õ����Ԫ������
		                    String imagePath=jh.getImagePath(cellVal);
		                    ImageIcon image = new ImageIcon(imagePath); 
		                    image.setImage(image.getImage().getScaledInstance(380,340,Image.SCALE_DEFAULT));lblImag = new JLabel();
		                    lblImag.setBounds(0, 0, 385, 367);
		                    panelImage.add(lblImag);
		                    lblImag.setIcon(image);
		                    lblImag.setOpaque(true);
           			}
                    
           	//}
           });

           //�ͷ���Դ 
           rs.close(); 
           stmt.close(); 
           con.close();
       } 
       catch(Exception   e)   { 
           System.out.println( "GetTableFromDB   error: "   +   e); 
       } 
	}


}
