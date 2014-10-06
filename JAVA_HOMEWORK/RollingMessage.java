import java.awt.*;
import java.awt.color.*;
import java.awt.font.*;
import java.awt.Graphics;
public class RollingMessage extends java.applet.Applet implements Runnable{
	Thread runThread;
	String s="欢迎学习java web 应用！";
	int s_length=s.length();
	int x_character=0;
	Font wordFont=new Font("楷体_GB2312",Font.BOLD ,30);
	public void start(){
		if(runThread==null){
			runThread=new Thread(this);
			runThread.start();
		}
	}
	public void stop(){
		
		if(runThread!=null)
		{
			runThread.stop();
			runThread=null;
		}
	}
	public void run()
	{
		
		while(true){
			if(x_character++>s_length)
				x_character=0;
			repaint();
			try{
				Thread.sleep(300);
				
			}catch(InterruptedException e){
				
			}
		}
	}
	public void paint(Graphics g){
		g.setFont(wordFont);
		g.setColor(Color.blue);
		g.drawString(s.substring(0,x_charater), 8, 50);
	}
	public static void main(String args[])
	{
		Frame f = new Frame("动画程序");
		RollingMessage drawTest=new RollingMessage();
		drawTest.start();
		f.add("Center",drawTest);
		f.resize(400,100);
		f.show();
	}
	
}