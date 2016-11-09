package holding;
import java.util.*;


/**
 * @author yiddi
 * 程序意义： 介绍PriorityQueue，以及其两种CTOR
 * 给出的是另一种 PriorityQueue 的构造函数，        
 * - 该构造函数第一个参数指定了PriorityQueue的初始容量   
 * - 第二个参数是一个 Comparator 对象，用做权限级别的根据  
 * ----------------------------------------
 * - <String>.split(<regex>);把字符串按照regex匹配并分割成多个字符串，该函数返回一个String数组
 */
public class PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		Random rand = new Random(47);
		for (int i = 0; i < 10; i++) {
			priorityQueue.offer(rand.nextInt(i + 10)); // 向priorityQueu中添加10个随机数
		}
		QueueDemo.printQ(priorityQueue);
		
		// 向PriorityQueue插入乱序数字，打印整个队列
		// 新建权限队列，更改PriorityQueue的comparator对象
		// 再打印整个队列
		List<Integer> ints = Arrays.asList(25,22,20,18,
				14,9,3,1,1,2,3,9,14,18,21,23,25);
		priorityQueue = new PriorityQueue<Integer>(ints);
		QueueDemo.printQ(priorityQueue);
		/*
		 * 给出的是另一种 PriorityQueue 的构造函数，
		 * - 该构造函数第一个参数指定了PriorityQueue的初始容量
		 * - 第二个参数是一个 Comparator 对象，用做权限级别的根据
		 */
		priorityQueue = new PriorityQueue<Integer>(ints.size(), Collections.reverseOrder()); // Collections还有逆向功能的函数
		priorityQueue.addAll(ints);
		QueueDemo.printQ(priorityQueue);
		
		String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
		List<String> strings = Arrays.asList(fact.split("")); // split函数把fact按字符分割，并返回
		System.out.println(strings);
		//PriorityQueue也复合容器特点：直接从其他容器引用创建对象
		PriorityQueue<String> stringPQ = new PriorityQueue<String>(strings);
		QueueDemo.printQ(stringPQ);
		
		Set<Character> charSet = new HashSet<Character>();
		for (char c : fact.toCharArray()) {
			charSet.add(c);
		}
		PriorityQueue<Character> characterPQ = new PriorityQueue<Character>(charSet);
		QueueDemo.printQ(characterPQ);
		
	}
	public PriorityQueueDemo() {
		// TODO Auto-generated constructor stub
	}

}
