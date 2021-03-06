public class Employee {
	private static int nextId = 1;	// 静态变量，属于类，所有实例共用一个。
	
	/**
	 * 为了不让外界随意改动属性，将实例域设置为private，并且通过设置专门的get方法来获取这些实例域的值，设置专门的set方法来为这些实例域赋值。
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
	 * 此处设置Id的方法非常巧妙。nextId可以用来生成所有雇员的Id且不会重复。
	 */
	public void setId() {
		this.id = nextId;
		nextId++;
	}
	
	public static int getNextId() {
		return nextId;
	}
	
	/**
	 * 在执行StaticTest时，该main方法永远不会被执行。
	 * @param args
	 */
	public static void main(String[] args) {
		Employee e = new Employee("Harry",50000);
		System.out.println(e.getName() + " " + e.getSalary());
	}
}