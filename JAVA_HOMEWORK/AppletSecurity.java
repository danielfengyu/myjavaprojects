import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;

public class AppletSecurity extends Applet 
{
	TextField fileNameField;
	TextArea fileArea;
	public void init() 
	{
		Label lblName=new Label("�ļ�����");
		Label lblContext = new Label("�ļ����ݣ�");
		fileNameField=new TextField(35);
		fileNameField.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		loadFile(fileNameField.getText());
		}});
		fileArea=new TextArea(10,35);
		add(lblName);
		add(fileNameField);
		add(lblContext);
		add(fileArea);	
	}
	public void loadFile(String fileName)
	{
		try
		{
			BufferedReader reader=new BufferedReader(new FileReader(fileName));
			String context = new String();
			while((context = reader.readLine())!=null)
			{
				fileArea.append(context + "\n");
			}
			reader.close();
			}
			catch(IOException ie)
			{
				fileArea.append("IO����" + ie.getMessage());
			}
		catch(SecurityException se)
		{
		      fileArea.append("��ȫ���ʴ���" + se.getMessage());
		}
	      }
	}
