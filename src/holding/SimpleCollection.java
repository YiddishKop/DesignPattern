package holding;
import java.util.*;

public class SimpleCollection {
	public static void main(String[] args) {
		Collection<Integer> c = new ArrayList<Integer>();
//		Set是接口，肯定不能直接创建对象，而只能把某个容器的索引声明为Set
//		Collection<Integer> s = new Set<Integer>();
		Set<Integer> si = new HashSet<Integer>();
		for (int i = 0; i < 10; i++) {
			c.add(i);
			si.add(i);
		}
		// 给 set 中添加3，失效。虽然不报错，但是3并没有添加进set中
		si.add(3);
		for (Integer i : c) {
			System.out.println(i + ", ");
		}
		for (Integer i : si) {
			System.out.println(i + ", ");
		}
	}
}
