import java.net.*;
import java.io.*;

public class DatagramClient extends Object
{	
	public static void main(String[] args)
	{
		try
		{
			DatagramSocket mysock = new DatagramSocket();
			byte[] buf = new byte[1024];
			String sendData = new String("Client:Hello");
			buf = sendData.getBytes();
			DatagramPacket p = new DatagramPacket(buf,buf.length,InetAddress.getLocalHost(),1719);
			while(true)
			{
				mysock.send(p);
				System.out.println("SEND:"+ new String(p.getData()).trim());
				mysock.receive(p);
				System.out.println("GET:"+ new String(p.getData()).trim());
			       }
			}
			catch(Exception e)
			{
			      System.out.println(e.getMessage());
			      }
			   }
			}
