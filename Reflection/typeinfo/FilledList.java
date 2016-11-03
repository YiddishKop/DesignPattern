package typeinfo;
import java.util.*;

class CountedInteger {
	private static long counter;
	private final long id = counter++; // 先返回 counter的值给 id，之后 counter 自增1
	public String toString() {
		return Long.toString(id);      // 这个也很有意思
	}
}

// TODO 2016-11-02 重新实现一遍，太具有特色了
public class FilledList<T> {
	private Class<T> type;   // 这个域很有意思，直接根据泛型的类型规定了这个List的元素的类型
	public FilledList(Class<T> type) {
		this.type = type;
	}
	
	public List<T> create(int nElements){
		List<T> result = new ArrayList<T>();
		try {
			for (int i = 0; i < nElements; i++) {
				result.add(type.newInstance());  // 1. 用这种方式创建对象并添加到ArrayList中
				                                 //    这种写法像是“武林高手”的上乘外功，
				                                 //    不论元素类型是什么，都会正确创建该对象
				                                 // 2. T obj = (T)new Object();
				                                 //    用这种方式实现就实在太丑了
				                                 // 3. 仍要注意 默认构造器的问题
			}
		}catch (Exception e) {
			throw new RuntimeException();
		}
		return result;
	}
	public static void main(String[] args) {
		FilledList<CountedInteger> fl = 
				new FilledList<CountedInteger>(CountedInteger.class);
		System.out.println(fl.create(15));       // 成功创建了15个这种对象
	}
}
