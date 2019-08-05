
public class ConstructorTest {
	public static void main(String[] args) {
		EmployeeConstructorEnhance[] staff = new EmployeeConstructorEnhance[3];
		
		staff[0] = new EmployeeConstructorEnhance("Harry",40000);
		staff[1] = new EmployeeConstructorEnhance(60000);
		staff[2] = new EmployeeConstructorEnhance();
		
		for(EmployeeConstructorEnhance e:staff) {
			System.out.println("name = " + e.getName() +",id = " + e.getId() + ",salary=" + e.getSalary());
		}
	}
}
