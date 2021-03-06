import javax.swing.JInternalFrame;

public class MyInternalFrame extends JInternalFrame {
	static int openFrameCount = 0;
	static final int xOffset = 30, yOffset = 30;

	public MyInternalFrame(String title) {
		super(title + "  " + (++openFrameCount), true, // resizable
				true, // closable
				true, // maximizable
				true);// iconifiable
		setSize(300, 300);
		setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
		setVisible(true);
	}
}
