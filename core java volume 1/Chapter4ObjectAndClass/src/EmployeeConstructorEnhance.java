import java.util.Random;

public class EmployeeConstructorEnhance {
	private static int nextId = 1;	// ��̬�����������࣬����ʵ������һ����

	private String name = "";
	private double salary;
	private int id;
	
	/**
	 *  ��̬���ʼ���顣��ʼ��nextId����10000�������ȡһ������ֵ��
	 */
	static {
		Random generator = new Random();
		nextId = generator.nextInt(10000);
	}
	
	/**
	 * ʵ�����ʼ����
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
	 * �ڸù����������ݲ����������������������й��졣
	 * @param s
	 */
	public EmployeeConstructorEnhance(double s) {
		this("Employee #"+nextId,s);
	}

	/**
	 * Ĭ�Ϲ�������
	 */
	public EmployeeConstructorEnhance() {
		// name����ʼ��λ��
		// salary����û�б���ʽ��ʼ������Ȼ����ʼ��Ϊ0
		// id��ʵ�����ʼ�����б���ʼ��
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
