package typeinfo;
import java.util.*;

class CountedInteger {
	private static long counter;
	private final long id = counter++; // �ȷ��� counter��ֵ�� id��֮�� counter ����1
	public String toString() {
		return Long.toString(id);      // ���Ҳ������˼
	}
}

// TODO 2016-11-02 ����ʵ��һ�飬̫������ɫ��
public class FilledList<T> {
	private Class<T> type;   // ����������˼��ֱ�Ӹ��ݷ��͵����͹涨�����List��Ԫ�ص�����
	public FilledList(Class<T> type) {
		this.type = type;
	}
	
	public List<T> create(int nElements){
		List<T> result = new ArrayList<T>();
		try {
			for (int i = 0; i < nElements; i++) {
				result.add(type.newInstance());  // 1. �����ַ�ʽ����������ӵ�ArrayList��
				                                 //    ����д�����ǡ����ָ��֡����ϳ��⹦��
				                                 //    ����Ԫ��������ʲô��������ȷ�����ö���
				                                 // 2. T obj = (T)new Object();
				                                 //    �����ַ�ʽʵ�־�ʵ��̫����
				                                 // 3. ��Ҫע�� Ĭ�Ϲ�����������
			}
		}catch (Exception e) {
			throw new RuntimeException();
		}
		return result;
	}
	public static void main(String[] args) {
		FilledList<CountedInteger> fl = 
				new FilledList<CountedInteger>(CountedInteger.class);
		System.out.println(fl.create(15));       // �ɹ�������15�����ֶ���
	}
}
