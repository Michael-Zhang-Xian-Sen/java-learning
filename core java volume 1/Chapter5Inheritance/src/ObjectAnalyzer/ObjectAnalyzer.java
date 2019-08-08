package ObjectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {
	private ArrayList<Object> visited = new ArrayList<>();
	
	public String toString(Object obj) {
		
		// 对象为空 返回null
		if(obj == null) {
			return "null";
		}
		
		// 对象已经访问过了 返回...
		if(visited.contains(obj)) {
			return "...";
		}
		
		// 标记当前对象为已访问
		visited.add(obj);
		
		Class cl = obj.getClass();	// 获取这对对象对应的类
		if(cl == String.class) {	
			return (String)obj;
		}
		
		if(cl.isArray()) {			// 如果是数组
			String r = cl.getComponentType() + "[]{";
			for(int i=0;i<Array.getLength(obj);i++) {
				if(i >0) {
					r += ",";
				}
				Object val = Array.get(obj, i);
				if(cl.getComponentType().isPrimitive()) {	// 如果是基本类型，直接加
					r += val;
				}else {
					r += toString(val);						// 不是基本类型，使用toString()方法
				}
			}
			return r + "}";
		}
		
		String r = cl.getName();
		do {
			r += "[";
			Field[] fields = cl.getDeclaredFields();
			AccessibleObject.setAccessible(fields,  true);	// 设置fields即使是私有也可查询和设置
			for(Field f:fields) {
				if(!Modifier.isStatic(f.getModifiers())) {	// 如果修饰符不是static
					if(!r.endsWith("[")) {					// 如果字符串不是以"["后缀结尾 
						r += ".";
					}
					r += f.getName() + "=";					// 获取这个域的名字
					try {
						Class t = f.getType();				// 返回标识此域的类
						Object val = f.get(obj);			// 返回对象obj表示的字段的值？
						if(t.isPrimitive()) {				// 如果t为基本类型
							r += val;
						}else {
							r += toString(val);
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			r += "]";
			cl = cl.getSuperclass();
		}while(cl != null);
		
		return r;
	}
}


