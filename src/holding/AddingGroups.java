package holding;
import java.util.*;

public class AddingGroups {
	public static void main(String[] args) {
		// Arrays.asList����һ�����ŷָ����б�����תΪList,�������List��ʼ��һ��ArrayList����
		// ����һ��һ��һ��Ҫע�⣬Arrays.asList���ص���һ���̶�������list��fixed-size list.
		// ����԰���(Arrays.asList)��Ϊ����������CTOR�������ݣ�������ֱ������(Arrays.asList)��
		// ���Ԫ���ǲ����Եģ�һ������ִ�о͹̶������ˣ��������ɸ�,��ֵ���add���У���removeҲ������
		// ���Ա�Arrays.asList()ת�����list��ֻ��ִ��list.set()����������֮��TODO�����ɼӲ��ɼ���ֻ�ܸġ�
		// ����Collection.toArray()һ�𣬳䵱Array��Collection֮���໥ת��������
		Collection<Integer> collection = 
				new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)); 
		Integer[] moreInts = {6, 7, 8, 9, 10};
		// ����Collection���󶼿��԰ѱ��˵�����Ԫ�أ�ȫ���������Լ�������������
		// ����<collection����>.addAll();
		collection.addAll(Arrays.asList(moreInts));
		// ��ȻaddAllҲ��[Collections](��Collection��ͬ)�����ľ�̬�����������㲻����ô��
		Collections.addAll(collection, 11,12,13,14,15);
		Collections.addAll(collection, moreInts);
		System.out.println(collection);
		
		// ���� java.lang.UnsupportedOperationException, ����Array.asListת�����������ɱ�
		// System.out.println(Arrays.asList(1,2,3,4).add(3));
		
		// Produces a list "backed by" an array:
		List<Integer> list = Arrays.asList(16,17,18,19,20);
		list.set(1, 99); // OK -- modify an element
		// ���� java.lang.UnsupportedOperationException������Array.asListת�����������ɱ�
		// list.remove(0);
		// ���� java.lang.UnsupportedOperationException������Array.asListת�����������ɱ�
		// list.add(21); 
	}
}
