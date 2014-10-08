/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Base64 {
   public static byte[] decode(byte[] dest)
   {
       int l1=dest.length;//ԭ�ֽ�����dest����
       int l2;//  ת������ֽ�����ĳ���
       int teamCount; //��3���ֽ�Ϊһ��ķ�����Ŀ
       if(l1%3==0)
       {
          teamCount=l1/3;
           l2=teamCount*4;
       }
       else
       {
           teamCount=l1/3+1;
           l2=teamCount*4;
       }
       /*ʵ�ַ���*/
       byte[] sourse=new byte[l2];  //����֮������ַ�����
       for(int i=0;i<l2;i++)
       {
            if(i<l1)
                sourse[i]=dest[i];
            else
                sourse[i]=0;
       }
       /*ת������*/
       
       byte b1,b2,b3 ;
       byte t1,t2,t3,t4,temp;
       for(int i=0;i<teamCount;i++)
       { 
           b1= dest[3*i];
           t1 = (byte)(b1 >> 2);
           sourse[4*i]=t1;

           if(3*i+1>l1-1)
               break;
           b2=dest[3*i+1];
           temp=(byte) (b1 << 6);
           temp=(byte) (temp >> 2);
           t2=(byte) ((b2 >> 4) + temp);
           sourse[4*i+1]=t2;

           if(3*i+2>l1-1)
               break;
           b3=dest[3*i+2];
           temp=(byte) (b2 << 4);
           temp= (byte) (temp >> 2);
           t3=(byte) (temp + (b3 >> 6));
           sourse[4*i+2]=t3;

           if(3*i+3>l1-1)
               break;
           temp=(byte) (b3 << 2);
           t4=(byte) (temp >> 2);
           sourse[4*i+3]=t4;
       }
       return sourse;
   }
   public static char[] encode(byte[] source)
   {
       int l1=source.length;//ԭ�ֽ����鳤��
       int l2;//  ת������ֽ�����ĳ���
       int teamCount; //��4���ֽ�Ϊһ��ķ�����Ŀ
       teamCount=l1/4;
       int j=0;
       l2=teamCount*3-j;
       /*ʵ�ַ���*/
       
       char[] dest=new char[l2];   //����֮������ַ�����

       /*ת������*/
       char b1,b2,b3 ;
       byte t1,t2,t3,t4,temp;
       for(int i=0;i<teamCount;i++)
       {
           t1=source[4*i];
           t2=source[4*i+1];
           t3=source[4*i+2];
           t4=source[4*i+3];

           b3=(char) ((t3 << 6 )+ t4);
           dest[3*i+2]=b3;

           b2=(char) ((t3 >> 2) + (t2 << 4));
           dest[3*i+1]=b2;

           b1=(char) ((t1 << 2) + (t2 >> 4));
           dest[3*i]=b1;
       }
       return dest;
   }
   public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] source=new byte[8];
		source="fe".getBytes();
		System.out.print(encode(source));
	}

}
