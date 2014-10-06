import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class ChatClient extends Frame {
	TextArea ta = new TextArea();
	TextField tf = new TextField();
	Button b = new Button("Send");
	boolean connected = false;
	Socket s = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	String username = "";

	public ChatClient(String hostname) {
		Font font = new Font(Font.DIALOG, Font.PLAIN, 14);
		ta.setFont(font);
		tf.setFont(font);
		ta.setEditable(false);
		add(ta);
		Panel p = new Panel();

		tf.setPreferredSize(new Dimension(400, 30));
		b.setPreferredSize(new Dimension(50, 30));
		p.add(tf);
		p.add(b);
		
		add(p, BorderLayout.SOUTH);
		setSize(500, 300);
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int) (d.getWidth() - 500) / 2,
				(int) (d.getHeight() - 300) / 2);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		connect(hostname, 1234);

		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				send();
			}
		};


		tf.addActionListener(al);
		b.addActionListener(al);

		new Thread() {
			public void run() {
				while(true) {
					if(connected) {
						try {
							String message = dis.readUTF();
							ta.append(message + "\r\n");
						} catch (Exception e) {
							ta.append(e.getMessage());
						}		
					}
					else {
						break;
					}
				}
				
			}

		}.start();

		if (connected) {
			try {
				//用户名称不能重复！
				while (username.length() == 0) {
					username = javax.swing.JOptionPane
							.showInputDialog("Please input your name");
					username = username.trim();
				}

				dos.writeInt(2);
				dos.writeUTF(username);
				dos.flush();
			} catch (Exception e) {
				ta.append(e.getMessage());
			}
		}
		
		tf.requestFocus();


	}

	public void connect(String host, int port) {
		try {
			s = new Socket(host, port);
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());

			connected = true;

		} catch (Exception e) {
			ta.append(e.getMessage());
			connected = false;
		}
	}

	public void send() {
		String message = tf.getText();
		message = message.trim();
		if (message.length() == 0) {
			return;
		}
		tf.setText("");
		tf.requestFocus();

		if (connected) {
			try {
				dos.writeInt(1);
				dos.writeUTF(message);
				dos.flush();
			} catch (Exception e) {
				ta.append(e.getMessage());
			}
		}

	}

	public static void main(String[] args) {
		new ChatClient(args[0]);
	}
}
