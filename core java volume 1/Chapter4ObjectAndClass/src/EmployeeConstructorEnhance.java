import java.util.Random;

public class EmployeeConstructorEnhance {
	private static int nextId = 1;	// 静态变量，属于类，所有实例共用一个。

	private String name = "";
	private double salary;
	private int id;
	
	/**
	 *  静态域初始化块。初始化nextId，在10000以内随机取一个整数值。
	 */
	static {
		Random generator = new Random();
		nextId = generator.nextInt(10000);
	}
	
	/**
	 * 实例域初始化块
	 */
	{
		id = nextId;
		nextId++;
	}
	
	
	public EmployeeConstructorEnhance(String n, double s) {
		name = n;
		salary = s;
	}
	
	/**
	 * 在该构造器的内容部，借助两参数构造器进行构造。
	 * @param s
	 */
	public EmployeeConstructorEnhance(double s) {
		this("Employee #"+nextId,s);
	}

	/**
	 * 默认构造器人
	 */
	public EmployeeConstructorEnhance() {
		// name被初始化位空
		// salary由于没有被显式初始化，仍然被初始化为0
		// id在实例域初始化块中被初始化
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
}
