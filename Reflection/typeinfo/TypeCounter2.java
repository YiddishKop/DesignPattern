package typeinfo;
import java.util.*;

public class TypeCounter2 extends HashMap<Class<?>, Integer>{
	private Class<?> baseType; // 用于指定你所关心的基类
	public TypeCounter2(Class<?> baseType) {
		this.baseType = baseType;
	}
	public void count(Object obj) {
		Class<?> type = obj.getClass();        // 作者一直强调用 Class<?> 比单单使用 Class 好
		                                       // 虽然表示的都是任意类型的Class信息
		                                       // ? 这里表示通配符
		if (!baseType.isAssignableFrom(type)){ // 判定 baseType是否是参数type的父类或同类的对象引用
			                                   // 如果不是，则抛出异常
										       // 如果是，则计数该引用的类型
			throw new RuntimeException(
					obj + " incorrect type: " + type + 
					", should be type or subtype of " + baseType); 
		}
		countClass(type);                      // 这里不是引用计数，而是计数该应用的类型
	}
	
	private void countClass(Class<?> type) {
		Integer quantity = get(type);
		put(type, quantity == null ? 1 : quantity + 1); // 设置键值对，如果存在则自增1；否则设其为1.
		Class<?> superClass = type.getSuperclass();     // 
		if(superClass != null &&                        // 注意这里的条件设置：只有当父类型存在且是基类的子类时才会执行
				baseType.isAssignableFrom(superClass)) {
			countClass(superClass);                     // 搞了半天这是递归啊。。
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
