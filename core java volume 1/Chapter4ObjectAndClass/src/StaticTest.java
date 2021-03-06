public class StaticTest {
	public static void main(String[] args) {
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("TOM",40000);
		staff[1] = new Employee("Dick",60000);
		staff[2] = new Employee("Harry",65000);

		/**
		 * 应用了一个较高级的for循环
		 */
		for(Employee e:staff) {
			e.setId();
			System.out.println("name" + e.getName() + ",id=" + e.getId() + ",salary="+e.getSalary());
		}
		
		/**
		 * 通过类调用静态方法，获得类的静态域。
		 */
		int n = Employee.getNextId();
		System.out.println("Next available id ="+n);
	}
}
