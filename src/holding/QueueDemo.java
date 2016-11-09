package holding;
import java.util.*;

/**
 * @author yiddi
 * �������壺 �� LinkedList ����ת��ΪQueue
 *  - ������Queue�ļ��ַ�����
 *  	- <queue>.offer();   // ��Ӷ�β
 *      - <queue>.element(); // ���Ƴ������ض�ͷ���շ����쳣
 *      - <queue>.peek();    // ���Ƴ������ض�ͷ���շ���null
 *      - <queue>.poll();    // �Ƴ������ض�ͷ���շ���null
 *      - <queue>.remove();  // �Ƴ������ض�ͷ���շ����쳣
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
			queue.offer(rand.nextInt(i + 10));         // ���� 0~ i+10 �������
		}
		System.out.println(queue);
		Queue<Character> qc = new LinkedList<Character>();
		for (char c : "Brontosaurus".toCharArray()) {  // �ַ������ַ����� �����õ�
			qc.offer(c);
		}
		System.out.println(qc);
	}
	public QueueDemo() {
		// TODO Auto-generated constructor stub
	}

}
