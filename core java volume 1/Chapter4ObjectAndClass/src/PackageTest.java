import static java.lang.System.*;

public class PackageTest {
	public static void main(String[] args) {
		com.horstmann.corejava.Employee harry = new com.horstmann.corejava.Employee("Harry Hacker",5000,1989,10,1);
		
		harry.raiseSalary(5);
		
		/**
		 * �˴�����import static ... ��System��������������ֱ��ʹ��Out���ɣ�
		 */
		out.println("name="+harry.getName()+",salary="+harry.getSalary());
	}
}