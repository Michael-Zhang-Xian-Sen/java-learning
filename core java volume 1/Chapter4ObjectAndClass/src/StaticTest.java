public class StaticTest {
	public static void main(String[] args) {
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("TOM",40000);
		staff[1] = new Employee("Dick",60000);
		staff[2] = new Employee("Harry",65000);

		/**
		 * Ӧ����һ���ϸ߼���forѭ��
		 */
		for(Employee e:staff) {
			e.setId();
			System.out.println("name" + e.getName() + ",id=" + e.getId() + ",salary="+e.getSalary());
		}
		
		/**
		 * ͨ������þ�̬�����������ľ�̬��
		 */
		int n = Employee.getNextId();
		System.out.println("Next available id ="+n);
	}
}