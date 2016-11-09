package holding;
import typeinfo.pets.*;
import java.util.*;

/**
 * @author yiddi
 * �ڱ�д��������صĺ���ʱ�������ֲ�����ѡ��
 * 1. ���������������
 * 2. ��������������
 * �����ֲ���������ָIterator���������Ը�<���Ͳ���>
 * �����ַ�ʽ������ʵ��һ��ͨ�ñ�̵�˼��
 */
public class InterfaceVsIterator {
	public static void display(Iterator<Pet> it) {  // ��������Ϊ����
		while (it.hasNext()) {
			Pet p = it.next();
			System.out.println(p.id() + ":" + p + " ");
		}
		System.out.println();
	}
	public static void display(Collection<Pet> pets) { // ������Ϊ����
		for (Pet p : pets) {
			System.out.println(p.id() + ":" + p + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		List<Pet> petList = Pets.arrayList(8);
		Set<Pet> petSet = new HashSet<Pet>(petList);
		Map<String,Pet> petMap = new LinkedHashMap<String,Pet>();
		String[] names = ("Ralph, Eric, Robin, Lacey, " + "Britney, Sam, Spot, Fluffy").split(", ");
		for (int i = 0; i < names.length; i++) {
			petMap.put(names[i], petList.get(i));
		}
		display(petList);
		display(petSet);
		display(petList.iterator());
		display(petSet.iterator());
		System.out.println(petMap);
		System.out.println(petMap.keySet());
		display(petMap.values());
		display(petMap.values().iterator());
	}

}
