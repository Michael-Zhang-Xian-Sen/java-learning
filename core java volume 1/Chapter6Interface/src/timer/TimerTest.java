package timer;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerTest {
	public static void main(String[] args) {
		ActionListener listener = new TimePrinter();
		
		Timer t = new Timer(10000, listener);	// ����һ����ʱ��
		t.start();	// ������ʱ��
		
		JOptionPane.showMessageDialog(null, "Quit program?");	// ��ʾһ������һ����Ϣ��OK��ť�ĶԻ���
		System.exit(0);
	}
}
