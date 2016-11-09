package holding;
import typeinfo.pets.*;
import java.util.*;


/**
 * @author yiddi
 * �������壺 Iterator ͳһ�������ķ��ʷ�ʽ��
 * һ��Կ��(Iterator)�ܿ����з���(����)����,ȥ������Ķ���(����Ԫ��)
 * �ؼ������ַ�ʽ�кܶ���չ�ռ䣬�������ﺯ����һ��IteratorΪ������
 * ��ô����������������˷�����������Ԫ�صġ����������������ߡ�ֻ��Ҫͨ����
 * �������ͬ������Iterator���ɡ��������������
 */
public class CrossContainerIteration {
	public static void display(Iterator<Pet> it) {
		while (it.hasNext()) {
			Pet p = it.next();
			System.out.println(p.id() + ":" + p + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		ArrayList<Pet> pets = Pets.arrayList(8);
		LinkedList<Pet> petsLL = new LinkedList<Pet>(pets);
		HashSet<Pet> petsHS = new HashSet<Pet>(pets);
		TreeSet<Pet> petsTS = new TreeSet<Pet>(pets);
		display(pets.iterator());
		display(petsLL.iterator());
		display(petsHS.iterator());
		display(petsTS.iterator());
	}
}
