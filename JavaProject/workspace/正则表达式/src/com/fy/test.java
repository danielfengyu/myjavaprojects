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
         
        Thread demo = new Thread(he,"�߳�");//�ڶ����������߳�����(�Զ���)           
        demo.start();//����start�������ǵ��ø÷���ֻ��׼���̲߳�������������
        demo.join(); //ǿ��ִ��demo,ֻ�е�demo�߳�ִ�н���֮�����̲߳��ܼ�����ǰ���߳�ִ��--�൱�������߳��������demo�����̣߳� ʹ�첽ִ���߳�תΪͬ��ִ��
        //demo.start();//join()������start()ǰ����ʾ�Ľ�����ԵĲ�һ��  ����֤��ֻ�е�start()������ ������ȷִ��join���� 
        for(int i=0;i<50;++i)
        {     
             System.out.println(threadName +"�߳�ִ��-->"+i);           
        }         
}
 
}  
