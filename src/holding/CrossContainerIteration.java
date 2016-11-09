package holding;
import typeinfo.pets.*;
import java.util.*;


/**
 * @author yiddi
 * 程序意义： Iterator 统一了容器的访问方式，
 * 一把钥匙(Iterator)能开所有房间(容器)的锁,去拿里面的东西(容器元素)
 * 关键是这种方式有很多扩展空间，比如这里函数以一个Iterator为参数，
 * 那么这个【函数】就有了访问所有容器元素的【能力】，【调用者】只需要通过赋
 * 予参数不同容器的Iterator即可【激活】这种能力。
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
