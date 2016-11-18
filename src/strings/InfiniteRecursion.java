package strings;
import java.util.*;

/**
 * @author yiddi
 * 程序意义： 
 * 1. String + Object = String + Object.toString()
 * 2. 如何打印list中对象的内存地址
 */
public class InfiniteRecursion {
	public String toString() {
		// 经典例子，String对象与 this相加，会调用this的toString()方法，来转换类型
		// this.toString()还是在调用自身，如此陷入死循环。
		// 那怎么办呢？
		// 
		return " InfiniteRecursion address: " + super.toString() + "\n";
	}
	public static void main(String[] args) {
		Object obj = new Object();
		System.out.println(obj);
		List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
		for (int i = 0; i < 10; i++) {
			v.add(new InfiniteRecursion());
		}
		System.out.println(v);
	}
}
