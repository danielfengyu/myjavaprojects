package cn.fengyu.wordbook.bean;
/**
 * ���У����ݿ�ĸ������ַ����ӱ�����һ�������У���ʡ�ռ䣬������չ��
 * @author ����
 *
 */
public class JdbcBean {
	
	 public  static String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL���ݿ�����
	 public  static String connectDB="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=WordBook" ;//�����ַ���
	 public  String username="sa";
	 public  String password="dayingfengyu";
	 private static JdbcBean jdbcConnString;
	 private  JdbcBean() {
		// TODO Auto-generated constructor stub
		 super();
	} 
	 
	public  static JdbcBean getInstance() {
		if(jdbcConnString==null){
				jdbcConnString=new JdbcBean();
			}
			return jdbcConnString;
	}

}
