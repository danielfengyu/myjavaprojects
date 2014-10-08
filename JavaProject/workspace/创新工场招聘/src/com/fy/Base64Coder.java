package com.fy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Base64Coder {
	
	    public final static char[] base64_alphabet 
	    	= new char[]{  //编码表
	            'A','B','C','D','E','F','G','H',
	            'I','J','K','L','M','N','O','P',
	            'Q','R','S','T','U','V','W','X',
	            'Y','Z','a','b','c','d','e','f',
	            'g','h','i','j','k','l','m','n',
	            'o','p','q','r','s','t','u','v',
	            'w','x','y','z','0','1','2','3',
	            '4','5','6','7','8','9','+','/',
	            '='  //
	    };  
	      
	    public static char[] base64_encode(byte[]data) { //编码函数   
	        int length = data.length;  
	        byte[] char_array_3 = new byte[]{0, 0, 0};  //
	        byte[] char_array_4 = new byte[]{'=','=','=','='};  //
	        String retContent = "";  
	        char[] Content = null;
	        int i = 0;  
	        int j = 0;  
	        int reversePos = 0;  
	        while(length > 0) {  
	            length--;  
	            char_array_3[i++] = data[reversePos++];  
	            if(i==3) { //移除了3个字节 
	            	// 转换字符
	                char_array_4[0] = (byte)((char_array_3[0] & 0xfc) >> 2);//取出第一个字符的前六位  
	                char_array_4[1] = (byte)(((char_array_3[0] & 0x03) << 4) | ((char_array_3[1] & 0xf0) >> 4));  
	              //将第一个字符的后位与第二个字符的前4位进行组合并找到对应的结果字符
	                char_array_4[2] = (byte)(((char_array_3[1] & 0x0f) << 2) | ((char_array_3[2] & 0xc0) >> 6));  
	              //将第二个字符的后4位与第三个字符的前2位组合并找出对应的结果字符
	                char_array_4[3] = (byte)(char_array_3[2] & 0x3f);  //取出第三个字符的后6位并找出结果字符
	                for(i = 0; (i <4) ; i++)  
	                    retContent += base64_alphabet[char_array_4[i]];  
	                i = 0;  
	            }  
	        }  
	          
	        // 处理最后的字符  
	          if (i > 0 )  
	          {  
	            for(j = i; j < 3; j++)  
	              char_array_3[j] = 0; // 补0 输入 
	  
	            char_array_4[0] = (byte)((char_array_3[0] & 0xfc) >> 2); // 右移 
	            char_array_4[1] = (byte)(((char_array_3[0] & 0x03) << 4) | ((char_array_3[1] & 0xf0) >> 4));  
	            char_array_4[2] = (byte)(((char_array_3[1] & 0x0f) << 2) | ((char_array_3[2] & 0xc0) >> 6));  
	            char_array_4[3] = (byte)(char_array_3[2] & 0x3f);  
	  
	            for (j = 0; (j < i + 1); j++)  
	                retContent += base64_alphabet[char_array_4[j]];  
	  
	            while((i++ < 3)) // 补‘=’输出  
	                retContent += '=';  
	  
	          }  
	          Content=retContent.toCharArray();
	        return Content;  
	    }  
	      
	    public static String decode(String enContent) {  
	        byte[] data = enContent.getBytes();  
	        int i = 0, j = 0, enCode = 0;  
	        int mLength = data.length;  
	        byte[] char_array_4 = new byte[4];  
	        byte[] char_array_3 = new byte[3];  
	        String retContent = "";  
	  
	        // 去除补齐的‘=’
	          while (mLength > 0 && (((char)data[enCode]) != '=') && isBase64((char)data[enCode]))   
	            {  
	              mLength--;  
	              char_array_4[i++] = data[enCode++];  
	              if (i ==4) {  
	              for (i = 0; i <4; i++)  
	                char_array_4[i] = findChar((char)char_array_4[i]);  
	  
	              char_array_3[0] = (byte)((char_array_4[0] << 2) + ((char_array_4[1] & 0x30) >> 4));  
	              char_array_3[1] = (byte)(((char_array_4[1] & 0xf) << 4) + ((char_array_4[2] & 0x3c) >> 2));  
	              char_array_3[2] = (byte)(((char_array_4[2] & 0x3) << 6) + char_array_4[3]);  
	  
	              for (i = 0; (i < 3); i++)  
	                  retContent += (char)char_array_3[i];  
	              i = 0;  
	            }  
	          }  
	  
	          // 处理最后的数据  
	          if (i > 0)   
	            {  
	            for (j = i; j <4; j++)  
	              char_array_4[j] = 0;  
	  
	            for (j = 0; j <4; j++)  
	              char_array_4[j] = findChar((char)char_array_4[j]);  
	  
	            char_array_3[0] = (byte)((char_array_4[0] << 2) + ((char_array_4[1] & 0x30) >> 4));  
	            //取出第一个字符对应base64表的十进制数的前6位与第二个字符对应base64表的十进制数的后2位进行组合
	            char_array_3[1] = (byte)(((char_array_4[1] & 0xf) << 4) + ((char_array_4[2] & 0x3c) >> 2)); 
	            //取出第二个字符对应base64表的十进制数的后4位与第三个字符对应bas464表的十进制数的后4位进行组合
	            char_array_3[2] = (byte)(((char_array_4[2] & 0x3) << 6) + char_array_4[3]);  
	         	//取出第三个字符对应base64表的十进制数的后2位与第4个字符进行组合
	            for (j = 0; (j < i - 1); j++)   
	                retContent += (char)char_array_3[j];  
	          }  
	  
	          return retContent;  
	    }  
	      
	    public static boolean isBase64(char c)   
	    {  
	        boolean base64 = false;  
	        for(int i=0; i<64; i++) {  
	            if( c == base64_alphabet[i]) {  
	                base64 = true;  
	                break;  
	            }  
	        }  
	      return base64;  
	    }  
	      
	    public static byte findChar(char x) {  
	        byte index = 64; // 65th char '='  
	        for(int i=0; i<64; i++) {  
	            if( x == base64_alphabet[i]) {  
	                index = (byte)i;  
	                break;  
	            }  
	        }  
	        return index;  
	    }  
	      
	    /** 
	     * <p> test data and result should like below output , RFC4648 Sample </p> 
	     *  BASE64("") = "" 
	     *  BASE64("f") = "Zg==" 
	     *  BASE64("fo") = "Zm8=" 
	     *  BASE64("foo") = "Zm9v" 
	     *  BASE64("foob") = "Zm9vYg==" 
	     *  BASE64("fooba") = "Zm9vYmE=" 
	     *  BASE64("foobar") = "Zm9vYmFy" 
	     * 
	     * 
	     * @param args 
	     * @throws IOException 
	     */  
	    public static void main(String[] args) throws IOException {  
	        // BASE64Encoder coder = new BASE64Encoder();  
	        // System.out.println(coder.encode("foobar".getBytes()));  
	          
	        System.out.println("#--------------encode---------------#");  
	        System.out.println(base64_encode("".getBytes()));  
	        System.out.println(base64_encode("f".getBytes()));  
	        System.out.println(base64_encode("fo".getBytes()));  
	        System.out.println(base64_encode("foo".getBytes()));  
	        System.out.println(base64_encode("foob".getBytes()));  
	        System.out.println(base64_encode("fooba".getBytes()));  
	        System.out.println(base64_encode("foobar".getBytes()));  
	        System.out.println(base64_encode("123456789sS{1}quot".getBytes()));
	        System.out.println("#--------------decode---------------#");  
	        System.out.println(decode(""));  
	        System.out.println(decode("Zg=="));  
	        System.out.println(decode("Zm8="));  
	        System.out.println(decode("Zm9v"));  
	        System.out.println(decode("Zm9vYg=="));  
	        System.out.println(decode("Zm9vYmE="));  
	        System.out.println(decode("Zm9vYmFy"));  
	        System.out.println(decode("MTIzNDU2Nzg5c1Mk"));  
	        BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
	        String input = br.readLine();
	        System.out.println(base64_encode(input.getBytes()));
	        String str=base64_encode(input.getBytes()).toString();
	        System.out.println(decode("ZmVuZ3l1"));
	    }  
	  
}  

