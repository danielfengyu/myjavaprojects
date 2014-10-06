import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
class UseFchannel 
{
	public static void main(String[] args) 
	{
		try
		{
			String filename = "f.txt";
			FileInputStream input = new FileInputStream(filename);
			FileChannel channel = input.getChannel();
			int fileLength = (int)channel.size();
			MappedByteBuffer buffer = 	channel.map(FileChannel.MapMode.READ_ONLY, 0, fileLength);
			Charset charset = Charset.forName("ISO-8859-1");//
			CharsetDecoder decoder = charset.newDecoder();
			CharBuffer charBuffer = decoder.decode(buffer);
			System.out.println(charBuffer);
		}
		catch(Exception e)
		{
			System.out.println("Error:" + e.getMessage());
		}
	  }

	}
