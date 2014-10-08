package com.fy;
/**
 * @author Daniel
 *
 */
public class ThreadFromRunable implements Runnable {  
	  
    //static int count = 10;  
    public void run() {  
        int count = 10;  
        System.out.println("\t#"+Thread.currentThread().getName()+" got count from " + count);  
        while(count > 0)  
        {  
            System.out.println("#"+Thread.currentThread().getName()+" : "+ count--);  
        }  
        System.out.println("#"+Thread.currentThread().getName()+" : exiting "+ count--);  
    } 
    
    public static void main(String[] args)  
    {  
        ThreadFromRunable tr = new ThreadFromRunable();  
        Thread thread = new Thread(tr,"A");  
        Thread thread2 = new Thread(tr, "B");  
          
        thread.start();  
        thread2.start();  
    }  
}  
