public class Employee {
	private static int nextId = 1;	// ��̬�����������࣬����ʵ������һ����
	
	/**
	 * Ϊ�˲����������Ķ����ԣ���ʵ��������Ϊprivate������ͨ������ר�ŵ�get��������ȡ��Щʵ�����ֵ������ר�ŵ�set������Ϊ��Щʵ����ֵ��
	 */
	private String name;
	private double salary;
	private int id;
	
	public Employee(String n, double s) {
		name = n;
		salary = s;
		id = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public int getId() {
		return id;
	}
	
	/**
	 * �˴�����Id�ķ����ǳ����nextId���������������й�Ա��Id�Ҳ����ظ���
	 */
	public void setId() {
		this.id = nextId;
		nextId++;
	}
	
	public static int getNextId() {
		return nextId;
	}
	
	/**
	 * ��ִ��StaticTestʱ����main������Զ���ᱻִ�С�
	 * @param args
	 */
	public static void main(String[] args) {
		Employee e = new Employee("Harry",50000);
		System.out.println(e.getName() + " " + e.getSalary());
	}
}