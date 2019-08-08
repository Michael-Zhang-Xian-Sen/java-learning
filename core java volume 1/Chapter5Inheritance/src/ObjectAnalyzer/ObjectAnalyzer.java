package ObjectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {
	private ArrayList<Object> visited = new ArrayList<>();
	
	public String toString(Object obj) {
		
		// ����Ϊ�� ����null
		if(obj == null) {
			return "null";
		}
		
		// �����Ѿ����ʹ��� ����...
		if(visited.contains(obj)) {
			return "...";
		}
		
		// ��ǵ�ǰ����Ϊ�ѷ���
		visited.add(obj);
		
		Class cl = obj.getClass();	// ��ȡ��Զ����Ӧ����
		if(cl == String.class) {	
			return (String)obj;
		}
		
		if(cl.isArray()) {			// ���������
			String r = cl.getComponentType() + "[]{";
			for(int i=0;i<Array.getLength(obj);i++) {
				if(i >0) {
					r += ",";
				}
				Object val = Array.get(obj, i);
				if(cl.getComponentType().isPrimitive()) {	// ����ǻ������ͣ�ֱ�Ӽ�
					r += val;
				}else {
					r += toString(val);						// ���ǻ������ͣ�ʹ��toString()����
				}
			}
			return r + "}";
		}
		
		String r = cl.getName();
		do {
			r += "[";
			Field[] fields = cl.getDeclaredFields();
			AccessibleObject.setAccessible(fields,  true);	// ����fields��ʹ��˽��Ҳ�ɲ�ѯ������
			for(Field f:fields) {
				if(!Modifier.isStatic(f.getModifiers())) {	// ������η�����static
					if(!r.endsWith("[")) {					// ����ַ���������"["��׺��β 
						r += ".";
					}
					r += f.getName() + "=";					// ��ȡ����������
					try {
						Class t = f.getType();				// ���ر�ʶ�������
						Object val = f.get(obj);			// ���ض���obj��ʾ���ֶε�ֵ��
						if(t.isPrimitive()) {				// ���tΪ��������
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


