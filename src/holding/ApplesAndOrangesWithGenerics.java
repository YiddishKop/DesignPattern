// 关于容器的简单例子，会产生异常
//{ThrowsException}
package holding;
import java.util.*;

class Apple{
	private static long counter;
	private final long id = counter++;  // 一个static量表示为诸对象共享，表示对象总量。
	                                    // 一个final 量标识对象id，一旦初始化不可更改。
	public long id() {return id;}
}

class Orange{}

public class ApplesAndOrangesWithGenerics {
//	@SuppressWarnings("unchecked")    // 这个注解是说，unchecked异常可以不警告
	public static void main(String[] args) {
		ArrayList apples = new ArrayList();
		for (int i = 0; i < 3; i++) {
			apples.add(new Apple());
		}
		// ArrayList不会阻止往其中加入 Orange 对象
		apples.add(new Orange());
		for (int i = 0; i < 3; i++) {
			/*
			 * 这里没有使用泛型（指明容器内元素的类型），
			 * 所以通过get获取的对象必须进行类型转换，方可使用其函数
			 */
			System.out.println(((Apple)apples.get(i)).id()); 
			// Orange 只会在运行时被检测出来
		}
		System.out.println(apples);
	}

}
