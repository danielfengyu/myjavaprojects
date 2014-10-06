import java.awt.*;
import java.awt.event.*;
public class Paint2 extends Frame implements MouseListener, MouseMotionListener
{
    int[] xa = new int[100000];		//������й켣��
    int[] ya = new int[100000];
    int count = 0;					//ʵ�ʵ���������
	public static void main(String[] args) 	{	new Paint2();   }
    public Paint2() {
        setBackground(Color.blue);
        setForeground(Color.red);
        addMouseListener(this);
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
        xa[count] = -1; ya[count++] = -1;
    }
    public void mouseMoved(MouseEvent me) {}
    public void mouseDragged(MouseEvent me) {
        xa[count] = me.getX();  ya[count++] = me.getY();
        repaint();       //����ˢ�£�������ֱ�ӵ���paint��û�б�ҪƵ���ĵ���paint
    }
    public void update(Graphics g) {	//����ͼ��������������������
        paint(g);					//ֱ�ӵ���paint
    }
    public void paint(Graphics g) {	//�����ۻ��Ʒ���
        for(int i=0; i<count-1; i++) {
            if (xa[i]!=-1 && xa[i+1]!=-1)
            {
                g.drawLine(xa[i],ya[i],xa[i+1],ya[i+1]);
            }
        }
    }
}
