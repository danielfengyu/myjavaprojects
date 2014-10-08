package com.fy;
public class ThreadExtendsThread extends Thread {  
    public void run()  
    {  
        int count =10;  
        System.out.println("#"+Thread.currentThread().getName()+" got count from " + count);  
        while(count > 0)  
        {  
            System.out.println("{1}quot"+this.getName()+" : "+count--);  
        }  
        System.out.println("{1}quot"+this.getName()+" : existing count=" + count);
    }  
      
    public static void main(String[] args)  
    {
//    	ThreadExtendsThread thread =new ThreadExtendsThread();
//    	ThreadExtendsThread thread2 =new ThreadExtendsThread();
        Thread thread = new ThreadExtendsThread();  
        Thread thread2 = new ThreadExtendsThread();  
        thread.start();  
        thread2.start();  
    }  
   
}  
