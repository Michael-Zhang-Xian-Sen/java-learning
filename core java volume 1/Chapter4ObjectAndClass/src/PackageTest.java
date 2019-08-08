import static java.lang.System.*;

public class PackageTest {
	public static void main(String[] args) {
		com.horstmann.corejava.Employee harry = new com.horstmann.corejava.Employee("Harry Hacker",5000,1989,10,1);
		
		harry.raiseSalary(5);
		
		/**
		 * 此处由于import static ... 将System类加入进来，所以直接使用Out即可？
		 */
		out.println("name="+harry.getName()+",salary="+harry.getSalary());
	}
}

