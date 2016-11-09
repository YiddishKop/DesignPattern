package holding;
import typeinfo.pets.*;
import java.util.*;
import static net.mindview.util.Print.*;

public class ListFeatures {
	public static void main(String[] args) {
		Random rand = new Random(47); // 47 ֻ��һ�� random seed����ͬ��seedÿ�ζ��������ͬ���������
		                              // ����������ȫ�ģ�α��������Ͳ����κβ����������Ứ��ϵͳ 1 nanoTime��ʱ��
		List<Pet> pets = Pets.arrayList(7);
		System.out.println("1: " + pets);
		Hamster h = new Hamster();
		pets.add(h); // List���Զ�����
		System.out.println("2: " + pets);
		System.out.println("3: " + pets.contains(h));  // ����list�Ƿ����ĳ��Ԫ��
		pets.remove(h);                                // ����listɾ��ĳ��Ԫ��
		Pet p = pets.get(2);
		System.out.println("4: " + p + " " + pets.indexOf(p)); // ���ݶ�����������ȡ����λ������
		                                                       // ��ɾ��ĳ�� list �е�Ԫ�أ������Ȼ�ȡ������
		Pet cymric = new Cymric();
		System.out.println("5: " + pets.indexOf(cymric));
		System.out.println("5: " + pets.remove(cymric));
		pets.add(3, new Mouse()); // ��ĳ������λ�ò���һ��Ԫ�أ�ԭ�����λ�ô�ŵ�Ԫ�ؼ���֮���Ԫ�أ�����ƶ�һ������λ��
		System.out.println("9: " + pets);
		List<Pet> sub = pets.subList(1, 4); // ��ԭ��list������(û�п����γ��µ�list)������ head �� tail ָ�룬�γ�һ�����¡�list
		                                    // ����Ҫע�⣬��û�С��½��ɡ�һ��list
		System.out.println("subList " + sub);
		System.out.println("10: " + pets.containsAll(sub));
		Collections.sort(sub); // In-place sort����˵Collection�������㷨����Ҫռ�ö���Ŀռ�
		System.out.println("sorted subList: " + sub);
		System.out.println("10.1: " + pets); // �����б���е����иĶ�����ԭ�б��ж�����ֳ���
		System.out.println("11: " + pets.containsAll(sub)); // ���������ȷ���ģ�����������˵���ǣ�containsAll�Ƕ�
		                                                    // Ԫ�ؼ���ģ����غ�Ԫ��˳��
		Collections.shuffle(sub, rand); // ��ĳ������(sub)����ĳ���������(rand)����ϴ��
		System.out.println("shuffled subList: " + sub);
		List<Pet> copy = new ArrayList<Pet>(pets); // �����������������������г�ʼ��
		                                           // ���ַ��������������ж����ã�list��list��set��list��ets..
		                                           // TODO �������Ȼֻ�ǿ�����һ���µġ����á������Բ��ܽС�����������
		                                           // Ӧ�ýС�����������
		System.out.println("a new reference? == " + (pets.get(0) == copy.get(0)));
		System.out.println("a new reference? equals " + (pets.get(0).equals(copy.get(0))));
		sub = Arrays.asList(pets.get(1), pets.get(4)); // asList
		System.out.println("sub: " + sub);
		System.out.println("12: " + pets.containsAll(sub));
		copy.retainAll(sub);
		System.out.println("13: " + copy);// ˭���õ� retailAll(),�����ͱ�����˭�ԭ������ȫ�����
		copy = new ArrayList<Pet>(pets);  // ���´�pets����һ���µ�ArrayList
		copy.remove(2);                   // remove by index
		copy.removeAll(sub);
		System.out.println("15: " + copy);
		copy.set(1, new Mouse());
		System.out.println("16: " + copy);
		copy.addAll(2, sub);
		System.out.println("17: " + copy);
		System.out.println("18: " + pets.isEmpty());
		pets.clear();
		System.out.println("19: " + copy);
		pets.addAll(Pets.arrayList(4));
		System.out.println("20: " + pets);
		Object[] o = pets.toArray();
		System.out.println("21: " + o[3]);
		Pet[] pa = pets.toArray(new Pet[0]);// ������ݵ���һ���������ã���ô����ֵ�����Դ�ΪԪ�����͵�����
		
	}
	public ListFeatures() {
		// TODO Auto-generated constructor stub
	}

}
