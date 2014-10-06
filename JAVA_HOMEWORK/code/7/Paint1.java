/*������Paint1.java��һ����ͼ�����ӣ������в����ʵĵط�����Ȼ����windows7����ϵͳ�ṩ�˻�������ݻָ����������ֲ�������*/
import java.awt.*;
import java.awt.event.*;
public class Paint1 extends Frame implements MouseListener, MouseMotionListener
{
	/* ������϶��켣�����������β�������϶�������¼���λ��������
	   ���ԣ���Ҫ�����ϴ�����϶��¼���λ����Ϣ�����Ժ͵�ǰ����϶��¼�
	   ��λ�ý��л��߲���  */
    int oldX = -1, oldY = -1;		//-1�ͱ�ʾ������
	public static void main(String[] args) 
	{
                new Paint1();
	}
    public Paint1() {	//���췽�������л�ͼ������һЩ��ʼ������
        setBackground(Color.blue);	
        setForeground(Color.yellow);
        addMouseListener(this);		//���ھ���Paint1������
        addMouseMotionListener(this);
        setSize(400,300);
        setVisible(true);
    	addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0); }});
    }

    public void mouseClicked(MouseEvent me) {}
    public void mouseEntered(MouseEvent me) {}
    public void mouseExited(MouseEvent me) {}
    public void mousePressed(MouseEvent me) {}
    public void mouseReleased(MouseEvent me) {
        oldX = -1; //������ɿ�����ô��ι켣��ֹͣ�滭�ˡ�
    }
    public void mouseMoved(MouseEvent me) {}
    public void mouseDragged(MouseEvent me) {
        int x = me.getX();  //�õ���������¼��ĵ�ʱλ����Ϣ
        int y = me.getY();
        if (oldX == -1)
        {	//��ʼ���ߣ�����켣�ߵ���ʼλ��
            oldX = x;   oldY = y;	
        } else {
        	Graphics g = getGraphics();		//��õ�ǰ����۶���
			//����һ������϶��¼���λ�ú͵�ǰ����¼���λ��֮�仭��
        	g.drawLine(oldX, oldY, x, y);		
        	oldX = x;   oldY = y;			//���浱ǰ������
		}
    }
}
