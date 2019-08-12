package timer;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimePrinter implements ActionListener{
	public void actionPerformed(ActionEvent event) {
		System.out.println("At the tone,the time is " + new Date());
//		Toolkit.getDefaultToolkit().beep();
	}
}
