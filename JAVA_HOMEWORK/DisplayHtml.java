import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;

public class DisplayHtml 
{
	//���´�����ʾ��ҳ
	public static void showNetPage(String str)
	{
		JEditorPane jep = new JEditorPane();
		jep.setEditable(false);
		jep.addHyperlinkListener(new LinkFollower(jep));
		try
		{
			jep.setPage(str);
		}
		catch(IOException e)
		{
			jep.setContentType("text/html");
			jep.setText("<html>Could not load "+ str + " </html>");
		}
		JScrollPane jscrollp = new JScrollPane(jep);
		JFrame f = new JFrame("��������ѧ����ʾ�������ѧԺ��ҳ");
		f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		f.setContentPane(jscrollp);
		f.setSize(600, 400);
		f.show();
	        }
	        public static void main(String[] args)
	        {
		String getURL = "http://ssdut.dlut.edu.cn/";
		showNetPage(getURL);
	        }
	}
//�ࣺ�¿�����ҳ������Ӧ���ӵ���¼�
class LinkFollower implements HyperlinkListener
{
    private JEditorPane jep;	
    public LinkFollower(JEditorPane jep)
    {
	this.jep = jep;
    }	
  //�����Ӹ����¼��Ĵ���
    public void hyperlinkUpdate(HyperlinkEvent evt)
   {
       //�ж��Ƿ��Ǽ����¼�
       if(evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
      {
    	   try
   		{
                     		//��ʾ�µ���ַ
   			jep.setPage(evt.getURL());
   		}
   		catch(Exception e)
   		{
   			System.out.println(e.getMessage());
   		}
   	    }
           }
   }
