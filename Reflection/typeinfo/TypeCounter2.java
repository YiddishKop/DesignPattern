package typeinfo;
import java.util.*;

public class TypeCounter2 extends HashMap<Class<?>, Integer>{
	private Class<?> baseType; // ����ָ���������ĵĻ���
	public TypeCounter2(Class<?> baseType) {
		this.baseType = baseType;
	}
	public void count(Object obj) {
		Class<?> type = obj.getClass();        // ����һֱǿ���� Class<?> �ȵ���ʹ�� Class ��
		                                       // ��Ȼ��ʾ�Ķ����������͵�Class��Ϣ
		                                       // ? �����ʾͨ���
		if (!baseType.isAssignableFrom(type)){ // �ж� baseType�Ƿ��ǲ���type�ĸ����ͬ��Ķ�������
			                                   // ������ǣ����׳��쳣
										       // ����ǣ�����������õ�����
			throw new RuntimeException(
					obj + " incorrect type: " + type + 
					", should be type or subtype of " + baseType); 
		}
		countClass(type);                      // ���ﲻ�����ü��������Ǽ�����Ӧ�õ�����
	}
	
	private void countClass(Class<?> type) {
		Integer quantity = get(type);
		put(type, quantity == null ? 1 : quantity + 1); // ���ü�ֵ�ԣ��������������1����������Ϊ1.
		Class<?> superClass = type.getSuperclass();     // 
		if(superClass != null &&                        // ע��������������ã�ֻ�е������ʹ������ǻ��������ʱ�Ż�ִ��
				baseType.isAssignableFrom(superClass)) {
			countClass(superClass);                     // ���˰������ǵݹ鰡����
		}
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder("{");
		for (Map.Entry<Class<?>, Integer> pair : entrySet()) {
			result.append(pair.getKey().getSimpleName());
			result.append("=");
			result.append(pair.getValue());
			result.append(", ");
		}
		result.delete(result.length() - 2, result.length());
		result.append("}");
		return result.toString();
	}
}
