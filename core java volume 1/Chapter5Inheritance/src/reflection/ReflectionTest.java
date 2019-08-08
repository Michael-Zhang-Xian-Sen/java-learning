package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * ���÷�������������.
 * @author Himory
 */
public class ReflectionTest {
	public static void main(String[] args) {
		String name;
		if(args.length>0) {
			name = args[0];
		}else {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter class name (e.g. java.util.Date):");
			name = in.next();
		}
		
		try {
			Class cl = Class.forName(name);		// ����������ȡ�����
			Class supercl = cl.getSuperclass();	// ��ȡ����
			String modifiers = Modifier.toString(cl.getModifiers());
			if(modifiers.length()>0) {			// ������������η�
				System.out.print(modifiers + " ");
			}
			System.out.print("class "+name);	// �������
			if(supercl != null && supercl != Object.class) {	// �ж��Ƿ���ڷ�Object�ĳ��࣬���������̳�
				System.out.print("extends " + supercl.getName());
			}
			
			System.out.print("\n{\n");
			printConstructors(cl);
			System.out.println();
			printMethods(cl);
			System.out.println();
			printFields(cl);
			System.out.println("}");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	/**
	 * ���class�Ĺ�����.
	 * @param cl
	 */
	public static void printConstructors(Class cl) {
		Constructor[] constructors = cl.getDeclaredConstructors();	// ���ذ���Constructor�����������
		
		for(Constructor c : constructors) {
			String name = c.getName();		// ��ȡ������������
			System.out.print("  ");	
			String modifiers = Modifier.toString(c.getModifiers());	// ��ȡ�����������η�
			if(modifiers.length() > 0) {	// ��������������η�
				System.out.print(modifiers + " ");
			}

			System.out.print(name + "(");
			Class[] paramTypes = c.getParameterTypes();	// ��ȡ������������Ĳ����б�
			for(int j=0; j<paramTypes.length; j++) {
				if(j > 0) {
					System.out.print(", ");
				}
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	/**
	 * �����ķ���.
	 * @param cl
	 */
	public static void printMethods(Class cl) {
		Method[] methods = cl.getDeclaredMethods();	// ��ȡ������з���������Method[]����
		
		for(Method m : methods) {
			Class retType = m.getReturnType();	// ��ȡ�����ķ�������
			String name = m.getName();			// ��ȡ����������
			
			System.out.print("  ");
			String modifiers = Modifier.toString(m.getModifiers());	// ��ȡ���������η�
			if(modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			
			System.out.print(retType.getName() + " " + "(");
			Class[] paramTypes = m.getParameterTypes();	// ��ȡ�����Ĳ����б��������
			for(int j=0;j<paramTypes.length;j++) {
				if(j > 0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	/**
	 * ��������
	 * @param cl
	 */
	public static void printFields(Class cl) {
		Field[] fields = cl.getFields();	// ��ø����������
		
		for(Field f:fields) {
			Class type = f.getType();	// ��ȡ�������
			String name = f.getName();	// ��ȡ�������
			System.out.print("  ");
			String modifiers = Modifier.toString(f.getModifiers());	// ��ȡ������η�
			if(modifiers.length()>0) {
				System.out.print(modifiers + " ");
			}
			System.out.println(type.getName() + " " + name + ";");	
		}
		
	}
	
	
}
