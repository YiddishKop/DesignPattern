package holding;
import java.util.*;

/**
 * @author yiddi
 * 程序意义：产生0~20之间的随机数一万次，统计每个数字出现次数，以此辨别Random的随机性。
 * - 重点在于Map可以建立对象与对象之间的联系，这给程序构造带来了非常丰富的想象空间
 * - <map>.put(K,V) 用于向map插入
 * - <map>.get(K)   用于通过Key获取value
 * 
 */
public class Statistics {
	public static void main(String[] args) {
		Random rand = new Random(47);
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		System.out.println(m);
		for (int i = 0; i < 10000; i++) {
			// produce a number between 0 and 20
			int r = rand.nextInt(20); // 通过rand种子随机产生0~20作为key
			Integer freq = m.get(r);  // 通过key获取value的值，如果为null则置1，否则自增1
			m.put(r, (freq == null ? 1 : freq+1));
		}
		System.out.println(m);
	}
	public Statistics() {
		// TODO Auto-generated constructor stub
	}

}
