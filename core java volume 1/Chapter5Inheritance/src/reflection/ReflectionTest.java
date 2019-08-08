package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 利用反射分析类的能力.
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
			Class cl = Class.forName(name);		// 根据类名获取这个类
			Class supercl = cl.getSuperclass();	// 获取超类
			String modifiers = Modifier.toString(cl.getModifiers());
			if(modifiers.length()>0) {			// 输出这个类的修饰符
				System.out.print(modifiers + " ");
			}
			System.out.print("class "+name);	// 输出类名
			if(supercl != null && supercl != Object.class) {	// 判断是否存在非Object的超类，如果有输出继承
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
	 * 输出class的构造器.
	 * @param cl
	 */
	public static void printConstructors(Class cl) {
		Constructor[] constructors = cl.getDeclaredConstructors();	// 返回包含Constructor对象的数组吗
		
		for(Constructor c : constructors) {
			String name = c.getName();		// 获取构造器的名称
			System.out.print("  ");	
			String modifiers = Modifier.toString(c.getModifiers());	// 获取构造器的修饰符
			if(modifiers.length() > 0) {	// 输出构造器的修饰符
				System.out.print(modifiers + " ");
			}

			System.out.print(name + "(");
			Class[] paramTypes = c.getParameterTypes();	// 获取并输出构造器的参数列表
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
	 * 输出类的方法.
	 * @param cl
	 */
	public static void printMethods(Class cl) {
		Method[] methods = cl.getDeclaredMethods();	// 获取类的所有方法，返回Method[]数组
		
		for(Method m : methods) {
			Class retType = m.getReturnType();	// 获取方法的返回类型
			String name = m.getName();			// 获取方法的名称
			
			System.out.print("  ");
			String modifiers = Modifier.toString(m.getModifiers());	// 获取方法的修饰符
			if(modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			
			System.out.print(retType.getName() + " " + "(");
			Class[] paramTypes = m.getParameterTypes();	// 获取方法的参数列表并进行输出
			for(int j=0;j<paramTypes.length;j++) {
				if(j > 0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	/**
	 * 输出类的域
	 * @param cl
	 */
	public static void printFields(Class cl) {
		Field[] fields = cl.getFields();	// 获得该类的所有域
		
		for(Field f:fields) {
			Class type = f.getType();	// 获取域的类型
			String name = f.getName();	// 获取域的名称
			System.out.print("  ");
			String modifiers = Modifier.toString(f.getModifiers());	// 获取域的修饰符
			if(modifiers.length()>0) {
				System.out.print(modifiers + " ");
			}
			System.out.println(type.getName() + " " + name + ";");	
		}
		
	}
	
	
}
