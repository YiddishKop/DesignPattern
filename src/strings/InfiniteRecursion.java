package strings;
import java.util.*;

/**
 * @author yiddi
 * �������壺 
 * 1. String + Object = String + Object.toString()
 * 2. ��δ�ӡlist�ж�����ڴ��ַ
 */
public class InfiniteRecursion {
	public String toString() {
		// �������ӣ�String������ this��ӣ������this��toString()��������ת������
		// this.toString()�����ڵ����������������ѭ����
		// ����ô���أ�
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
