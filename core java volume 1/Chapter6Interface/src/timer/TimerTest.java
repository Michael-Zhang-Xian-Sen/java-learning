package timer;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerTest {
	public static void main(String[] args) {
		ActionListener listener = new TimePrinter();
		
		Timer t = new Timer(10000, listener);	// 构造一个定时器
		t.start();	// 启动定时器
		
		JOptionPane.showMessageDialog(null, "Quit program?");	// 显示一个包含一条消息和OK按钮的对话框。
		System.exit(0);
	}
}
