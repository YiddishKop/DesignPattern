package holding;
import java.util.*;

/**
 * @author yiddi
 * �������壺����0~20֮��������һ��Σ�ͳ��ÿ�����ֳ��ִ������Դ˱��Random������ԡ�
 * - �ص�����Map���Խ������������֮�����ϵ���������������˷ǳ��ḻ������ռ�
 * - <map>.put(K,V) ������map����
 * - <map>.get(K)   ����ͨ��Key��ȡvalue
 * 
 */
public class Statistics {
	public static void main(String[] args) {
		Random rand = new Random(47);
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		System.out.println(m);
		for (int i = 0; i < 10000; i++) {
			// produce a number between 0 and 20
			int r = rand.nextInt(20); // ͨ��rand�����������0~20��Ϊkey
			Integer freq = m.get(r);  // ͨ��key��ȡvalue��ֵ�����Ϊnull����1����������1
			m.put(r, (freq == null ? 1 : freq+1));
		}
		System.out.println(m);
	}
	public Statistics() {
		// TODO Auto-generated constructor stub
	}

}
