package holding;
import typeinfo.pets.*;
import java.util.*;

/**
 * @author yiddi
 * �������壺�����˸���ǿ��ĵ�����---ListIterator,�����������
 *  - ��ɫ�� ˫���ƶ�������ɾ�ġ��ɻ������
 *  - hasNext() / hasPrevious()
 *  - next() / previous()
 *  - nextIndex() itor�ƶ�����һ��λ��ʱ��index
 *  - previousIndex() �����⡿��ǰitor��index����ʼΪ-1
 *  - remove()
 *  - add()
 *  - set() 
 *  - <Collection>.listIterator(n) 
 */
public class ListIteration {
	public static void main(String[] args) {
		List<Pet> pets = Pets.arrayList(8);
		System.out.println(pets);
		ListIterator<Pet> it = pets.listIterator();
		System.out.println(it.nextIndex());
		System.out.println(it.previousIndex());
		while (it.hasNext()) {
			System.out.println(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + "; ");
		}
		System.out.println(it);
		System.out.println();
		// �������
		while (it.hasPrevious()) { 
			System.out.println(it.previous() + " ");//TODO ���ﲻ���Ϊʲô���ܷ��ʵ�ĩβԪ��
			                                        // �ѵ�����Ϊһ����⵽tail or head iterator�ͱ����õ� next/previousλ�ã�
			                                        // ������ô˵����Ȼ�ѽ⣬��������˵�������õı�������
		}
		System.out.println();
		System.out.println(pets);
		it = pets.listIterator(3);  // ����ע�͸����� position in the list
		                            // ������ index in the list
		/*
		 * �������������ɼ���
		 * <Collection>.listIterator(n)�е� n ȡֵ��Χ��[1, length]
		 * ���Բ�����λ�ã��������������Ｋ���׳���һ��ע��
		 * iterator�����������Ǵ� 0 ��ʼ
		 */
//		it = pets.listIterator(8); // OK
//		it = pets.listIterator(9); // java.lang.IndexOutOfBoundsException
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
			it.set(Pets.randomPet());
		}
		System.out.println(pets);
	}

}
