package holding;
import java.util.*;

public class SimpleCollection {
	public static void main(String[] args) {
		Collection<Integer> c = new ArrayList<Integer>();
//		Set�ǽӿڣ��϶�����ֱ�Ӵ������󣬶�ֻ�ܰ�ĳ����������������ΪSet
//		Collection<Integer> s = new Set<Integer>();
		Set<Integer> si = new HashSet<Integer>();
		for (int i = 0; i < 10; i++) {
			c.add(i);
			si.add(i);
		}
		// �� set �����3��ʧЧ����Ȼ����������3��û����ӽ�set��
		si.add(3);
		for (Integer i : c) {
			System.out.println(i + ", ");
		}
		for (Integer i : si) {
			System.out.println(i + ", ");
		}
	}
}
