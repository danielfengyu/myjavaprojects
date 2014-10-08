package com.fy;
public class test2 implements Runnable {
	public void run() {
	synchronized(this)
	{
		for(int i=0;i<100;i++)
		{
			System.out.println(Thread.currentThread().getName()
					+" synchronizedloop "+i);
		}
		
	}
		
	}
	public static void main(String args[])
	{
		test2 t1=new test2();
		Thread ta=new Thread(t1,"A");
		Thread tb=new Thread(t1,"B");
		ta.start();
		tb.start();
	}

}