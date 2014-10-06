import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;

public class DisplayHtml 
{
	//在新窗口显示网页
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
		JFrame f = new JFrame("大连理工大学国家示范性软件学院主页");
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
//类：新开的网页窗口响应链接点击事件
class LinkFollower implements HyperlinkListener
{
    private JEditorPane jep;	
    public LinkFollower(JEditorPane jep)
    {
	this.jep = jep;
    }	
  //超链接更新事件的处理
    public void hyperlinkUpdate(HyperlinkEvent evt)
   {
       //判断是否是激活事件
       if(evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
      {
    	   try
   		{
                     		//显示新的网址
   			jep.setPage(evt.getURL());
   		}
   		catch(Exception e)
   		{
   			System.out.println(e.getMessage());
   		}
   	    }
           }
   }
