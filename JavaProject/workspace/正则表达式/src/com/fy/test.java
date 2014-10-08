package com.fy;
public class test {
	 
    /**
     * @param args
     */
         
   public class hello implements Runnable
    {
 
        @Override
        public void run() {
            // TODO Auto-generated method stub
             for (int i = 0; i < 3; i++) 
             { 
                   System.out.println(Thread.currentThread().getName()+i);            
             }
      
 }
         
         
    }
     
    public static void main(String[] args) throws InterruptedException {
        String threadName = Thread.currentThread().getName();    
        test test=new test();
        hello he=test.new hello();
         
        Thread demo = new Thread(he,"线程");//第二个参数是线程名称(自定义)           
        demo.start();//调用start方法但是调用该方法只是准备线程并不是马上启动
        demo.join(); //强制执行demo,只有当demo线程执行结束之后主线程才能继续当前主线程执行--相当于在主线程中添加了demo的子线程， 使异步执行线程转为同步执行
        //demo.start();//join()方法在start()前后显示的结果明显的不一样  可以证明只有当start()启动后 才能正确执行join（） 
        for(int i=0;i<50;++i)
        {     
             System.out.println(threadName +"线程执行-->"+i);           
        }         
}
 
}  
