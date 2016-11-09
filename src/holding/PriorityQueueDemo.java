package holding;
import java.util.*;


/**
 * @author yiddi
 * �������壺 ����PriorityQueue���Լ�������CTOR
 * ����������һ�� PriorityQueue �Ĺ��캯����        
 * - �ù��캯����һ������ָ����PriorityQueue�ĳ�ʼ����   
 * - �ڶ���������һ�� Comparator ��������Ȩ�޼���ĸ���  
 * ----------------------------------------
 * - <String>.split(<regex>);���ַ�������regexƥ�䲢�ָ�ɶ���ַ������ú�������һ��String����
 */
public class PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		Random rand = new Random(47);
		for (int i = 0; i < 10; i++) {
			priorityQueue.offer(rand.nextInt(i + 10)); // ��priorityQueu�����10�������
		}
		QueueDemo.printQ(priorityQueue);
		
		// ��PriorityQueue�����������֣���ӡ��������
		// �½�Ȩ�޶��У�����PriorityQueue��comparator����
		// �ٴ�ӡ��������
		List<Integer> ints = Arrays.asList(25,22,20,18,
				14,9,3,1,1,2,3,9,14,18,21,23,25);
		priorityQueue = new PriorityQueue<Integer>(ints);
		QueueDemo.printQ(priorityQueue);
		/*
		 * ����������һ�� PriorityQueue �Ĺ��캯����
		 * - �ù��캯����һ������ָ����PriorityQueue�ĳ�ʼ����
		 * - �ڶ���������һ�� Comparator ��������Ȩ�޼���ĸ���
		 */
		priorityQueue = new PriorityQueue<Integer>(ints.size(), Collections.reverseOrder()); // Collections���������ܵĺ���
		priorityQueue.addAll(ints);
		QueueDemo.printQ(priorityQueue);
		
		String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
		List<String> strings = Arrays.asList(fact.split("")); // split������fact���ַ��ָ������
		System.out.println(strings);
		//PriorityQueueҲ���������ص㣺ֱ�Ӵ������������ô�������
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
