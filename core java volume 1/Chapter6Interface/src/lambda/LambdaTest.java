package lambda;

import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class LambdaTest {
	public static void main(String[] args) {
		String[] planets = new String[] {"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};
		System.out.println(Arrays.toString(planets));
		System.out.println("Sorted in dictionary order:");
		Arrays.sort(planets);
		System.out.println(Arrays.toString(planets));
		System.out.println("Sorted by length:");
		Arrays.sort(planets,(first,second)->first.length() - second.length());	// 此处使用lambda表达式。其中first和second的参数可以推断得出，故可以不指明参数的类型。
		System.out.println(Arrays.toString(planets));
		
		Timer t = new Timer(1000,event->System.out.println("The time is"+new Date()));	// 此处使用lambda表达式.类似(ActionEvent event)->...
		t.start();
		
		JOptionPane.showMessageDialog(null, "Quit program");
		System.exit(0);
	}
}
