import java.net.*;

public class DatagramServer extends Object
{
	public static String ReadRAS(String str)
	{
		int indexstart = str.indexOf(':');
		int indexend = str.indexOf("o");
		String Msg = "Server:" + 
				str.substring(indexstart+1,indexend+1);
		return Msg;
	        }	
	        public static void main(String[] args)
	        {
		try
		{
		   DatagramSocket mysock = new DatagramSocket(1719);
		   byte[] buf = new byte[1024];
		   DatagramPacket p = new DatagramPacket(buf,buf.length);
		   while(true)
		   {
			   mysock.receive(p);
			   System.out.println("RECEIVE:"+ new String(p.getData()).trim());
			   System.out.println(ReadRAS(new String(p.getData()).toString()));
			   mysock.send(p);
			   System.out.println("SEND:"+ new String(p.getData()).trim());
			             }
			         }
			         catch(Exception e)
			         {
			             System.out.println(e.getMessage());
			         }		
			      }
			   }
