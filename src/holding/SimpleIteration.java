package holding;
import typeinfo.pets.*;
import java.util.*;

public class SimpleIteration {
	/*
	 * ʹ�� Iterator���������裺
	 *  1. ���� Iterator
	 *  2. �� <Collection>.iterator() ���г�ʼ��
	 *  3. ���� Iterator.hasNext()/.next()/.remove()
	 */
	// ͨ����������ӿ��Կ�����Iterator�е�����Collection��ָ�룬��ʼλ����-1.
	// ��ȷ�� hasNext��ʱ��it.next()��Ȼ����һ��Ԫ�أ���������ָ��ָ����һ��λ��
	// ͬʱ��removeҲֻ��remove��ǰ��iteratorָ���λ�õ�Ԫ�ء�����ֻ��ִ��һ�Ρ�
	public static void main(String[] args) {
		List<Pet> pets = Pets.arrayList(12);
		Iterator<Pet> it = pets.iterator();
		while (it.hasNext()) {
			Pet p = it.next();
			System.out.println(p.id() + ":" + p + " ");
		}
		System.out.println();
		// A simpler apporach, when possible:
		for (Pet p : pets) {
			System.out.println(p.id() + ":" + p + " ");
		}
		System.out.println();
		it = pets.iterator();
		for (int i = 0; i < 6; i++) {
			it.next();
			it.remove();
		}
		System.out.println(it.next());
		System.out.println(pets);
	}
}
