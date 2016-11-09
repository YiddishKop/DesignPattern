package holding;
import java.util.*;

/**
 * @author yiddi
 * 程序意义： 用 LinkedList 向上转型为Queue
 *  - 介绍了Queue的几种方法：
 *  	- <queue>.offer();   // 添加队尾
 *      - <queue>.element(); // 不移除并返回队头，空返回异常
 *      - <queue>.peek();    // 不移除并返回队头，空返回null
 *      - <queue>.poll();    // 移除并返回队头，空返回null
 *      - <queue>.remove();  // 移除并返回队头，空返回异常
 */
public class QueueDemo {
	public static void printQ(Queue queue) {
		while (queue.peek() != null) {
			System.out.print(queue.remove() + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Random rand = new Random(47);
		for (int i = 0; i < 10; i++) {
			queue.offer(rand.nextInt(i + 10));         // 产生 0~ i+10 的随机数
		}
		System.out.println(queue);
		Queue<Character> qc = new LinkedList<Character>();
		for (char c : "Brontosaurus".toCharArray()) {  // 字符串到字符数组 经常用到
			qc.offer(c);
		}
		System.out.println(qc);
	}
	public QueueDemo() {
		// TODO Auto-generated constructor stub
	}

}
